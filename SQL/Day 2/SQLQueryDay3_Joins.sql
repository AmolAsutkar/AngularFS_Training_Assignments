/** Get all the order details to gererate a report that displays, OrderID, OrderNumber, OrderDate, Shipping Date
and the product names which are the part of that order
*/
SELECT SOH.SalesOrderID as [OrderId],
SOH.SalesOrderNumber as [OrderNumber],
SOH.OrderDate,SOH.ShipDate as [Shipping Date],
P.Name as [Product Name]
FROM Sales.SalesOrderHeader SOH
JOIN Sales.SalesOrderDetail SOD ON SOH.SalesOrderID = SOD.SalesOrderID
JOIN Production.Product P ON P.ProductID = SOD.ProductID

SELECT * FROM Sales.SalesOrderHeader
SELECT * FROM Production.Product
SELECT * FROM Sales.SalesOrderDetail
SELECT * FROM Production.ProductCategory
SELECT * FROM Production.ProductSubCategory


/** Get all the order details to gererate a report that displays, OrderID, OrderNumber, OrderDate, Shipping Date
and the product names, subcategory and category which are the part of that order
*/

/**SOLUTION 1*/
Select soh.SalesOrderID,soh.SalesOrderNumber,soh.OrderDate,soh.ShipDate,pp.Name,PS.Name AS[SUBCategory],PC. Name AS[CATEGORY] from Production.Product pp
inner join Sales.SalesOrderDetail sod on pp.ProductID = sod.ProductID
inner join SALES.SalesOrderHeader soh on sod.SalesOrderID = soh.SalesOrderID
inner join Production.ProductSubcategory PS on pp.ProductSubCategoryId=PS.ProductSubcategoryID
inner join Production.ProductCategory PC on PS.ProductCategoryID= PC.ProductCategoryID

/**SOLUTION 2*/
SELECT SOH.SalesOrderID as [OrderId],
SOH.SalesOrderNumber as [OrderNumber],
SOH.OrderDate,SOH.ShipDate as [Shipping Date],
P.Name as [Product Name],PS.Name AS[SUBCategory],PC. Name AS[CATEGORY]
FROM Sales.SalesOrderHeader SOH
JOIN Sales.SalesOrderDetail SOD ON SOH.SalesOrderID = SOD.SalesOrderID
JOIN Production.Product P ON P.ProductID = SOD.ProductID JOIN Production.ProductSubcategory PS ON P.ProductSubcategoryID=PS.ProductSubcategoryID
JOIN Production.Productcategory PC ON PC.ProductCategoryID=PS.ProductCategoryID


/** Get all the order details to gererate a report that displays, OrderID, OrderNumber, OrderDate, Shipping Date
and the product names, subcategory and category which are the part of that order and include the name of customer
who has placed the order
*/
SELECT * FROM Sales.Customer
SELECT * FROM Person.Person
SELECT * FROM Production.ProductCategory
SELECT * FROM Production.ProductSubCategory



SELECT SOH.SalesOrderID as [OrderId],
SOH.SalesOrderNumber as [OrderNumber],
SOH.OrderDate,SOH.ShipDate as [Shipping Date],
P.Name as [Product Name],PS.Name AS[SUBCategory],PC. Name AS[CATEGORY],
PE.FirstName AS[CustomerName]
FROM Sales.SalesOrderHeader SOH
JOIN Sales.SalesOrderDetail SOD ON SOH.SalesOrderID = SOD.SalesOrderID
JOIN Production.Product P ON P.ProductID = SOD.ProductID JOIN Production.ProductSubcategory PS ON P.ProductSubcategoryID=PS.ProductSubcategoryID
JOIN Production.Productcategory PC ON PC.ProductCategoryID=PS.ProductCategoryID INNER JOIN Sales.Customer C ON SOH.CustomerID = C.CustomerID
INNER JOIN Person.Person PE ON C.PersonID = PE.BusinessEntityID

/** Get all the order details to gererate a report that displays, OrderID, OrderNumber, OrderDate, Shipping Date
and the product names, subcategory and category which are the part of that order and include the name of customer
who has placed the order as well as the name of teritory and country from where order has been placed
*/
SELECT * FROM Sales.CountryRegionCurrency
SELECT * FROM Person.CountryRegion
SELECT * FROM Sales.SalesTerritory


SELECT SOH.SalesOrderID as [OrderId],
SOH.SalesOrderNumber as [OrderNumber],
SOH.OrderDate,SOH.ShipDate as [Shipping Date],
P.Name as [Product Name],PS.Name AS[SUBCategory],PC. Name AS[CATEGORY],
PE.FirstName AS[CustomerName],
T.Name AS[TerritoryName],
CR.Name AS[CountryName]
FROM Sales.SalesOrderHeader SOH
JOIN Sales.SalesOrderDetail SOD ON SOH.SalesOrderID = SOD.SalesOrderID
JOIN Production.Product P ON P.ProductID = SOD.ProductID JOIN Production.ProductSubcategory PS ON P.ProductSubcategoryID=PS.ProductSubcategoryID
JOIN Production.Productcategory PC ON PC.ProductCategoryID=PS.ProductCategoryID INNER JOIN Sales.Customer C ON SOH.CustomerID = C.CustomerID
INNER JOIN Person.Person PE ON C.PersonID = PE.BusinessEntityID INNER JOIN Sales.SalesTerritory T ON T.TerritoryID=C.TerritoryID
INNER JOIN Person.CountryRegion CR ON CR.CountryRegionCode=T.CountryRegionCode