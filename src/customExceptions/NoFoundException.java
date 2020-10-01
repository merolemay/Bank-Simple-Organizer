package customExceptions;

public class NoFoundException extends Exception {

	public NoFoundException() {
		super();
	}

	public String message() {

		return "El usuario no existe";
	}

}
