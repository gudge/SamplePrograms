
class Y extends Thread {
	public void run() {
		System.out.println("Y thread " + this.getId());
	}

	void bar() {
		try {
			this.start();
			this.join();
		} catch (InterruptedException e) {
			System.out.println("Caught");
		}
	}
}

class Y2 implements Runnable {
	public void run() {
		System.out.println("Y2 thread ");
	}
	void bar() {
		Thread t = new Thread(this);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Y4 {
	void foo() {}
}

public class ThreadExample {
	public static void main(String[] args) throws InterruptedException {
		Y y = new Y();
		y.bar();
		Y2 y2 = new Y2();
		y2.bar();
		Y4 y4 = new Y4();
		y4.wait();
	}
}