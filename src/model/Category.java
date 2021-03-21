package model;

/**
 * @author Group1 dmai0920
 * A class representing the categories of products
 */
public enum Category
{
	//The types, Clothing with id 1, Equipment 2, and Gun replicas with id 3
	CLOTHING(1),
	EQUIPMENT(2),
	GUN_REPLICA(3);
	
	//Category numbers field
	private int categoryID;
	
	//Constructor setting the ID
	Category(int categoryID)
	{
		this.categoryID = categoryID;
	}
	
	//A getter for the ID
	public int getCategory()
	{
		return this.categoryID;
	}
}

