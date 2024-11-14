-- Insert data into the product table
INSERT INTO storefront.product (productName, productDescription, cost, stock) 
VALUES ('Product 1', 'Description for product 1', 100, 10);
INSERT INTO storefront.product (productName, productDescription, cost, stock) 
VALUES ('Product 2', 'Description for product 2', 200, 20);
INSERT INTO storefront.product (productName, productDescription, cost, stock) 
VALUES ('Product 3', 'Description for product 3', 300, 30);
INSERT INTO storefront.product (productName, productDescription, cost, stock) 
VALUES ('Product 4', 'Description for product 4', 400, 40);
INSERT INTO storefront.product (productName, productDescription, cost, stock) 
VALUES ('Product 5', 'Description for product 5', 500, 50);
INSERT INTO storefront.product (productName, productDescription, cost, stock) 
VALUES ('Product 6', 'Description for product 6', 501, 51);

-- Insert data into the images table
INSERT INTO storefront.images (productID, imageURL) VALUES (1, 'http://example.com/image1.jpg');
INSERT INTO storefront.images (productID, imageURL) VALUES (2, 'http://example.com/image2.jpg');
INSERT INTO storefront.images (productID, imageURL) VALUES (3, 'http://example.com/image3.jpg');
INSERT INTO storefront.images (productID, imageURL) VALUES (4, 'http://example.com/image4.jpg');
INSERT INTO storefront.images (productID, imageURL) VALUES (5, 'http://example.com/image5.jpg');

-- Insert data into the category table
INSERT INTO storefront.category (categoryName, parentCategoryID) VALUES ('Electronics', NULL);
INSERT INTO storefront.category (categoryName, parentCategoryID) VALUES ('Laptops', 1);
INSERT INTO storefront.category (categoryName, parentCategoryID) VALUES ('Smartphones', 1);
INSERT INTO storefront.category (categoryName, parentCategoryID) VALUES ('Accessories', 1);
INSERT INTO storefront.category (categoryName, parentCategoryID) VALUES ('Gaming', 1);

-- Insert data into the productCategory table
INSERT INTO storefront.productCategory (productID, categoryID) VALUES (1, 1);
INSERT INTO storefront.productCategory (productID, categoryID) VALUES (2, 1);
INSERT INTO storefront.productCategory (productID, categoryID) VALUES (5, 1);
INSERT INTO storefront.productCategory (productID, categoryID) VALUES (1, 2);
INSERT INTO storefront.productCategory (productID, categoryID) VALUES (2, 3);
INSERT INTO storefront.productCategory (productID, categoryID) VALUES (3, 4);
INSERT INTO storefront.productCategory (productID, categoryID) VALUES (4, 5);
INSERT INTO storefront.productCategory (productID, categoryID) VALUES (5, 2);

-- Insert data into the user table
INSERT INTO storefront.user (userName, userEmail, role) VALUES ('Alice', 'alice@example.com', 'Shopper');
INSERT INTO storefront.user (userName, userEmail, role) VALUES ('Bob', 'bob@example.com', 'Administrator');
INSERT INTO storefront.user (userName, userEmail, role) VALUES ('Charlie', 'charlie@example.com', 'Shopper');
INSERT INTO storefront.user (userName, userEmail, role) VALUES ('Diana', 'diana@example.com', 'Administrator');
INSERT INTO storefront.user (userName, userEmail, role) VALUES ('Eve', 'eve@example.com', 'Shopper');
INSERT INTO storefront.user (userName, userEmail, role) VALUES ('Eva', 'eve@example.com', 'Shopper');
INSERT INTO storefront.user (userName, userEmail, role) VALUES ('Evan', 'eve@example.com', 'Shopper');

-- Insert data into the shippingAddress table
INSERT INTO storefront.shippingAddress (userID, zipCode, city, state, country) VALUES (1, '12345', 'CityA', 'StateA', 'CountryA');
INSERT INTO storefront.shippingAddress (userID, zipCode, city, state, country) VALUES (2, '23456', 'CityB', 'StateB', 'CountryB');
INSERT INTO storefront.shippingAddress (userID, zipCode, city, state, country) VALUES (3, '34567', 'CityC', 'StateC', 'CountryC');
INSERT INTO storefront.shippingAddress (userID, zipCode, city, state, country) VALUES (4, '45678', 'CityD', 'StateD', 'CountryD');
INSERT INTO storefront.shippingAddress (userID, zipCode, city, state, country) VALUES (5, '56789', 'CityE', 'StateE', 'CountryE');

-- Insert data into the order table
INSERT INTO storefront.orders (userID, date, amount, addressID) VALUES (1, '2022-11-01', 150.00, 1);
INSERT INTO storefront.orders (userID, date, amount, addressID) VALUES (2, '2022-11-02', 200.00, 2);
INSERT INTO storefront.orders (userID, date, amount, addressID) VALUES (3, '2022-11-03', 250.00, 3);
INSERT INTO storefront.orders (userID, date, amount, addressID) VALUES (5, '2024-11-05', 350.00, 5);
INSERT INTO storefront.orders (userID, date, amount, addressID) VALUES (5, '2024-11-05', 350.00, 5);
INSERT INTO storefront.orders (userID, date, amount, addressID) VALUES (6, '2024-10-05', 350.00, 5);
INSERT INTO storefront.orders (userID, date, amount, addressID) VALUES (7, '2024-10-01', 350.00, 5);

-- Insert data into the items table
INSERT INTO storefront.items (orderID, productID, status, quantity) VALUES (1, 1, 'Shipped', 2);
INSERT INTO storefront.items (orderID, productID, status, quantity) VALUES (2, 2, 'Cancelled', 1);
INSERT INTO storefront.items (orderID, productID, status, quantity) VALUES (3, 3, 'Returned', 3);
INSERT INTO storefront.items (orderID, productID, status, quantity) VALUES (5, 5, 'Shipped', 5);
INSERT INTO storefront.items (orderID, productID, status, quantity) VALUES (6, 4, 'Shipped', 5);