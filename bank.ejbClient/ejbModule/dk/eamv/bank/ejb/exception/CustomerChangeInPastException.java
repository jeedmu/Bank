package dk.eamv.bank.ejb.exception;

public class CustomerChangeInPastException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerChangeInPastException()
	{
		super("Cannot add customer changes that will take place before the current time");
	}
}
