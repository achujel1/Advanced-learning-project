package main.thread;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		int iterations = 5;
		try {
			for (int i = 0; i < iterations; i++) {
				System.out.println(i + 1 + " From runnable");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

}
