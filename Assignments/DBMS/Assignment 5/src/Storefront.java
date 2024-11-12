import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * class to connect and execute queries of the database
 */
public class Storefront {
	Connection con;

	/**
	 * Constructor to connect to JDBC
	 */
	public Storefront() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storefront", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loading driver: " + cnfe);
		}
	}

	/**
	 * Given the id of a user, fetch all orders (Id, Order Date, Order Total) of
	 * that user which are in shipped state. Orders should be sorted by order date
	 * column in chronological order.
	 * 
	 * @param userId user id for orders need to be fetched
	 * @return list of orders
	 */
	public List<Order> fetchAllOrders(int userId) {
		List<Order> ordersList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			
			String query = "SELECT o.id, o.date, o.amount FROM user_order o JOIN item i ON o.id = i.order_id WHERE o.user_id = ? AND i.status = 'Shipped' ORDER BY o.date";
			ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();

			while (rs.next()) {
				Order order = new Order(rs.getInt("id"), rs.getDate("date"), rs.getInt("amount"));
				ordersList.add(order);
			}

		} catch (SQLException sqle) {
			System.out.println("Error: Unable to fetch the records.");
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
			}
		}

		return ordersList;
	}

	/**
	 * Insert five or more images of a product using batch insert technique.
	 * 
	 * @param imageUrls list of URLs along with the image id
	 * @return true if all the images are inserted
	 */
	public boolean insertBatchImage(List<Image> imageUrls) {
		boolean result = false;
		String query = "INSERT INTO image VALUES(?,?)";
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
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				/* ignore */}
		}

		return result;
	}

	/**
	 * Delete all those products which were not ordered by any Shopper in last 1
	 * year.
	 * 
	 * @return the number of products deleted.
	 */
	public int deleteProducts() {
		String mainQuery = "(SELECT temp.pid FROM (SELECT DISTINCT i.product_id as pid FROM item i "
				+ "JOIN product p ON i.product_id = p.id JOIN user_order o "
				+ "ON o.id = i.order_id JOIN user u ON u.id = o.user_id "
				+ "WHERE DATEDIFF(curDate(), o.date) < 365 AND u.role='Shopper') temp)";

		
		String query1 = "Delete FROM product_category WHERE product_id NOT IN " + mainQuery;
		String query2 = "Delete FROM images WHERE product_id NOT IN " + mainQuery;
		String query3 = "Delete FROM items WHERE product_id NOT IN " + mainQuery;
		String query4 = "Delete FROM product WHERE id NOT IN " + mainQuery;
		
		Statement s = null;
		int[] count = new int[4];
		
		try {
			con.setAutoCommit(false);
			s = con.createStatement();
			s.addBatch(query1);
			s.addBatch(query2);
			s.addBatch(query3);
			s.addBatch(query4);
			count = s.executeBatch();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (SQLException e) {
				/* ignore */}
		}

		return count[count.length-1];
	}

	/**
	 * Select and display the category title of all top parent categories sorted
	 * alphabetically and the count of their child categories.
	 * 
	 * @return categoryList list of type category
	 */
	public List<Category> categoryList() {
		String query = "SELECT  c.name as Title, count(c.id) as count FROM category c "
				+ "JOIN category p ON c.id = p.parent_id " + "WHERE c.parent_id is NULL "
				+ "GROUP BY c.name " + "ORDER BY Title";

		Statement s = null;
		ResultSet rs = null;

		List<Category> list = new LinkedList<>();

		try {
			con.setAutoCommit(false);
			s = con.createStatement();
			rs = s.executeQuery(query);

			while (rs.next()) {
				list.add(new Category(rs.getString(1), rs.getInt(2)));
			}

			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				s.close();
				rs.close();
			} catch (SQLException e) {
				/* ignore */}
		}

		return list;

	}

}
