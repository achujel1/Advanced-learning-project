package main.thread;

public class MyThread extends Thread {

	public void run() {
		int iterations = 5; // number of iterations
		try { // try-catch block
			for (int i = 0; i < iterations; i++) {
				System.out.println(i + 1 + " From secondary thread"); // puts text to
																// screen
				sleep(1000); // sleeps for 1 second, doesn't do anything
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
