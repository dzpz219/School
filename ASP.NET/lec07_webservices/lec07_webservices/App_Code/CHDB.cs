using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.Configuration; // Added for WebConfigurationManager
using System.Data.SqlClient; // Added for SQL classes
using System.Data; // Added for DataSet

/// <summary>
/// Patient class
/// </summary>
public class Patient
{
    public int patientID;
    public string firstName;
    public string lastName;
    public string gender;
    public DateTime dateOfBirth;

    /// <summary>
    /// Patient constructor
    /// </summary>
    public Patient()
    {
        patientID = -1; // By default, assume patient not found
        firstName = "";
        lastName = "";
        gender = "";
    }
}

/// <summary>
/// Community Hospital Web Services
/// </summary>
[WebService(Description = "Community Hospital Web Services.", Namespace = "http://mohawkcollege.ca/chdb")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class CHDB : System.Web.Services.WebService {

    public CHDB () {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }

    /// <summary>
    /// Returns an integer indicating the number of patients registered in the hospital.
    /// </summary>
    /// <returns>Count of registered patients.</returns>
    [WebMethod(Description = "Returns an <b>integer</b> indicating the number of patients registered in the hospital.")]
    public int PatientCount() {
        int count = 0;
        string con_string = WebConfigurationManager.ConnectionStrings["CHDBConnectionString"].ConnectionString;
        SqlConnection con = new SqlConnection(con_string);
        SqlCommand cmd = new SqlCommand("SELECT COUNT(*) FROM Patients", con);

        try
        {
            using (con)
            {
                con.Open();
                count = (int)(cmd.ExecuteScalar());
            }
        }
        catch
        {
        }
        return count;
    }

    /// <summary>
    /// Returns a DataSet of all patient encounters for the specified patient.
    /// </summary>
    /// <param name="PatientID">ID of patient to find encounters for.</param>
    /// <returns>All encounter records for specified patient.</returns>
    [WebMethod(Description = "Returns a <b>DataSet</b> <i>proprietary .NET type</i> of all patient encounters for the specified patient.")]
    public DataSet PatientEncounters(int PatientID)
    {
        DataSet ds = new DataSet();
        string con_string = WebConfigurationManager.ConnectionStrings["CHDBConnectionString"].ConnectionString;
        SqlConnection con = new SqlConnection(con_string);
        string cmd = "SELECT * FROM Encounters WHERE PatientID=" + PatientID.ToString();
        SqlDataAdapter adp = new SqlDataAdapter(cmd, con);

        try
        {
            adp.Fill(ds);
        }
        catch
        {
        }
        return ds;
    }

    /// <summary>
    /// Adds a new encounter record for the specified patient. A boolean will be returned indicating success or failure.
    /// </summary>
    /// <param name="PatientID">Patient ID of patient having encounter.</param>
    /// <param name="PhysicianID">Physician ID of physician giving encounter.</param>
    /// <param name="EncounterDateTime">Date time of encounter (YYYY-MM-DD HH:MM:SS).</param>
    /// <param name="Notes">Notes of encounter.</param>
    /// <returns>True if encounter record successfully added, false if record not added.</returns>
    [WebMethod(Description = "<ul><li>Adds a new encounter record for the specified patient.</li><li>A <b>boolean</b> will be returned indicating success or failure.</li><li>Specify EncounterDateTime in format YYYY-MM-DD HH:MM:SS</li></ul>")]
    public Boolean AddEncounter(int PatientID, int PhysicianID, DateTime EncounterDateTime, string Notes)
    {
        int count = 0;
        string con_string = WebConfigurationManager.ConnectionStrings["CHDBConnectionString"].ConnectionString;
        SqlConnection con = new SqlConnection(con_string);
        SqlCommand cmd = new SqlCommand("INSERT INTO Encounters VALUES(@PatientID, @PhysicianID, @EncounterDateTime, @Notes)", con);
        cmd.Parameters.Add("@PatientID", SqlDbType.Int).Value = PatientID;
        cmd.Parameters.Add("@PhysicianID", SqlDbType.Int).Value = PhysicianID;
        cmd.Parameters.Add("@EncounterDateTime", SqlDbType.DateTime).Value = EncounterDateTime;
        cmd.Parameters.Add("@Notes", SqlDbType.VarChar, 250).Value = Notes;

        try
        {
            using (con)
            {
                con.Open();
                count = cmd.ExecuteNonQuery();
            }
        }
        catch
        {
        }

        if (count == 1)
            return true;
        else
            return false;
    }

    /// <summary>
    /// Get a patient object for the requested patient id.
    /// </summary>
    /// <param name="PatientID">ID of patient to find.</param>
    /// <returns>Patient object, patient id will be -1 if patient not found.</returns>
    [WebMethod(Description = "Return a <b>Patient</b> object for the specified patient. Patient ID of -1 indicates patient not found.")]
    public Patient GetPatient(int PatientID)
    {
        Patient patient = new Patient();

        string con_string = WebConfigurationManager.ConnectionStrings["CHDBConnectionString"].ConnectionString;
        SqlConnection con = new SqlConnection(con_string);
        SqlCommand cmd = new SqlCommand("SELECT FirstName, LastName, Gender, BirthDate FROM Patients WHERE PatientID=" + PatientID.ToString(), con);

        try
        {
            using (con)
            {
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    patient.patientID = PatientID;
                    patient.firstName = reader.GetString(0);
                    patient.lastName = reader.GetString(1);
                    patient.gender = reader.GetString(2);
                    patient.dateOfBirth = reader.GetDateTime(3);
                }
            }
        }
        catch
        {
        }

        return patient;
    }
}