-- #3.1
SELECT u.id, u.userName, COUNT(o.id) as numOfOrders FROM user u
JOIN orders o ON u.id = o.userID
WHERE DATEDIFF(CURRENT_DATE(), date) < 30
GROUP BY o.userID;

-- #3.2
SELECT u.id, u.userName, SUM(o.amount) as revenueGenerated
FROM user u JOIN orders o ON u.id = o.userID
WHERE DATEDIFF(CURRENT_DATE(), o.date) < 30
GROUP BY u.id, u.userName
ORDER BY revenueGenerated DESC LIMIT 10;

-- #3.3
SELECT p.productName, SUM(i.quantity) as numberOfUnits
FROM product p JOIN items i ON p.id = i.productID JOIN orders o ON i.orderID = o.id
WHERE DATEDIFF(CURRENT_DATE(), o.date) < 60
GROUP BY p.productName
ORDER BY numberOfUnits DESC LIMIT 20;

-- #3.4
CREATE VIEW monthlySales 
AS
(SELECT
CASE
    WHEN DATEDIFF(CURRENT_DATE(), o.date) BETWEEN 0 AND 30 THEN "MONTH 1"
    WHEN DATEDIFF(CURRENT_DATE(), o.date) BETWEEN 31 AND 60 THEN "MONTH 2"
    WHEN DATEDIFF(CURRENT_DATE(), o.date) BETWEEN 61 AND 90 THEN "MONTH 3"
    WHEN DATEDIFF(CURRENT_DATE(), o.date) BETWEEN 91 AND 120 THEN "MONTH 4"
    WHEN DATEDIFF(CURRENT_DATE(), o.date) BETWEEN 121 AND 150 THEN "MONTH 5"
    WHEN DATEDIFF(CURRENT_DATE(), o.date) BETWEEN 151 AND 180 THEN "MONTH 6"
    WHEN DATEDIFF(CURRENT_DATE(), o.date) > 180 THEN "REST"
END as month, SUM(o.amount)
FROM orders o
GROUP BY month);

SELECT * FROM monthlySales;

-- #3.5
UPDATE product
SET isActive = false
WHERE id NOT IN(
    SELECT DISTINCT i.productID FROM items i
    JOIN orders o ON o.id = i.orderID
    WHERE DATEDIFF(CURDATE(), o.date) <= 90
);

-- #3.6
SELECT c.categoryName, pc.productID, p.productName FROM productCategory pc
JOIN category c ON c.id = pc.categoryID
JOIN product p ON pc.productID = p.id
WHERE c.categoryName LIKE "Lap%";

-- #3.7
SELECT p.productName, count(i.productID) FROM product p
JOIN items i ON i.productID = p.id
WHERE i.status = 'Cancelled'
GROUP BY i.productID
ORDER BY count(p.id) DESC
LIMIT 10;