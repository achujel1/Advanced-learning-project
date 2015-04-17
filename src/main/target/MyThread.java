package main.target;

public class MyThread extends Thread {

	// Couple of variables
	private int threadId;
	private TargetClass target;

	// Constructor who initiates the values
	public MyThread(int threadId, TargetClass target) {
		this.threadId = threadId;
		this.target = target;
	}

	/**
	 * Method which is synchronizing the workflow of the threads
	 */
	@Override
	public void run() {
		// Still no idea what synchronized does
		synchronized (target) {
			try {
				// Stops program for 2 secs
				sleep(1000);
			} catch (InterruptedException e) {
				// Some track trace
				e.printStackTrace();
			}
			// Calling the method in targeted class TargetClass
			target.call(threadId);
		}
	}

}
