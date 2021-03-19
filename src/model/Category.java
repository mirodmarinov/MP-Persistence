package model;

public class Category {

	private int categoryNumber;
	private String name;
	
	public Category(int categoryNumber, String name) {
		this.setCategoryNumber(categoryNumber);
		this.setName(name);
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
