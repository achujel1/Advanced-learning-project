package main.exceptions;

public class WrongFileExceptions extends Exception {
	public static final long serialVersionUID = 42L;

	@Override
	public String getMessage() {
		return "You chose the wrong file!";
	}

}
