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
	public CalculatorButtonsSet(){
		System.out.println("Constructor CalculatorButtonsSet called!");
	}

	/**
	 * Constructor with 4 arguments
	 * 
	 * @param numberOfButtons number of buttons to create
	 * @param buttonNumber name of the button
	 * @param buttonValue number of the button
	 * @param buttonColor color of the button
	 */
	public CalculatorButtonsSet(int numberOfButtons, String buttonName, int buttonNumber, long buttonColor){
		for (int i = 1; i <= numberOfButtons; i++) {
			button.add(new Calculator(buttonName, buttonNumber, buttonColor));
		}
	}

}
