package dao;
import java.sql.*;
import java.util.*;
import model.Patient;

public class PatientDAO {

    public static int addPatientReturnId(Patient p) throws Exception {
        Connection con = DBConnection.getConnection();
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO patient(patient_id, name, contact, email, address) VALUES(patient_seq.nextval, ?,?,?,?)");
            ps.setString(1, p.getName());
            ps.setString(2, p.getContact());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getAddress());
            ps.executeUpdate();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT patient_seq.currval FROM dual");
            int id = 0;
            if (rs.next()) id = rs.getInt(1);
            con.commit();
            return id;
        } catch (Exception ex) {
            con.rollback();
            throw ex;
        } finally {
            con.close();
        }
    }

    public static Patient getPatientById(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM patient WHERE patient_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Patient p = null;
        if (rs.next()) {
            p = new Patient(rs.getInt("patient_id"), rs.getString("name"),
                    rs.getString("contact"), rs.getString("email"), rs.getString("address"));
        }
        con.close();
        return p;
    }

    public static List<Patient> getAllPatients() throws Exception {
        List<Patient> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM patient ORDER BY patient_id DESC");
        while (rs.next()) {
            list.add(new Patient(rs.getInt("patient_id"), rs.getString("name"), rs.getString("contact"),
                    rs.getString("email"), rs.getString("address")));
        }
        con.close();
        return list;
    }
}
