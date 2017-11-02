/****************************************************************************/
-- Script: comp10126.sql
-- Author: Brian Minaji
-- Date: January 23, 2011
-- Description: Create demonstration database objects
-- Usage: When running script, you will be prompted for a connection, use sys
/****************************************************************************/
CLEAR SCREEN;
SET SERVEROUTPUT ON;
SET VERIFY OFF;

-- If comp10126 user exists, drop it
DECLARE
  v_count NUMBER;
BEGIN
  SELECT COUNT(*)
    INTO v_count
    FROM dba_users
    WHERE username = 'COMP10126';
  IF v_count > 0 THEN
    DBMS_OUTPUT.PUT_LINE('Dropping user comp10126');
    EXECUTE IMMEDIATE 'DROP USER comp10126 CASCADE';
  END IF;
END;
/

-- Suppress completion messages
SET FEEDBACK OFF

-- Prevent passwords from expiring. Not recommended for production
ALTER PROFILE default LIMIT PASSWORD_LIFE_TIME UNLIMITED;

PROMPT Create comp10126 user
CREATE USER comp10126 IDENTIFIED BY oracle;

PROMPT Grant DBA, CONNECT and RESOURCE roles
GRANT "DBA" TO comp10126 ;
GRANT "CONNECT" TO comp10126 ;
GRANT "RESOURCE" TO comp10126 ;

PROMPT Connect as comp10126
CONNECT comp10126/oracle;

-- Set date format
ALTER SESSION SET NLS_DATE_FORMAT = 'MM/DD/YYYY';

PROMPT Create Items table
CREATE TABLE Items (
	Item_ID INT NOT NULL ,
	Description VARCHAR2(30) NOT NULL ,
	CONSTRAINT PK_Item PRIMARY KEY ( Item_ID ) ) ;

PROMPT Create Purchases table
CREATE TABLE Purchases (
	Item_ID INT NOT NULL ,
	Quantity_Purchased INT ,
	CONSTRAINT PK_Purchased PRIMARY KEY ( Item_ID ) ) ;

PROMPT Create Sales table
CREATE TABLE Sales (
	Item_ID INT NOT NULL ,
	Quantity_Sold INT ,
	CONSTRAINT PK_Sold PRIMARY KEY ( Item_ID ) ) ;

PROMPT Create Employees table
CREATE TABLE Employees (
	Employee_ID INT NOT NULL ,
	First_Name VARCHAR2(25) ,
	Last_Name VARCHAR2(25) ,
	Department VARCHAR2(25) ,
	Title VARCHAR2(25) ,
	Supervisor INT ,
	Salary INT NULL ,
	CONSTRAINT PK_Employee PRIMARY KEY ( Employee_ID ) ) ;

PROMPT Insert Items records
INSERT INTO Items VALUES( 1 , 'Birdseed' );
INSERT INTO Items VALUES( 2 , 'Dehydrated Boulders' );
INSERT INTO Items VALUES( 3 , 'Rocket Sled' );
INSERT INTO Items VALUES( 4 , 'Invisible Paint' );
INSERT INTO Items VALUES( 5 , 'Anvils' );

PROMPT Insert Purchases records
INSERT INTO Purchases VALUES( 1 , 15 );
INSERT INTO Purchases VALUES( 3 , 10 );
INSERT INTO Purchases VALUES( 4 , 25 );

PROMPT Insert Sales records
INSERT INTO Sales VALUES( 1 , 5 );
INSERT INTO Sales VALUES( 2 , 9 );
INSERT INTO Sales VALUES( 4 , 8 );
INSERT INTO Sales VALUES( 5 , 14 );

PROMPT Insert Employees records
INSERT INTO Employees VALUES( 101 , 'Malcolm' , 'Reynolds' , 'Management' , 'President', NULL , 1000 );
INSERT INTO Employees VALUES( 102 , 'Zoe' , 'Washburne' , 'Sales' , 'VP of Sales' , 101 , 750 );
INSERT INTO Employees VALUES( 103 , 'Jayne' , 'Cobb' , 'Sales' , 'Sales Rep' , 102 , 500 );
INSERT INTO Employees VALUES( 104 , 'Hoban' , 'Washburne' , 'Finance' , 'VP of Finance' , 101 , 750);
INSERT INTO Employees VALUES( 105 , 'Kaylee' , 'Frye' , 'Finance' , 'AP Clerk' , 104 , 400 );
INSERT INTO Employees VALUES( 106 , 'Inara' , 'Serra' , 'Finance' , 'AR Clerk' , 104 , 400 );
INSERT INTO Employees VALUES( 107 , 'Simon' , 'Tam' , 'Sales' , 'Sales Rep' , 102 , 500 );
INSERT INTO Employees VALUES( 108 , 'Derrial' , 'Book' , 'Sales' , 'Sales Rep' ,  102 , 500 );
INSERT INTO Employees VALUES( 109 , 'River' , 'Tam' , 'Finance' , 'GL Clerk' , 104 , 400 );

PROMPT Commit database changes
COMMIT;