package exceptions;

/**
 * An exception for no customer found
 * @author Group1 dmai0920
 */
public class CustomerNotFoundException extends Exception
{
	public CustomerNotFoundException(String message)
	{
		super(message);
	}
}