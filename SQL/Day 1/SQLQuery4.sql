CREATE Schema Saless
CREATE Schema Persons
CREATE Schema Productions
CREATE Schema HR

CREATE TABLE Productions.ProductCategeory (
    ProductCategeoryID INT IDENTITY(11,1) PRIMARY KEY,
    ProductCategeoryName VARCHAR(50) NOT NULL,
	
);

SELECT * FROM Productions.ProductSubCategeory;

CREATE TABLE Productions.ProductSubCategeory (
    ProductSubCategeoryID INT IDENTITY(21,1) PRIMARY KEY,
    ProductSubCategeoryName VARCHAR(50) NOT NULL,
	ProductCategeoryID INT REFERENCES Productions.ProductCategeory(ProductCategeoryID) NOT NULL
 );

 CREATE TABLE Productions.Product (
    ProductID INT IDENTITY(21,1) PRIMARY KEY,
    ProductName VARCHAR(50) NOT NULL,
    ProductCost CHAR(12) NOT NULL,
	QuintityInStock CHAR(30) NOT NULL,
	ProductSubCategeoryID INT REFERENCES Productions.ProductSubCategeory(ProductSubCategeoryID) NOT NULL
 );

 CREATE TABLE Saless.SalesOrderDetails (
    SalesOrderID INT IDENTITY(31,1) PRIMARY KEY,
    SalesOrdeHeaderrID VARCHAR(50) NOT NULL,
    ProductCost CHAR(12) NOT NULL,
	QuintityInStock CHAR(30) NOT NULL,
	ProductID INT REFERENCES Productions.Product(ProductID) NOT NULL
 );


