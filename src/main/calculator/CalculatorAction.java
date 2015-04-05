package main.calculator;

/**
 * This is a class in which I will work with calculator's actions like addition,
 * multiplication and etc.
 * 
 * There's a rummor about this class. People say This class doesn't sleep. And
 * does some weird things with your mom at night. Use with caution!
 * 
 * @author Adminas
 *
 */
public class CalculatorAction extends Calculator {
	public CalculatorAction(){
		super(CalculatorButtonNames.ZERO);
		System.out.println("CalculatorAction() construcotor with on arguments called!");
	}
	/**
	 * This is a random constructor to with with no arguments calling
	 */
	// public CalculatorAction() {
	// super(CalculatorButtonNames.ZERO, 0, 0x000000);
	// System.out.println("CalculatorAction constructor with no arguments called!");
	// }
}
