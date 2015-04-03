package main;

import java.util.ArrayList;

import main.calculator.Calculator;
import main.calculator.CalculatorButtonNames;
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
	 * This is a method which is working with enumeration
	 * 
	 * Mainly setting the name of the button through enumeration's class CalculatorButtonNames
	 * 
	 */
	private static void workingWithEnumertaion() {
		CalculatorButtonsSet calc = new CalculatorButtonsSet();
		calc.addCalculator(CalculatorButtonNames.ONE, 1, 0x00000);
		calc.addCalculator(CalculatorButtonNames.TWO, 2, 0x0123123);
		calc.addCalculator(CalculatorButtonNames.THREE, 3, 0x0123123);
		calc.addCalculator(CalculatorButtonNames.FOUR, 4, 0x0123123);
		calc.addCalculator(CalculatorButtonNames.FIVE, 5, 0x0123123);
		calc.reportCalculator();
	}

	/**
	 * This is a method which is testing how anonymous inner classes work
	 */
	private static void testingAnonymousInnerClasses() {
		Calculator calc = new Calculator("hey");
	}

	/**
	 * This is a method which is testing how local classes work
	 */
	private static void testingLocalClasses() {
		Calculator calc = new Calculator();
	}

	/**
	 * This is a method in which I'm testing how member classes work
	 * 
	 * I'm creating an object calc, later adding more objects with method
	 * addCalculator() and printing out the values of the object with method
	 * reportCalculator()
	 * 
	 * This test required commenting other classes and methods, so if you want
	 * to work with this again, you will need to comment some code
	 */
	private static void testingMemberClasses() {
		CalculatorButtonsSet calc = new CalculatorButtonsSet();
		calc.addCalculator("one", 1, 0x000000);
		calc.addCalculator("two", 2, 0x001000);
		calc.addCalculator("three", 3, 0x000020);
		calc.addCalculator("four", 4, 0x091292);
		calc.addCalculator("five", 5, 0x765849);
		calc.reportCalculator();
	}

	/**
	 * Here I'm testing how instance field initializers work
	 */
	private static void testingInstanceFieldInitializers() {
		ArrayList<Calculator> button = new CalculatorButtonsSet(2, "one", 1,
				0x000000).button;
		for (Calculator calculator : button) {
			System.out.println("This is the name of a button: "
					+ calculator.buttonName);
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
			System.out.println("Printing out the button numbers: "
					+ calculatorTwo.buttonNumber);
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
		testingMemberClasses();
		testingLocalClasses();
		testingAnonymousInnerClasses();
		workingWithEnumertaion();
	}

}
