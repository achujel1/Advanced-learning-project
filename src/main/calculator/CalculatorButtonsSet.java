/**
 * 
 */
package main.calculator;

import java.util.ArrayList;

/**
 * This is a class for work with an ArrayLists of Calculator buttons
 * 
 * @author Adminas
 *
 */
public class CalculatorButtonsSet {

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("This is a main method.");
	}

	public ArrayList<Calculator> button;

	{
		button = new ArrayList<>();
		button.add(new Calculator());
	}

	/**
	 * Constructor with no arguments
	 */
	public CalculatorButtonsSet() {
		System.out.println("Constructor CalculatorButtonsSet called!");
	}

	/**
	 * Constructor with 4 arguments
	 * 
	 * @param numberOfButtons
	 *            number of buttons to create
	 * @param buttonNumber
	 *            name of the button
	 * @param buttonValue
	 *            number of the button
	 * @param buttonColor
	 *            color of the button
	 */
	public CalculatorButtonsSet(int numberOfButtons, String buttonName,
			int buttonNumber, long buttonColor) {
		for (int i = 1; i <= numberOfButtons; i++) {
			button.add(new Calculator(buttonName, buttonNumber, buttonColor));
		}
	}

	/**
	 * This is a method for adding Calculator objects
	 * 
	 * @param buttonName
	 *            name of the button
	 * @param buttonNumber
	 *            number of the button
	 * @param buttonColor
	 *            color of the button
	 */
	public void addCalculator(String buttonName, int buttonNumber,
			long buttonColor) {
		button.add(new Calculator(buttonName, buttonNumber, buttonColor));
	}

	/**
	 * This is a method which is printing all the members of the class
	 * Calculator
	 */
	public void reportCalculator() {
		for (Calculator calculator : button) {
			System.out.println("Button name: " + calculator.buttonName);
		}
	}

	/**
	 * This is Calculator class for work with numbers
	 * 
	 * I'm commenting this code for future use, now I don't need it
	 * 
	 * @author Adminas
	 *
	 */
	/*
	 * public class Calculator {
	 * 
	 * public String buttonName = ""; public int buttonNumber = 0; public long
	 * buttonColor = 0x000000;
	 * 
	 * Calculator() { System.out
	 * .println("Constructor Calculator() with no arguments called!"); }
	 *//**
	 * Constructor with one argument
	 * 
	 * @param buttonName
	 *            name of the button
	 */
	/*
	 * public Calculator(String buttonName) { this.buttonName = buttonName; }
	 *//**
	 * Constructor with two arguments
	 * 
	 * @param buttonName
	 *            name of the button
	 * @param buttonNumber
	 *            number of the button
	 */
	/*
	 * public Calculator(String buttonName, int buttonNumber) {
	 * this(buttonName); this.buttonNumber = buttonNumber; }
	 *//**
	 * Constructor with three arguments
	 * 
	 * @param buttonName
	 *            name of the button
	 * @param buttonNumber
	 *            number of the button
	 * @param buttonColor
	 *            color of the button
	 */
	/*
	 * public Calculator(String buttonName, int buttonNumber, long buttonColor)
	 * { this(buttonName, buttonNumber); this.buttonColor = buttonColor; }
	 * 
	 * }
	 */
}
