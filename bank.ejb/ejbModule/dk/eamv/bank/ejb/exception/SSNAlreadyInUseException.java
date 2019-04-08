package dk.eamv.bank.ejb.exception;

public class SSNAlreadyInUseException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SSNAlreadyInUseException()
	{
		super("A user with the given social security number is already registered");
	}
}
