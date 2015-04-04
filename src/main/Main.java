package main;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import main.calculator.Calculator;
import main.calculator.CalculatorAction;
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
		// TODO finish with this
		workingWithInheritanceTreesNavigation();
	}

	/**
	 * This is a method in which I'm working with inheritance trees' navigation
	 * 
	 * I will assume that with code in try/catch block no exception can occur
	 * and leave it with a bug
	 */
	private static void workingWithInheritanceTreesNavigation() {
		Object random = new CalculatorAction();

		Class<?> classOne = random.getClass();
		System.out.println(classOne);
		System.out.println(classOne.getName());
		System.out.println(classOne.getSimpleName());

		Class<?> classTwo = classOne.getSuperclass();
		System.out.println(classTwo);
		System.out.println(classTwo.getName());
		System.out.println(classTwo.getSimpleName());

		Class<?> classThree = classTwo.getSuperclass();
		System.out.println(classThree);
		System.out.println(classThree.getName());
		System.out.println(classThree.getSimpleName());

		try {
			Class<?> classFour = classThree.getSuperclass();
			System.out.println(classFour);
			System.out.println(classFour.getName());
			System.out.println(classFour.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This is method in which I'm testing the work with dynamical classes
	 * instantiation
	 * 
	 * @throws SecurityException
	 */
	private static void workingWithDynamicalInstantiationOfClasses()
			throws SecurityException {
		CalculatorButtonsSet calc = new CalculatorButtonsSet();
		Class<?> c = calc.getClass();
		Constructor<?>[] constructors = c.getConstructors();
		System.out
				.println("This is the length of the construscots in the calss: "
						+ constructors.length);
		System.out.println("This is the name of the constructor in order: ");
		for (int i = 0; i < constructors.length; i++) {
			System.out.println(i + 1 + ". " + constructors[i]);
		}

		Constructor<?> con = constructors[0];

		Object obj = null;

		try {
			obj = con.newInstance(4, "one", 3, 0x00000);
			System.out.println(obj);
		} catch (Exception e) {
			System.out.println("Main.main() error!");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This is a class which is working with The Class
	 * 
	 * Mainly it's testing reflection API and capabilities
	 */
	private static void workingWithTheClass() {
		CalculatorButtonsSet calc = new CalculatorButtonsSet();
		Class<?> c = calc.getClass();
		System.out
				.println("Getting the name of the class with its full path and name: "
						+ c);
		System.out
				.println("Getting the full name of the class: " + c.getName());
		System.out.println("Getting the path of the class with its name: "
				+ c.getSimpleName());
	}

	/**
	 * This is a method which is working with enumeration
	 * 
	 * Mainly setting the name of the button through enumeration's class
	 * CalculatorButtonNames
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
		workingWithTheClass();
		workingWithDynamicalInstantiationOfClasses();
	}

}
