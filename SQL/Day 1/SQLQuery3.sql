CREATE TABLE Saless.Country (
    CountryID INT IDENTITY(41,1) PRIMARY KEY,
    CountryName VARCHAR(50) NOT NULL,
 );

 CREATE TABLE Saless.Territory (
    TerritoryID INT IDENTITY(51,1) PRIMARY KEY,
    TerritoryName VARCHAR(50) NOT NULL,
	CountryID INT REFERENCES Saless.Country(CountryID) NOT NULL
 );

 CREATE TABLE Persons.Person (
    PersonID INT IDENTITY(61,1) PRIMARY KEY,
	Title VARCHAR(50) NOT NULL,
    FirstName VARCHAR(50) NOT NULL,
	MiddleName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
	Gender VARCHAR(10) NOT NULL,
	ModifiesDate DATE CHECK (ModifiesDate BETWEEN '10-FEB-2020' AND GETDATE()) NOT NULL,
);
DROP TABLE Persons.Person;
CREATE TABLE HR.Department (
    DepartmentID INT IDENTITY(61,1) PRIMARY KEY,
    DepartmentName VARCHAR(50) NOT NULL,
	
);

CREATE TABLE HR.Employee (
    EmployeeID INT IDENTITY(71,1) PRIMARY KEY,
    Designation VARCHAR(50) NOT NULL,
	ManagerID INT NOT NULL,
	dateofjoining DATE CHECK (dateofjoining BETWEEN '10-FEB-1990' AND GETDATE()) NOT NULL,
	DepartmentID INT REFERENCES HR.Department(DepartmentID) NOT NULL,
	PersonID INT REFERENCES Persons.Person(PersonID) NOT NULL

 );

 CREATE TABLE Saless.Customer (
    CustomerID INT IDENTITY(81,1) PRIMARY KEY,
    CustomerGrade VARCHAR(50) NOT NULL,
	TerritoryID INT REFERENCES Saless.Territory(TerritoryID) NOT NULL,
	PersonID INT REFERENCES Persons.Person(PersonID) NOT NULL

 );

 CREATE TABLE Saless.SalesOrderHeader (
    SalesOrderHeaderID INT IDENTITY(81,1) PRIMARY KEY,
    OrderDate DATE  NOT NULL,
	SalesPersonID INT REFERENCES HR.Employee(EmployeeID) NOT NULL,
	CustomerID INT REFERENCES Saless.Customer(CustomerID) NOT NULL

 );

 CREATE TABLE Saless.SalesOrderDetail (
    SalesOrderDetailID INT IDENTITY(81,1) PRIMARY KEY,
    OrderQuantity CHAR(12) NOT NULL,
	SalesOrderHeaderID INT REFERENCES Saless.SalesOrderHeader(SalesOrderHeaderID) NOT NULL,
	ProductID INT REFERENCES Productions.Product(ProductID) NOT NULL

 );