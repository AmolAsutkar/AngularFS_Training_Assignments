

--Single row SubQuery: returns single row and single column
--Q: Get youngest employee
Select * from HumanResources.Employee where BirthDate=(select MAX(BirthDate) from HumanResources.Employee)
select * MAX(BirthDate) from HumanResources.Employee --error

--Multi row SubQuery: returns Multiple rows and single column
--Q: Get all products that belong to Subcategory= Brakes
Select * from Production.Product where ProductSubcategoryID =(select ProductSubcategoryID from Production.ProductSubcategory where Name='Brakes')--Multicolumn Subquery: returns one or multiple rows & multiple columns
select * from Production.ProductSubcategory

--Ex1: Get all the products that if there are any products in cloathing subcategory
Select * from Production. Product WHERE NOT EXISTS
(
Select * from Production.ProductSubcategory Where Name = 'Clothing'
)

--Ex2: Replicate data in another table /view based on some filter
CREATE TABLE RedProducts
(
ProductID INT,
NAme VARCHAR(50),
ProductNumber VARCHAR(20),
Color varchar(20),
StandardCost MOney
)
INSERT INTO RedProducts
SELECT ProductID,Name,ProductNumber,Color, StandardCost FROM Production.Product WHERE Color = 'Red'

Select * FROM RedProducts--COrelated SubQuery : Both inner and outer queries are dependent on each other - For each row of outer quer inner query executes multiple timesCREATE Table PatientVisits

CREATE Table PatientVisits
(
VisitID INT Primary Key IDENTITY (1,1),
PatientID INT,
VisitPurpose VARCHAR(3),
VisitTime INT
)

INSERT INTO PatientVisits (PatientID,VisitPurpose,VisitTime) VALUES
(101,'C',15),
(999,'P',30),
(101,'R',50),
(999,'C',20),
(222,'R',60),
(101,'C',22),
(222,'P',35),
(999,'P',40),
(222,'R',54),
(222,'C',23),
(101,'P',34)

SELECT * FROM PatientVisits ORDER BY VisitPurpose

-- Get all the Visits having VisitTime greater that average of VisitTime against its visit purpose

SELECT * FROM PatientVisits VO WHERE VisitTime >
(
SELECT AVG(VisitTime) FROM PatientVisits WHERE VisitPurpose = VO.VisitPurpose
)


--Alternative
SELECT * FROM
(
SELECT *,AVG(VisitTime)OVER(PARTITION BY VisitPurpose) AS [AV] FROM PatientVisits
)as [tab]
WHERE VisitTime > AV
------------------------------------------------------------------------------------------------------


/*
SEQUENCES:::: A sequence is a sequential number generator
*/
--Railway Sytem
Users for IRCTC ---> id (1001)--- identity
Employees of IRCTC ---> id (1001) --- identity

--Railway Sytem
Users for IRCTC ---> id (1001) ---->
Employees of IRCTC ---> id (1002) -----> Sequence

CREATE SEQUENCE SeqIDGenerator
START WITH 1001
INCREMENT BY 1
MINVALUE 1
MAXVALUE 100000
NO CYCLE
CACHE 100

SELECT NEXT VALUE FOR SeqIDGenerator

INSERT INTO PatientVisits (PatientID,VisitPurpose,VisitTime) VALUES
(NEXT VALUE FOR SeqIDGenerator,'P',35)

SELECT * FROM PatientVisits

/*
Create a seq and insert data into multiple tables from the seq.
**Start with 5 maxvalue 10 minvalue 1 cycle
*/



