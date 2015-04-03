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
	ONE("one"), TWO("two"), THREE("three"), FOUR("four"), 
	FIVE("five"), SIX("six"), SEVEN("seven"), EIGHT("eight"), NINE("nine"), TEN("ten");
	
	private String calculatorButtonName;

	private CalculatorButtonNames(String calculatorButtonName){
		this.calculatorButtonName = calculatorButtonName;
	}

	@Override
	public String toString() {
		return calculatorButtonName;
	}
}
