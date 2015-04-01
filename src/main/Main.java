package main;

import newFeatures.NewFeatures;

/**
 * This is the main class of the project
 * 
 * @author Adminas
 * @version 1.0
 */
public class Main {
	/**
	 * Main method of the project.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Just putting out some string");
		// Running NewFeatures class
		testingNewFeatures(args);

	}

	/**
	 * This is a method which is calling main method in class NewFeatures
	 * 
	 * @param args
	 */
	private static void testingNewFeatures(String[] args) {
		NewFeatures.main(args);
	}

	public void testedMethods(){
		
	}

}

