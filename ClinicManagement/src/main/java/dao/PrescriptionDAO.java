package dao;
import java.sql.*;
import java.util.*;
import model.Prescription;

public class PrescriptionDAO {

    public static void addPrescription(Prescription p) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO prescription VALUES(prescription_seq.nextval, ?, ?, ?)");
        ps.setInt(1, p.getAppointmentId());
        ps.setString(2, p.getMedicines());
        ps.setString(3, p.getDiagnosis());
        ps.executeUpdate();
        con.close();
    }

    public static List<Prescription> getPrescriptionsByAppointment(int appointmentId) throws Exception {
        List<Prescription> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM prescription WHERE appointment_id=?");
        ps.setInt(1, appointmentId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new Prescription(rs.getInt("prescription_id"), rs.getInt("appointment_id"),
                    rs.getString("medicines"), rs.getString("diagnosis")));
        }
        con.close();
        return list;
    }
}
