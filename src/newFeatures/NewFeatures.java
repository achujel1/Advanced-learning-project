package newFeatures;

import java.io.FileInputStream;
import java.util.ArrayList;

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
		System.out.println("Value in list:" + list.get(0));
		System.out.println(list);
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
		System.out.println(i);
		i = 10_000_00;
		System.out.println(i);
		System.out.println("Class NewFeatures, method testingTryCatch done!");
	}

	/**
	 * Testing how switch with String is working in Java7
	 */
	public void testingSwitchWithStringStatemant() {
		System.err
				.println("Class NewFeatures, method testingSwitchWithStringStatement called!");
		String randomString = new String("hey");
		switch (randomString) {
		case "hey":
			System.out.println("String " + randomString + " called!");
			break;
		default:
			System.out.println("");
			break;
		}
		System.out
				.println("Class NewFeatures, method testingSwitchWithStringStatement done!");
	}

}
