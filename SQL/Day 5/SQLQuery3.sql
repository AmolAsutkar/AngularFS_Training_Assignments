
--Q) Create a anonymous block to get the age of any one employee and print his name #age number of times
DECLARE
@age INT,
@i INT SET @i = 1
select @age=DATEDIFF(YEAR, BirthDate, GETDATE()) from HumanResources.Employee where BusinessEntityID =120

WHILE(@i<=@age)
BEGIN
PRINT @age
SET @i = @i + 1
END



