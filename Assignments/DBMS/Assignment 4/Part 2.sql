-- #2.1
DROP PROCEDURE getAverageSalesByProduct;

DELIMITER $$
CREATE PROCEDURE getAverageSalesByProduct(IN input_month INT, IN input_year INT)
BEGIN
    SELECT p.productName, AVG(i.quantity * p.cost) AS average_sales
    FROM storefront.items i
    JOIN storefront.product p ON i.productID = p.id
    JOIN storefront.orders o ON i.orderID = o.id
    WHERE MONTH(o.date) = input_month AND 
	YEAR(o.date) = input_year
    GROUP BY p.productName;
END$$

DELIMITER ;

CALL getAverageSalesByProduct(11, 2024);

-- #2.2
DROP PROCEDURE Order_Status_Details

DELIMITER $$

CREATE PROCEDURE Order_Status_Details(start_date DATE, end_date DATE)
BEGIN
    IF start_date > end_date THEN
        SET start_date = DATE_FORMAT(end_date, '%Y-%m-01');
    END IF;

    SELECT o.id, p.productName, i.status 
    FROM orders o
    JOIN items i ON i.orderID = o.id
    JOIN product p ON p.id = i.productID
    WHERE start_date <= o.date AND o.date <= end_date;
END$$

DELIMITER ;


CALL Order_Status_Details(DATE("2024-11-01"),DATE("2024-11-29"));

