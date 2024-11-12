DROP DATABASE storefront;
CREATE DATABASE storefront;
USE storefront;

-- Creation of Product table
CREATE TABLE storefront.product (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    productName VARCHAR(50) NOT NULL,
    productDescription VARCHAR(200),
    cost int NOT NULL DEFAULT 0,
    stock int NOT NULL DEFAULT 0
);

-- Dropping table Product
DROP TABLE product;

-- Recreation of Product table
CREATE TABLE storefront.product (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    productName VARCHAR(50) NOT NULL,
    productDescription VARCHAR(200),
    cost int NOT NULL DEFAULT 0,
    stock int NOT NULL DEFAULT 0
);

-- Creation of Images table
CREATE TABLE storefront.images (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    productID int NOT NULL,
    imageURL VARCHAR(200),
    FOREIGN KEY (productID) REFERENCES storefront.product(id)
);

-- Creation of User table
CREATE TABLE storefront.user (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(50) NOT NULL,
    userEmail VARCHAR(100) NOT NULL,
    role VARCHAR(15) NOT NULL,
    CHECK (role IN ('Shopper', 'Administrator'))
);

-- Creation of ShippingAddress table
CREATE TABLE storefront.shippingAddress (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userID INT,
    zipCode VARCHAR(10),
    city VARCHAR(50),
    state VARCHAR(50),
    country VARCHAR(50),
    FOREIGN KEY (userID) REFERENCES storefront.user(id)
);

-- Creation of Category table
CREATE TABLE storefront.category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    categoryName VARCHAR(100),
    parentCategoryID INT,
    FOREIGN KEY (parentCategoryID) REFERENCES storefront.category(id)
);

-- Creation of ProductCategory table
CREATE TABLE storefront.productCategory (
    productID INT,
    categoryID INT,
    PRIMARY KEY (productID, categoryID),
    FOREIGN KEY (productID) REFERENCES storefront.product(id),
    FOREIGN KEY (categoryID) REFERENCES storefront.category(id)
);

-- Creation of Orders table
CREATE TABLE storefront.orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userID INT NOT NULL,
    addressID INT NOT NULL,
    date DATE NOT NULL,
    amount DOUBLE NOT NULL,
    FOREIGN KEY(userID) REFERENCES storefront.user(id),
    FOREIGN KEY(addressID) REFERENCES storefront.shippingAddress(id)
);

-- Creation of Items table
CREATE TABLE storefront.items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    orderID INT NOT NULL,
    productID INT NOT NULL,
    status VARCHAR(15) NOT NULL,
    CHECK (status IN ('Shipped', 'Cancelled', 'Returned', 'Not Shipped')),
    quantity INT NOT NULL,
    FOREIGN KEY(orderID) REFERENCES storefront.orders(id),
    FOREIGN KEY(productID) REFERENCES storefront.product(id)
);