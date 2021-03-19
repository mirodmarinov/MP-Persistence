package exceptions;

/**
 * An exception for invalid stock amount when adding products in the order
 * @author Group1 dmai0920
 */
public class InvalidAmountException extends Exception
{
	public InvalidAmountException(String message)
	{
		super(message);
	}
}
