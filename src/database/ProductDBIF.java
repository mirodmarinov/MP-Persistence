package database;

import model.Product;

public interface ProductDBIF
{
	Product findProductByNumber(String productNumber);
}
