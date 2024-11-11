-- #2.1
SELECT p.productName FROM storefront.product p
WHERE p.stock > 0;

-- #2.2
SELECT p.id, p.productName, p.productDescription
FROM storefront.product p
LEFT JOIN storefront.images i ON p.id = i.productID
WHERE i.productID IS NULL;

-- #2.3
SELECT cc.id, cc.categoryName, c.categoryName as ParentCategory
FROM storefront.category c
RIGHT JOIN storefront.category cc on c.id = cc.parentCategoryID
ORDER BY c.categoryName ASC;

-- #2.4
SELECT c.id, c.categoryName FROM storefront.category c
WHERE c.parentCategoryID IS NULL;

-- #2.5
SELECT cc.id, cc.categoryName, c.categoryName
FROM storefront.category c
LEFT JOIN storefront.category cc on c.id = cc.parentCategoryID
WHERE c.categoryName = 'Electronics';

-- #2.6
SELECT p.id, p.productName, p.stock FROM storefront.product p
WHERE p.stock < 50;

-- #3.1
SELECT id, date, amount FROM orders
ORDER BY date DESC
LIMIT 10;

-- #3.2
SELECT id, amount FROM orders
ORDER BY amount DESC;

-- #3.3
SELECT o.id, o.date, i.status FROM orders o LEFT JOIN items i
ON o.id = i.orderID
WHERE DATEDIFF(CURRENT_DATE(), date) > 10
OR i.status IN ('Not Shipped');

-- #3.4
SELECT id, userName FROM user
WHERE id NOT IN
(SELECT userID FROM orders WHERE DATEDIFF(CURRENT_DATE(), date) < 31);

-- #3.5
SELECT u.id, u.userName, o.date FROM user u, orders o
WHERE o.date IN
(SELECT date FROM orders WHERE DATEDIFF(CURRENT_DATE(), date) <= 15);

-- #3.6
SELECT p.productName, i.status FROM orders o 
JOIN items i ON o.id = i.orderID AND i.status = 'Shipped'
JOIN product p ON p.id = i.productID

-- #3.7
SELECT o.id, o.date, p.productName, p.cost FROM orders o
LEFT JOIN items i ON o.id = i.orderID
RIGHT JOIN product p ON i.productID = p.id
WHERE p.cost BETWEEN 20 AND 50;