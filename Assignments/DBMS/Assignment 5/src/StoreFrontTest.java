import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StorefrontTest {
	Storefront storeDAO = new Storefront();

	@Test
	public void TestFetchAllOrders() {

		List<Order> ordersList = storeDAO.fetchAllOrders(2);
		
		List<Order> expected = new LinkedList<>();
		
		expected.add(new Order(6, Date.valueOf("2021-07-08"), 65000));
		expected.add(new Order(12, Date.valueOf("2021-08-08"), 13000));

		for (int i = 0; i < expected.size(); ++i) {
			assertEquals(expected.get(i).getId(), ordersList.get(i).getId());
			assertEquals(0, expected.get(i).getOrderDate().compareTo(ordersList.get(i).getOrderDate()));
			assertEquals(expected.get(i).getAmount(), ordersList.get(i).getAmount());
		}

	}

	@Test
	public void TestDeleteProductCategories() {
		assertEquals(3, storeDAO.deleteProducts());
	}

	@Test
	public void TestTopCategoreis() {
		List<Category> catgList = storeDAO.categoryList();

		List<Category> expected = new LinkedList<>();
		expected.add(new Category("Electronics", 3));
		expected.add(new Category("Stationary", 1));

		for (int i = 0; i < expected.size(); ++i) {
			assertEquals(expected.get(i).getParentCategory(), catgList.get(i).getParentCategory());
			assertEquals(expected.get(i).getNoOfChildren(), catgList.get(i).getNoOfChildren());
		}
	}

	@Test
	public void TestInsertBatchImages() {

		List<Image> image = new LinkedList<>();

		image.add(new Image(1, "https://drive.google.com/tv2"));
		image.add(new Image(2, "https://drive.google.com/samsung2"));
		image.add(new Image(3, "https://drive.google.com/dell_lat_3"));
		image.add(new Image(4, "https://drive.google.com/real_me_3"));
		image.add(new Image(5, "https://drive.google.com/lg_43"));
		image.add(new Image(6, "https://drive.google.com/nokia_101_2"));

		assertTrue(storeDAO.insertBatchImage(image));
	}
}