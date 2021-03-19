package exceptions;

/**
 * An exception for not enough products in stock
 * @author Group1 dmai0920
 */
public class NotEnoughStockException extends Exception
{
	public NotEnoughStockException(String message)
	{
		super(message);
	}
}
