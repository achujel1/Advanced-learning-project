/**
 * 
 */
package main.calculator;

/**
 * This is enumeration class for my calculator button names
 * 
 * Here I will define all the String values of my calculator class
 * 
 * @author Adminas
 *
 */
public enum CalculatorButtonNames {
	ONE("one"), TWO("two"), THREE("three"), FOUR("four"), FIVE("five"), SIX(
			"six"), SEVEN("seven"), EIGHT("eight"), NINE("nine"), TEN("ten"), ZERO(
			"zero");

	private String calculatorButtonName;

	/**
	 * Just a method to get the name of the button
	 * 
	 * @param calculatorButtonName
	 */
	private CalculatorButtonNames(String calculatorButtonName) {
		this.calculatorButtonName = calculatorButtonName;
	}

	// still have no idea why that non-javadoc things is here?
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return calculatorButtonName;
	}

}
