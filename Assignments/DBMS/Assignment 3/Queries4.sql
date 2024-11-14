-- 5.1
CREATE VIEW tableView AS
(SELECT p.id, p.productName AS "NameOfProduct", p.cost, u.userName AS "UserName", u.userEmail, o.date, i.status
FROM product p JOIN items i ON p.id = i.productID
JOIN orders o ON o.id = i.orderID
JOIN user u ON u.id = o.userID
WHERE DATEDIFF(CURDATE(), o.date) <= 60
ORDER BY o.date DESC
);

-- #5.2
SELECT NameOfProduct as Product FROM tableView
WHERE status = 'Shipped';

-- #5.3
SELECT NameOfProduct, COUNT(id) as Quantity
FROM tableView
GROUP BY id
ORDER BY Quantity DESC
LIMIT 5;