-- cleanschema.sql
-- Generate a script that will DROP all user objects
CLEAR SCREEN;
SELECT 'CLEAR SCREEN;' AS cleanup
FROM dual
  UNION
SELECT 'DROP ' || object_type || ' ' || object_name || ';' AS cleanup
FROM user_objects
WHERE object_type <> 'TABLE'
AND object_type <> 'INDEX'
AND object_type <> 'PACKAGE BODY'
AND object_type <> 'TRIGGER'
AND object_type <> 'LOB' 
  UNION
SELECT 'DROP ' || object_type || ' ' || object_name || ' CASCADE CONSTRAINTS;' AS cleanup
FROM user_objects
WHERE object_type = 'TABLE'
  UNION
SELECT 'PURGE RECYCLEBIN;' AS cleanup
FROM dual;