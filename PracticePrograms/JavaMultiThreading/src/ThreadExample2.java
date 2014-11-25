
class Y3 implements Runnable {
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

class ThreadExample2 {
	public static void main(String[] args) {
		Y3 y3 = new Y3();
		y3.bar();
	}
}