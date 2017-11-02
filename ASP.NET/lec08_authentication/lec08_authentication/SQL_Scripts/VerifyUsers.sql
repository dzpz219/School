-- Create Stored Procedure VerifyUsers
-- Which will determine if the salted hash value of the entered password matches the salted hash value of the stored password
-- VerifyUsers returns a single column single row result set
-- The value returned is 1 if the username/password matches, otherwise 0

USE CHDB
GO

CREATE PROCEDURE VerifyUsers
  @UserName VARCHAR(50) ,
  @Password VARCHAR(50)
AS
  DECLARE @Salt VARBINARY(64)
  DECLARE @HashValue VARCHAR(64)
BEGIN
  SET @Salt = (SELECT Salt FROM Users WHERE UserName = @UserName);
  SET @HashValue = (SELECT HashValue FROM Users WHERE UserName = @UserName);
  IF HASHBYTES('SHA2_512', CAST(@Salt AS VARCHAR) + @Password) = @HashValue
    SELECT 1 AS Result;
  ELSE
    SELECT 0 AS Result;
END