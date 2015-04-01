package main;

import java.util.ArrayList;

import main.calculator.Calculator;
import main.calculator.CalculatorButtons;
import main.calculator.CalculatorButtonsSet;
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
		// space for future tests

	}

	/**
	 * Here I'm testing how instance field initializers work
	 */
	private static void testingInstanceFieldInitializers() {
		ArrayList<Calculator> button = new CalculatorButtonsSet(2, "one", 1, 0x000000).button;
		for (Calculator calculator : button) {
			System.out.println("This is the name of a button: " + calculator.buttonName);
		}
	}

	/**
	 * Using static initializers
	 */
	private static void testingStaticInitializers() {
		ArrayList<Calculator> button = CalculatorButtons.button;
		button.add(new Calculator("Four", 4, 0x001234));
		for (Calculator calculator : button) {
			System.out.println("Printing out the button name: "
					+ calculator.buttonName);
		}
		ArrayList<Calculator> buttonTwo = CalculatorButtons.button;
		for (Calculator calculatorTwo : buttonTwo) {
			System.out.println("Printing out the button numbers: " + calculatorTwo.buttonNumber);
		}
	}

	/**
	 * This is a method which is calling main method in class NewFeatures
	 * 
	 * @param args
	 */
	private static void testingNewFeatures(String[] args) {
		NewFeatures.main(args);
	}

	/**
	 * This is a method where I put ALL of the tested methods
	 * 
	 * @param args
	 */
	public void testedMethods(String[] args) {
		// Running NewFeatures class
		testingNewFeatures(args);
		testingStaticInitializers();
		testingInstanceFieldInitializers();
	}

}
