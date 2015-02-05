import java.util.concurrent.Semaphore;

class MySemaphore2 {
	private final Semaphore eq = new Semaphore(5);
	private final Semaphore fq = new Semaphore(1);
	private final Semaphore uq = new Semaphore(0);


	void produce(int i) throws InterruptedException {
		eq.acquire();
		fq.acquire();
		System.out.println("Put things into queue " + i);
		fq.release();
		uq.release();
	}

	void consume(int i) throws InterruptedException {
		uq.acquire();
		fq.acquire();
		System.out.println("Consume queue " + i);
		fq.release();
		eq.release();
	}
}

class Producer implements Runnable {
	MySemaphore2 q;
	Producer(MySemaphore2 q) {this.q = q;}
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				
				q.produce(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	MySemaphore2 q;
	Consumer(MySemaphore2 q) {
		this.q = q;
	}
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				q.consume(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class MySemaphore {
	public static void main(String[] args) throws InterruptedException {
		MySemaphore2 q = new MySemaphore2();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);

		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);

		t2.start();
		t1.start();

		t1.join();
		t2.join();
		System.out.println("Done\n");
	}
}