import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Storefront {

	public Connection con;

	public Storefront() {
		try {
			String connectionURL = "jdbc:mysql://localhost:3306/storefront";
			String userName = "root";
			String password = "root";
			con = DriverManager.getConnection(connectionURL, userName, password);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * This method will fetch the list of orders place by a user with specific id
	 * @param userId id of the shopper
	 * @return list of orders placed by a shopper
	 */
	public List<Order> fetchAllOrders(int userId) {
		List<Order> ordersList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet res = null;

		try {
			String query = "SELECT o.id, o.date, o.amount FROM orders o JOIN items i ON o.id = i.orderID WHERE o.userID = ? AND i.status = 'Shipped' ORDER BY o.date";
			ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			res = ps.executeQuery();

			while (res.next()) {
				Order order = new Order(res.getInt("id"), res.getDate("date"), res.getInt("amount"));
				System.out.println(order);
				ordersList.add(order);
			}

		} catch (SQLException sqle) {
			System.out.println("Error: Unable to fetch the records.");
		} finally {
			try {
				res.close();
				ps.close();
			} catch (SQLException e) {
			}
		}
		return ordersList;
	}

	/**
	 * This method will insert multiple images for a specific product with using batch
	 * @param imageUrls list of images urls
	 * @return
	 */
	public boolean insertBatchImage(List<Image> imageUrls) {
		boolean result = false;
		String query = "INSERT INTO images(productID, imageURL) VALUES(?,?)";
		PreparedStatement ps = null;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(query);

			for (Image image : imageUrls) {
				ps.setInt(1, image.getProductId());
				ps.setString(2, image.getUrl());
				ps.addBatch();
			}

			int[] inserts = ps.executeBatch();

			if (inserts.length > 0)
				result = true;

			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println(e1);
			}
			System.out.println(e);
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

		return result;
	}

	/**
	 * This method will delete those products from the product table which has not been purchased in last year
	 * @return an integer representing the number of products deleted
	 */
	public int deleteProducts() {
		PreparedStatement ps = null;
		int noOfDeletedProducts = 0;
		
		try {
			String query = "DELETE FROM product p " + 
							"WHERE id = (SELECT oi.productID FROM orders o " + 
							"RIGHT JOIN items oi ON o.id = oi.productID " + 
							"WHERE DATEDIFF(o.date, NOW()) > 365);";

			ps = con.prepareStatement(query);
			noOfDeletedProducts = ps.executeUpdate();
		} catch (SQLException e) {
				System.out.println(e);
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return noOfDeletedProducts;
	}

	/**
	 * Thise method will return the list Top categories which do not have any parent category along with count of subcategories of each category
	 * @return list of Categories
	 */
	public List<Category> categoryList() {
		List<Category> categoryList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet res = null;

		try {
			String query = "SELECT c1.categoryName, COUNT(c2.id) AS ChildCount FROM category c1 " + 
							"JOIN category c2 ON c1.id = c2.parentCategoryID " + 
							"WHERE c1.parentCategoryID IS NULL " +
							"GROUP BY c1.categoryName " + 
							"ORDER BY categoryName;";
			ps = con.prepareStatement(query);
			res = ps.executeQuery();

			while (res.next()) {
				Category category = new Category(res.getString("categoryName"), res.getInt("ChildCount"));
				System.out.println(category);
				categoryList.add(category);
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				res.close();
				ps.close();
			} catch (SQLException e) {
			}
		}
		return categoryList;
	}

	public static void main(String[] args) {
		Storefront sf = new Storefront();

		System.out.println("Orders placed by Shopper with ID 1");
		sf.fetchAllOrders(1);
		System.out.println();

		System.out.println("Inserting images for product with first id");
		Image img1 = new Image(1, "http://example.com/image6.jpg");
		Image img2 = new Image(1, "http://example.com/image7.jpg");
		Image img3 = new Image(1, "http://example.com/image8.jpg");
		Image img4 = new Image(1, "http://example.com/image9.jpg");
		Image img5 = new Image(1, "http://example.com/image10.jpg");
		ArrayList<Image> imageList = new ArrayList<>();
        imageList.add(img1);
        imageList.add(img2);
        imageList.add(img3);
        imageList.add(img4);
        imageList.add(img5);
		System.out.println(sf.insertBatchImage(imageList));
		System.out.println();

		System.out.println("List of top categories with count of subcategories");
		sf.categoryList();
		System.out.println();

		System.out.println("Number of products not purchased in last year and deleting them");
		System.out.println(sf.deleteProducts());

		try {
			sf.con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
