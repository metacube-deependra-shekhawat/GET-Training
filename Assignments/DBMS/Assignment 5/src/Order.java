import java.sql.Date;

/** POJO Class of the Order */
public class Order {
	int id;
	Date orderDate;
	int amount;

	/**
	 * @param id        order id
	 * @param orderDate order date
	 * @param amount    total amount of the order
	 */
	public Order(int id, Date orderDate, int amount) {
		this.id = id;
		this.orderDate = orderDate;
		this.amount = amount;
	}

	/**
	 * @return the id
	 */
	int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the orderDate
	 */
	Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the amount
	 */
	int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", amount=" + amount + "]";
	}
}
