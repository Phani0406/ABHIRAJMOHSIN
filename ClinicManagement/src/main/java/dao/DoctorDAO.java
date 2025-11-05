package dao;
import java.sql.*;
import java.util.*;
import model.Doctor;

public class DoctorDAO {

    public static int addDoctorReturnId(Doctor d) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO doctor(doctor_id, name, specialization, username, password, contact) VALUES(doctor_seq.nextval,?,?,?,?,?)");
        ps.setString(1, d.getName());
        ps.setString(2, d.getSpecialization());
        ps.setString(3, d.getUsername());
        ps.setString(4, d.getPassword());
        ps.setString(5, d.getContact());
        ps.executeUpdate();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT doctor_seq.currval FROM dual");
        int id = rs.next() ? rs.getInt(1) : 0;
        con.close();
        return id;
    }

    public static List<Doctor> getAllDoctors() throws Exception {
        List<Doctor> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT doctor_id, name, specialization FROM doctor ORDER BY name");
        while (rs.next()) list.add(new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3), null, null, null));
        con.close();
        return list;
    }

    public static boolean validateDoctor(String user, String pass) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT 1 FROM doctor WHERE username=? AND password=?");
        ps.setString(1, user); ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        boolean ok = rs.next();
        con.close();
        return ok;
    }
}
