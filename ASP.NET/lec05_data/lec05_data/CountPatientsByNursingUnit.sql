CREATE PROCEDURE CountPatientsByNursingUnit 
AS
SELECT a.NursingUnitID, Specialty, COUNT(*) AS PatientCount
FROM Admissions a
JOIN NursingUnits n
ON a.NursingUnitID = n.NursingUnitID
WHERE DischargeDate IS NULL
GROUP BY a.NursingUnitID, Specialty;
RETURN