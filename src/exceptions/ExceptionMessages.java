package exceptions;

/**
 * @author Group1 dmai0920
 * A class to hold the different exception messages for easy usage
 */
public class ExceptionMessages
{
	public static final String NO_CUSTOMER_FOUND = "A customer with such number wasn't found, please try again.";
	public static final String INVALID_PHONE_NUMBER = "The phone number contains illegal characters, please make sure that it only contains numbers and a '+' sign.";
	public static final String INVALID_PHONE_LENGHT = "The phone number is invalid lenght! Please make sure it is between 4 and 16 characters.";
	public static final String NO_PRODUCT_FOUND = "A product with such number wasn't found, please try again.";
	public static final String INVALID_PRODUCT_NUMBER = "The product number containt illegal characters, please make sure that it only contains numbers.";
	public static final String NOT_ENOUGH_STOCK = "The chosen amount exceeds the current stock, please make sure the amount is within that stock.";
	public static final String INVALID_PRODUCT_AMOUNT = "The chosen amount contains illegal characters, please make sure that it only contains numbers.";
}