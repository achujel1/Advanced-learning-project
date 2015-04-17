package main.target;

public class TargetClass {

	public void call(int threadId) {
		// Simply printing out the threadId
		System.out.println("Calling thread from " + threadId);
	}

}
