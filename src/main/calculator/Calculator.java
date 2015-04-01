package main.calculator;

/**
 * This is Calculator class for work with numbers
 * 
 * @author Adminas
 *
 */
public class Calculator {

	public String buttonName;
	public int buttonNumber = 0;
	public long buttonColor = 0x000000;

	/**
	 * Constructor with one argument
	 * 
	 * @param buttonName name of the button
	 */
	public Calculator(String buttonName){
		this.buttonName = buttonName;
	}

	/**
	 * Constructor with two arguments
	 * 
	 * @param buttonName name of the button
	 * @param buttonNumber number of the button
	 */
	public Calculator(String buttonName, int buttonNumber){
		this(buttonName);
		this.buttonNumber = buttonNumber;
	}

	/**
	 * Constructor with three arguments
	 * 
	 * @param buttonName name of the button
	 * @param buttonNumber number of the button
	 * @param buttonColor color of the button
	 */
	public Calculator(String buttonName, int buttonNumber, long buttonColor){
		this(buttonName, buttonNumber);
		this.buttonColor = buttonColor;
	}

}
