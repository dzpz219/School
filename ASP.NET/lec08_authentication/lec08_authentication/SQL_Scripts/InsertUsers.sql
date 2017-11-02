-- Create Stored Procedure InsertUsers
-- Which will insert a row into the Users table, hashing the password with salt

USE CHDB
GO

CREATE PROCEDURE InsertUsers
  @UserName VARCHAR(50) ,
  @Email VARCHAR(50) ,
  @Password VARCHAR(50)
AS
  DECLARE @Salt VARBINARY(64)
BEGIN
  SET @Salt = CRYPT_GEN_RANDOM(64);
  INSERT INTO Users VALUES(@UserName, @Email, @Salt, HASHBYTES('SHA2_512', CAST(@Salt AS VARCHAR) + @Password));
END