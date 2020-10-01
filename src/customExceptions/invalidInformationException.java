package customExceptions;

public class invalidInformationException extends Exception {


	public invalidInformationException () {
		super();
		
	}
	
	public String message() {
		
		return "Por favor complete los campos";
	}
}
