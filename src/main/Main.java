package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

import javax.swing.plaf.basic.BasicSliderUI.TrackListener;

import main.calculator.Calculator;
import main.calculator.CalculatorAction;
import main.calculator.CalculatorButtonNames;
import main.calculator.CalculatorButtons;
import main.calculator.CalculatorButtonsSet;
import main.exceptions.WrongFileExceptions;
import main.utils.MyFileReader;
import myFileTree.FileFinder;
import myFileTree.MyFileVisitor;
import newFeatures.NewFeatures;

/**
 * This is the main class of the project
 * 
 * @author Adminas
 * @version 1.0
 */
public class Main {
	/**
	 * Main method of the project.
	 * 
	 * @param args
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws IOException,
			WrongFileExceptions, URISyntaxException {
		// space for future tests

	}

	/**
	 * This method is putting hamlet.xml to buffer and writing it to
	 * newfile.txt. Using FileReader, BufferedReader, FileWriter, BufferedWriter
	 * classes. After everything is done you see message "Completed"
	 */
	private static void workingWithBufferedStreams() {
		try (BufferedReader in = new BufferedReader(
				new FileReader("hamlet.xml"));
				BufferedWriter out = new BufferedWriter(new FileWriter(
						"newfile.txt"));) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			System.out.println("Completed");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is working with file reading and writing from byte to to byte
	 * by character. Most useful classes for file writing/reading in Java are
	 * FileReader and FileWriter
	 */
	private static void workingWithFileReadingAndWritingByCharacter() {
		try (FileReader in = new FileReader("files/beginFolder.txt");
				FileWriter out = new FileWriter("files/endFolder.txt");) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is copying file in binary code
	 */
	private static void workingWithCopyingFilesInBinaryCode() {
		// continue working on this
		// this is part 8.1
		try (FileInputStream in = new FileInputStream("files/beginFolder.txt");
				FileOutputStream out = new FileOutputStream(
						"files/newByteBeginFolder.txt");) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is method which is informing about recent file changes in directory
	 * tree
	 */
	private static void workingWithDirectoryChangesWatch() {
		try (WatchService service = FileSystems.getDefault().newWatchService()) {
			Map<WatchKey, Path> keyMap = new HashMap<>();
			Path path = Paths.get("files");
			keyMap.put(path.register(service,
					StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY), path);
			WatchKey watchKey;
			do {
				watchKey = service.take();
				Path eventDir = keyMap.get(watchKey);
				for (WatchEvent<?> event : watchKey.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					Path eventPath = (Path) event.context();
					System.out.println(eventDir + ": " + kind + ": "
							+ eventPath);
				}
			} while (watchKey.reset());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This is a method which is working with file search in a directory
	 * 
	 * @throws IOException
	 */
	private static void workingWithFileSearch() throws IOException {
		Path fileDir = Paths.get("files");

		FileFinder finder = new FileFinder("testFile.txt");
		Files.walkFileTree(fileDir, finder);

		ArrayList<Path> foundFiles = finder.foundPaths;

		if (foundFiles.size() > 0) {
			for (Path path : foundFiles) {
				System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
			}
		} else {
			System.out.println("No files were found!");
		}
	}

	/**
	 * This is a method which is working with file visiting and going through
	 * file directory tree
	 * 
	 * @throws IOException
	 */
	private static void workingWithFileDiretoryWalking() throws IOException {
		Path fileDir = Paths.get("files");
		MyFileVisitor visitor = new MyFileVisitor();
		Files.walkFileTree(fileDir, visitor);
	}

	/**
	 * This is a method which is working with file reading and writing
	 * 
	 * I'm simply copying words from one file, creating new and pasting copied
	 * words to newly created file
	 */
	private static void workingWithFileWritingAndReading() {
		// TODO read from file, copy text to a new file
		Path source = Paths.get("files/beginFolder.txt");
		System.out.println(source.getFileName());
		Path target = Paths.get("files/endFolder.txt");
		System.out.println(target.getFileName());

		Charset charset = Charset.forName("US-ASCII");
		ArrayList<String> lines = new ArrayList<>();

		try (BufferedReader reader = Files.newBufferedReader(source, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				lines.add(line);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try (BufferedWriter writer = Files.newBufferedWriter(target, charset)) {
			Iterator<String> iterator = lines.iterator();

			while (iterator.hasNext()) {
				String s = iterator.next();
				writer.append(s, 0, s.length());
				writer.newLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This is a method which is working with file management
	 * 
	 * I have a file I copy the file Copy text from it Add new directory with
	 * the word in copiedFile Delete copied file
	 * 
	 * @throws IOException
	 */
	private static void workingWithFileAndDirectoryManagement()
			throws IOException {
		// TODO create a method which is working with files:
		// reading, copying the text inside, creating a new directory with the
		// name of the inside of the file and deleting a random file

		Path source = Paths.get("files/testFile.txt");
		System.out.println("Name of the file: " + source.getFileName());
		String fileContent = MyFileReader.readFile("files/testFile.txt");
		System.out.println("File content: " + fileContent);

		Path target = Paths.get("files/newTestFile.txt");
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		System.out
				.println("File content: " + fileContent
						+ " copied and new file with name " + fileContent
						+ " created!");

		Path newDir = Paths.get("files/", fileContent);
		Files.createDirectories(newDir);
		System.out.println("Directory with the name " + fileContent
				+ " was created");

		Files.move(source, newDir.resolve(source.getFileName()),
				StandardCopyOption.REPLACE_EXISTING);
		System.out.println("File " + source.toString()
				+ " has been successfully moved to " + newDir.toString() + "!");

		Path toDelete = Paths.get(target.toString());
		Files.delete(toDelete);
		System.out.println("File " + toDelete.toString()
				+ " was successfully deleted!");
	}

	/**
	 * This is a method which is working with path class
	 * 
	 * It's much better to use path class rather than other file management
	 * class
	 * 
	 * @throws IOException
	 */
	private static void workingWithPathClass() throws IOException {
		Path path = Paths.get("src/main/Data.txt");
		System.out.println(path.toString());
		System.out.println(path.getFileName());
		System.out.println(path.getNameCount());
		System.out.println(path.getName(path.getNameCount() - 1));

		Path realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
		System.out.println(realPath);
	}

	/**
	 * This is a method which is working with Exception definition and throwing
	 * 
	 * I've defined an exception and tested how it works
	 * 
	 * @throws IOException
	 */
	private static void workingWithDefinitionAndThrowingOfExceptions()
			throws IOException {
		String fileContencts = MyFileReader
				.readFile("src/main/ExceptionText.txt");
		System.out.println(fileContencts);

		try {
			if (fileContencts.equals("exceptiona message")) {
				System.out.println("File read fine");
			} else {
				throw (new WrongFileExceptions());
			}
		} catch (WrongFileExceptions e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @throws IOException
	 */
	private static void workingWithTryWithResourcesBlock() throws IOException {
		try (FileReader fr = new FileReader("src/main/Data.txt");
				BufferedReader br = new BufferedReader(fr);) {
			String s1;
			while ((s1 = br.readLine()) != null) {
				System.out.println(s1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("All good!");
	}

	/**
	 * This is a method which is working with finally try/catch keyword
	 * 
	 * It helps if I want to execute some code whether or not my code executed
	 * exception
	 * 
	 * @throws IOException
	 */
	private static void workingWIthFinally() throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("src/main/Data.txt");
			br = new BufferedReader(fr);
			String s1;
			while ((s1 = br.readLine()) != null) {
				System.out.println(s1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				fr.close();
			}
			if (br != null) {
				br.close();
			}
		}
		System.out.println("All good!");
	}

	/**
	 * This is a method which is working with assert method. I'm simply trying
	 * to set some values and control error flow
	 */
	private static void workingWithAssert() {
		String s1 = "40";
		assert checkInput(s1);
		System.out.println(s1);
	}

	/**
	 * This is a method which helps me to know if something got wrong with
	 * setting the value
	 * 
	 * @param s1
	 */
	private static boolean checkInput(String s1) {
		try {
			Integer.parseInt(s1);
			return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This is a method which is working with queues
	 * 
	 * I add a couple of objects and print them out, than remove one with method
	 * peek() which removes the last object from the linkedList and print out
	 * the removed element with the linkedList which has left
	 */
	private static void workingWithQueues() {
		LinkedList<Calculator> calc = new LinkedList<>();

		calc.add(new CalculatorAction());
		calc.add(new CalculatorAction());
		calc.add(new CalculatorAction());

		display(calc);
		Calculator calcTwo = calc.peek();
		System.out.println(calcTwo.enumerationButtonName.toString());
		display(calc);
	}

	/**
	 * This is a method in which I'm working with linkedList
	 * 
	 * I create a couple of methods and test the results with method display
	 */
	private static void workingWithLinkedList() {
		LinkedList<Calculator> calc = new LinkedList<>();

		calc.add(new CalculatorAction());
		calc.add(new CalculatorAction());
		calc.add(new CalculatorAction());

		display(calc);

	}

	/**
	 * This is a method to display all of the enumerationButtonNames in gives
	 * object
	 * 
	 * @param calc
	 *            Collection data type object from class Calculator
	 */
	static public void display(Collection<Calculator> calc) {
		System.out.println("LinkedList order: ");
		Iterator<Calculator> ite = calc.iterator();
		while (ite.hasNext()) {
			Calculator calculator = (Calculator) ite.next();
			System.out.println(calculator.enumerationButtonName.toString());
		}

	}

	/**
	 * This is a method in which I'm working with treeSet
	 * 
	 * I'm simply testing the input and output
	 */
	private static void workingWithTreeSet() {
		Calculator one = new CalculatorAction();
		Calculator two = new CalculatorAction();
		Calculator three = new CalculatorAction();

		TreeSet<Calculator> calc = new TreeSet<>();

		try {
			calc.add(two);
			calc.add(one);
			calc.add(three);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(calc);
	}

	/**
	 * This is a method which is working with hash set
	 * 
	 * It creates a couple of objects, tests adding and removing
	 * 
	 * Prints out the results
	 */
	private static void workingWithHashSet() {
		Calculator one = new CalculatorAction();
		Calculator two = new CalculatorAction();
		Calculator three = new CalculatorAction();

		HashSet<Calculator> calc = new HashSet<>();

		calc.add(one);
		System.out.println("There are " + calc.size() + " objects in hash set");

		calc.add(two);
		calc.add(three);
		System.out.println("There are " + calc.size() + " objects in hash set");

		calc.remove(two);
		System.out.println("There are " + calc.size() + " objects in hash set");

		System.out.println(calc);
	}

	/**
	 * This is a method in which I'm working with inheritance trees' navigation
	 * 
	 * I will assume that with code in try/catch block no exception can occur
	 * and leave it with a bug
	 */
	private static void workingWithInheritanceTreesNavigation() {
		Object random = new CalculatorAction();

		Class<?> classOne = random.getClass();
		System.out.println(classOne);
		System.out.println(classOne.getName());
		System.out.println(classOne.getSimpleName());

		Class<?> classTwo = classOne.getSuperclass();
		System.out.println(classTwo);
		System.out.println(classTwo.getName());
		System.out.println(classTwo.getSimpleName());

		Class<?> classThree = classTwo.getSuperclass();
		System.out.println(classThree);
		System.out.println(classThree.getName());
		System.out.println(classThree.getSimpleName());

		try {
			Class<?> classFour = classThree.getSuperclass();
			System.out.println(classFour);
			System.out.println(classFour.getName());
			System.out.println(classFour.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This is method in which I'm testing the work with dynamical classes
	 * instantiation
	 * 
	 * @throws SecurityException
	 */
	private static void workingWithDynamicalInstantiationOfClasses()
			throws SecurityException {
		CalculatorButtonsSet calc = new CalculatorButtonsSet();
		Class<?> c = calc.getClass();
		Constructor<?>[] constructors = c.getConstructors();
		System.out
				.println("This is the length of the construscots in the calss: "
						+ constructors.length);
		System.out.println("This is the name of the constructor in order: ");
		for (int i = 0; i < constructors.length; i++) {
			System.out.println(i + 1 + ". " + constructors[i]);
		}

		Constructor<?> con = constructors[0];

		Object obj = null;

		try {
			obj = con.newInstance(4, "one", 3, 0x00000);
			System.out.println(obj);
		} catch (Exception e) {
			System.out.println("Main.main() error!");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This is a class which is working with The Class
	 * 
	 * Mainly it's testing reflection API and capabilities
	 */
	private static void workingWithTheClass() {
		CalculatorButtonsSet calc = new CalculatorButtonsSet();
		Class<?> c = calc.getClass();
		System.out
				.println("Getting the name of the class with its full path and name: "
						+ c);
		System.out
				.println("Getting the full name of the class: " + c.getName());
		System.out.println("Getting the path of the class with its name: "
				+ c.getSimpleName());
	}

	/**
	 * This is a method which is working with enumeration
	 * 
	 * Mainly setting the name of the button through enumeration's class
	 * CalculatorButtonNames
	 * 
	 */
	private static void workingWithEnumertaion() {
		CalculatorButtonsSet calc = new CalculatorButtonsSet();
		calc.addCalculator(CalculatorButtonNames.ONE, 1, 0x00000);
		calc.addCalculator(CalculatorButtonNames.TWO, 2, 0x0123123);
		calc.addCalculator(CalculatorButtonNames.THREE, 3, 0x0123123);
		calc.addCalculator(CalculatorButtonNames.FOUR, 4, 0x0123123);
		calc.addCalculator(CalculatorButtonNames.FIVE, 5, 0x0123123);
		calc.reportCalculator();
	}

	/**
	 * This is a method which is testing how anonymous inner classes work
	 */
	private static void testingAnonymousInnerClasses() {
		Calculator calc = new Calculator("hey");
	}

	/**
	 * This is a method which is testing how local classes work
	 */
	private static void testingLocalClasses() {
		Calculator calc = new Calculator();
	}

	/**
	 * This is a method in which I'm testing how member classes work
	 * 
	 * I'm creating an object calc, later adding more objects with method
	 * addCalculator() and printing out the values of the object with method
	 * reportCalculator()
	 * 
	 * This test required commenting other classes and methods, so if you want
	 * to work with this again, you will need to comment some code
	 */
	private static void testingMemberClasses() {
		CalculatorButtonsSet calc = new CalculatorButtonsSet();
		calc.addCalculator("one", 1, 0x000000);
		calc.addCalculator("two", 2, 0x001000);
		calc.addCalculator("three", 3, 0x000020);
		calc.addCalculator("four", 4, 0x091292);
		calc.addCalculator("five", 5, 0x765849);
		calc.reportCalculator();
	}

	/**
	 * Here I'm testing how instance field initializers work
	 */
	private static void testingInstanceFieldInitializers() {
		ArrayList<Calculator> button = new CalculatorButtonsSet(2, "one", 1,
				0x000000).button;
		for (Calculator calculator : button) {
			System.out.println("This is the name of a button: "
					+ calculator.buttonName);
		}
	}

	/**
	 * Using static initializers
	 */
	private static void testingStaticInitializers() {
		ArrayList<Calculator> button = CalculatorButtons.button;
		button.add(new Calculator("Four", 4, 0x001234));
		for (Calculator calculator : button) {
			System.out.println("Printing out the button name: "
					+ calculator.buttonName);
		}
		ArrayList<Calculator> buttonTwo = CalculatorButtons.button;
		for (Calculator calculatorTwo : buttonTwo) {
			System.out.println("Printing out the button numbers: "
					+ calculatorTwo.buttonNumber);
		}
	}

	/**
	 * This is a method which is calling main method in class NewFeatures
	 * 
	 * @param args
	 */
	private static void testingNewFeatures(String[] args) {
		NewFeatures.main(args);
	}

	/**
	 * This is a method where I put ALL of the tested methods
	 * 
	 * @param args
	 * @throws IOException
	 */
	public void testedMethods(String[] args) throws IOException {
		// Running NewFeatures class
		testingNewFeatures(args);
		testingStaticInitializers();
		testingInstanceFieldInitializers();
		testingMemberClasses();
		testingLocalClasses();
		testingAnonymousInnerClasses();
		workingWithEnumertaion();
		workingWithTheClass();
		workingWithDynamicalInstantiationOfClasses();
		workingWithInheritanceTreesNavigation();
		workingWithHashSet();
		workingWithTreeSet();
		workingWithLinkedList();
		workingWithQueues();
		workingWithAssert();
		// here you might see an error with method "workingWithFinally() because
		// it need IOExceptions throwing
		workingWIthFinally();
		workingWithTryWithResourcesBlock();
		workingWithDefinitionAndThrowingOfExceptions();
		workingWithPathClass();
		workingWithFileAndDirectoryManagement();
		workingWithFileWritingAndReading();
		workingWithFileDiretoryWalking();
		workingWithFileSearch();
		workingWithDirectoryChangesWatch();
		workingWithCopyingFilesInBinaryCode();
		workingWithFileReadingAndWritingByCharacter();
		workingWithBufferedStreams();
	}

}
