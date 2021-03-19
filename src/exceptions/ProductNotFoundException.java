package exceptions;

/**
 * An exception for when the product couldn't be found
 * @author Group1 dmai0920
 */
public class ProductNotFoundException extends Exception
{
	public ProductNotFoundException(String message)
	{
		super(message);
	}
}
