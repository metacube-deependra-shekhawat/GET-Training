-- #1.1
DELIMITER $$
CREATE FUNCTION storefront.calculateOrdersForMonth(MONTH INT, YEAR INT)
RETURNS INT deterministic
BEGIN
    DECLARE ret INT;
    SET ret = (SELECT COUNT(o.id)  FROM storefront.orders o
    WHERE MONTH(o.date) = MONTH AND YEAR(o.date) = YEAR
    GROUP BY o.date);
    RETURN ret;
END$$
DELIMITER ;

SELECT calculateOrdersForMonth(11,2024);

-- #1.2
DELIMITER $$
CREATE FUNCTION storefront.monthWithMaxOrders(YEAR INT)
RETURNS INT
BEGIN
    DECLARE ret INT;
    SET ret = (SELECT MONTH(o.date) FROM orders o
    WHERE YEAR(o.date) = YEAR
    GROUP BY MONTH(o.date)
    ORDER BY COUNT(o.id) DESC
    LIMIT 1);
    RETURN ret;
END$$

DELIMITER ;