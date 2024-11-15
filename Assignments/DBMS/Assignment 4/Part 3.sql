-- #3.1
ALTER TABLE orders o ADD INDEX (o.date);

-- #3.2
ALTER TABLE product p ADD INDEX (p.productName);

-- #3.3
ALTER TABLE category c ADD INDEX (c.categoryName);