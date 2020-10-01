package customExceptions;

public class RepeatUserException extends Exception {



	public RepeatUserException()  {
			
		super();
	}
	
	public String Message(String name ) {
		
		return "El client de cedula: "+ name +" ya está registrado en la base";
	}
}
