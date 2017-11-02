USE Northwind;
GO

-- ProductCounts
CREATE VIEW ProductCounts AS
SELECT CategoryName AS Category, COUNT(*) AS Products
FROM Categories c
JOIN Products p
ON c.CategoryID = p.CategoryID
GROUP BY CategoryName;
GO

-- CategorySales1998
CREATE VIEW CategorySales1998 AS
SELECT CategoryName AS Category, DATENAME(month, OrderDate) AS Month, MONTH(OrderDate) AS MonthNum, SUM(od.UnitPrice * Quantity) AS Sales
FROM Categories c
JOIN Products p
ON c.CategoryID = p.CategoryID
JOIN [Order Details] od
ON p.ProductID = od.ProductID
JOIN Orders o
ON od.OrderID = o.OrderID
WHERE YEAR(OrderDate) = 1998
GROUP BY CategoryName, DATENAME(month, OrderDate), MONTH(OrderDate);
GO

-- CategorySales
CREATE VIEW CategorySales AS
SELECT c.CategoryID, CategoryName AS Category, SUM(o.UnitPrice * Quantity) AS Sales
FROM Categories c
JOIN Products p
ON c.CategoryID = p.CategoryID
JOIN [Order Details] o
ON p.ProductID = o.ProductID
GROUP BY c.CategoryID, CategoryName;
GO

-- CategoryProductSales
CREATE VIEW CategoryProductSales AS
SELECT c.CategoryID, CategoryName AS Category, p.ProductID, ProductName AS Product, SUM(o.UnitPrice * Quantity) AS Sales
FROM Categories c
JOIN Products p
ON c.CategoryID = p.CategoryID
JOIN [Order Details] o
ON p.ProductID = o.ProductID
GROUP BY c.CategoryID, CategoryName, p.ProductID, ProductName;
GO