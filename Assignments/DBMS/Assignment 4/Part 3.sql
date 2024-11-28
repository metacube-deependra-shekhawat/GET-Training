-- #3.1
ALTER TABLE orders ADD INDEX (date);

-- #3.2
ALTER TABLE product ADD INDEX (productName);

-- #3.3
ALTER TABLE category ADD INDEX (categoryName);