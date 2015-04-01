package newFeatures;

import java.io.FileInputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class NewFeatures {

	/**
	 * This is a program which will test new features discussed in Java Advanced
	 * tutorial
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// test method
		NewFeatures newFeatures = new NewFeatures();
		newFeatures.testingArrayList();
		newFeatures.testingTryCatch();
		newFeatures.testingNumericValues();
		newFeatures.testingSwitchWithStringStatemant();

	}

	/**
	 * Testing new ArrayList's features
	 */
	public void testingArrayList() {
		System.err
				.println("Class NewFeatures, method testingArrayList called!");
		// we don't need to write data type two times
		// ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<>();
		list.add("hey");
		list.add("kello");
		list.add("labas");
		System.out.println("\nValue in list:" + list.get(0));
		System.out.println("Printing out the ArrayList: " + list);
		System.out.println("Class NewFeatures, method testingArrayList done!");
	}

	/**
	 * Testing how try/catch block works in Java7
	 */
	public void testingTryCatch() {
		System.err.println("Class NewFeatures, method testingTryCatch called!");
		try (FileInputStream stream = new FileInputStream("hey")) {
			System.out.println("Try/block accessed!");
		} catch (Exception e) {
			Thread.currentThread().getStackTrace();
		}
		System.out.println("Class NewFeatures, method testingTryCatch done!");
	}

	/**
	 * Testing new features of numeric values in Java7
	 */
	public void testingNumericValues() {
		System.err
				.println("Class NewFeatures, method testingNumericValues called!");
		int i = 100000000;

		System.out.println("Iniditalisation: " + i);
		i = 10_000_00;
		System.out.println("After adding '_' value: " + i);
		NumberFormat formatter = NumberFormat.getInstance();
		System.out.println("Formatted value: " + formatter.format(i));
		System.out
				.println("Class NewFeatures, method testingNumericValues done!");
	}

	/**
	 * Testing how switch with String is working in Java7
	 */
	public void testingSwitchWithStringStatemant() {
		System.err
				.println("Class NewFeatures, method testingSwitchWithStringStatement called!");
		ArrayList<String> randomStrings = new ArrayList<>();
		randomStrings.add("hey");
		randomStrings.add("hello");
		randomStrings.add("labas");
		// generating random number and using Random class
		Random generator = new Random();
		switch (randomStrings.get(generator.nextInt(3))) {
		case "hey":
			System.out.println("String "
					+ randomStrings.get(generator.nextInt(3)) + " called!");
			break;
		case "hello":
			System.out.println("String "
					+ randomStrings.get(generator.nextInt(3)) + " called!");
			break;
		case "labas":
			System.out.println("String "
					+ randomStrings.get(generator.nextInt(3)) + " called!");
			break;
		default:
			System.out.println("Nothing has been called!");
			break;
		}
		System.out
				.println("Class NewFeatures, method testingSwitchWithStringStatement done!");
	}

}
