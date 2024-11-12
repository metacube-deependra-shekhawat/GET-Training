/** POJO Class of the Category */
public class Category {
	private String parentCategory;
	private int noOfChildren;

	/**
	 * Constructor of Category
	 * 
	 * @param parentCategory parent Category name
	 * @param noOfChildren   no of children of parent category
	 */
	public Category(String parentCategory, int noOfChildren) {
		this.parentCategory = parentCategory;
		this.noOfChildren = noOfChildren;
	}

	/**
	 * @return the parentCategory
	 */
	String getParentCategory() {
		return parentCategory;
	}

	/**
	 * @param parentCategory the parentCategory to set
	 */
	void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}

	/**
	 * @return the noOfChildren
	 */
	int getNoOfChildren() {
		return noOfChildren;
	}

	/**
	 * @param noOfChildren the noOfChildren to set
	 */
	void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	@Override
	public String toString() {
		return "parentCategory=" + parentCategory + ", noOfChildren=" + noOfChildren;
	}

}
