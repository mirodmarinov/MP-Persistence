package exceptions;

/**
 * An exception for an invalid phone number
 * @author Group1 dmai0920
 */
public class InvalidPhoneNumberException extends Exception
{
	public InvalidPhoneNumberException(String message)
	{
		super(message);
	}
}
