package exceptions;

/**
 * An exception for an invalid product ID
 * @author Group1 dmai0920
 */
public class InvalidProductNumberException extends Exception
{
	public InvalidProductNumberException(String message)
	{
		super(message);
	}
}
