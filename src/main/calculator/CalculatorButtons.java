package main.calculator;

import java.util.ArrayList;

/**
 * Class for Calculator buttons 
 * 
 * @author Adminas
 *
 */
public class CalculatorButtons {
	public static ArrayList<Calculator> button;

	static {
		button = new ArrayList<>();
		button.add(new Calculator("One", 1, 0x00FF00));
		button.add(new Calculator("Two", 2, 0x00FF01));
		button.add(new Calculator("Three", 3, 0x00FF02));
	}
}
