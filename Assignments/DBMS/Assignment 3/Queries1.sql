-- #2.1
SELECT p.id, p.productName, COUNT(c.categoryID) AS categoryCount
FROM storefront.product p
JOIN storefront.productCategory c ON p.id = c.productID
GROUP BY p.id
HAVING COUNT(c.categoryID) > 1;

-- #2.2
SELECT COUNT(id),
CASE
    WHEN cost BETWEEN 0 and 100 THEN "0-100"
    WHEN cost BETWEEN 101 and 500 THEN "101-500"
    WHEN cost > 500 THEN ">500"
END AS priceRange
FROM product
GROUP BY priceRange;

-- #2.3
SELECT c.categoryName, COUNT(pc.productID)
FROM category c JOIN productCategory pc ON pc.categoryID = c.id
GROUP BY c.categoryName;