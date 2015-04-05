package main.calculator;

/**
 * This is Calculator class for work with numbers
 * 
 * @author Adminas
 *
 */
public class Calculator implements Comparable<Calculator> {

	public String buttonName = "";
	public int buttonNumber = 0;
	public long buttonColor = 0x000000;
	public CalculatorButtonNames enumerationButtonName;

	/**
	 * Constructor!
	 */
	public Calculator() {
		/**
		 * This is an experimental class to play with local classes
		 * 
		 * @author Adminas
		 *
		 */
		class CallingConstructor {
			public void caller() {
				System.out
						.println("Calculator constructor with no arguments called!");
			}
		}
		new CallingConstructor().caller();
		System.out
				.println("Constructor Calculator() with no arguments called!");
	}

	/**
	 * Constructor with one argument
	 * 
	 * @param buttonName
	 *            name of the button
	 */
	public Calculator(String buttonName) {
		/**
		 * This is anonymous inner class which is created for test purposes
		 * 
		 * @author Adminas
		 *
		 */
		new Object() {
			public void caller() {
				System.out
						.println("Calculator constructor with one argument called!");
			}
		}.caller();
		this.buttonName = buttonName;
	}

	/**
	 * Constructor with two arguments
	 * 
	 * @param buttonName
	 *            name of the button
	 * @param buttonNumber
	 *            number of the button
	 */
	public Calculator(String buttonName, int buttonNumber) {
		this(buttonName);
		this.buttonNumber = buttonNumber;
	}

	/**
	 * Constructor with three arguments
	 * 
	 * @param buttonName
	 *            name of the button
	 * @param buttonNumber
	 *            number of the button
	 * @param buttonColor
	 *            color of the button
	 */
	public Calculator(String buttonName, int buttonNumber, long buttonColor) {
		this(buttonName, buttonNumber);
		this.buttonColor = buttonColor;
	}

	/**
	 * Constructor for work with enumeration class
	 * 
	 * @param buttonName
	 *            name of the button from enumeration class
	 *            CalculatorButtonNames
	 * @param buttonNumber
	 *            number of the button
	 * @param buttonColor
	 *            color of the button
	 */
	public Calculator(CalculatorButtonNames enumerationButtonName,
			int buttonNumber, long buttonColor) {
		this.enumerationButtonName = enumerationButtonName;
		this.buttonNumber = buttonNumber;
		this.buttonColor = buttonColor;
	}

	/**
	 * This is a method which is working with enumeration names
	 * 
	 * Creates this to experiment with TreeSet
	 * 
	 * @param enumerButtonName
	 *            this is name of the button from enumeration class
	 *            CalculatorButtonNames
	 */
	public Calculator(CalculatorButtonNames enumerButtonName) {
		this.enumerationButtonName = enumerButtonName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.enumerationButtonName.toString();
	}

	@Override
	public int compareTo(Calculator o) {
		String s1 = this.getClass().getSimpleName();
		String s2 = o.getClass().getSimpleName();
		return s1.compareTo(s2);
	}
}
