package dao;

import java.sql.*;
import java.util.*;
import model.Appointment;

public class AppointmentDAO {

    // ✅ Book appointment and return generated ID
    public static int bookAppointmentReturnId(Appointment a) throws Exception {
        Connection con = DBConnection.getConnection();
        int id = 0;

        try {
            con.setAutoCommit(false);

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO appointment1(appointment_id, patient_id, doctor_id, appointment_date, appointment_time, reason, status) " +
                "VALUES(appointment_seq.nextval, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, 'Scheduled')"
            );

            ps.setInt(1, a.getPatientId());
            ps.setInt(2, a.getDoctorId());
            ps.setString(3, a.getDate());
            ps.setString(4, a.getTime());
            ps.setString(5, a.getReason());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT appointment_seq.currval FROM dual");
                if (rs.next()) {
                    id = rs.getInt(1);
                    System.out.println("✅ Appointment booked successfully! Appointment ID: " + id);
                }
                con.commit();
            } else {
                System.out.println("❌ Appointment insertion returned 0 rows.");
                con.rollback();
            }

        } catch (Exception ex) {
            con.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            con.close();
        }

        return id;
    }

    // ✅ Get all appointments for a specific doctor
    public static List<Appointment> getAppointmentsByDoctor(int doctorId) throws Exception {
        List<Appointment> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM appointment WHERE doctor_id=? ORDER BY appointment_date, appointment_time"
            );
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment a = new Appointment(
                    rs.getInt("appointment_id"),
                    rs.getInt("patient_id"),
                    rs.getInt("doctor_id"),
                    rs.getString("appointment_date"),
                    rs.getString("appointment_time"),
                    rs.getString("reason"),
                    rs.getString("status")
                );
                list.add(a);
            }

        } finally {
            con.close();
        }
        return list;
    }

    // ✅ Get all appointments (admin view)
    public static List<Appointment> getAllAppointments() throws Exception {
        List<Appointment> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM appointment ORDER BY appointment_date DESC, appointment_time DESC"
            );

            while (rs.next()) {
                list.add(new Appointment(
                    rs.getInt("appointment_id"),
                    rs.getInt("patient_id"),
                    rs.getInt("doctor_id"),
                    rs.getString("appointment_date"),
                    rs.getString("appointment_time"),
                    rs.getString("reason"),
                    rs.getString("status")
                ));
            }

        } finally {
            con.close();
        }

        return list;
    }
}







//package dao;
//import java.sql.*;
//import java.util.*;
//import model.Appointment;
//
//public class AppointmentDAO {
//    public static int bookAppointmentReturnId(Appointment a) throws Exception {
//        Connection con = DBConnection.getConnection();
//        try {
//            con.setAutoCommit(false);
//            PreparedStatement ps = con.prepareStatement(
//                "INSERT INTO appointment(appointment_id, patient_id, doctor_id, appointment_date, appointment_time, reason, status) " +
//                "VALUES(appointment_seq.nextval, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, 'Scheduled')");
//            ps.setInt(1, a.getPatientId());
//            ps.setInt(2, a.getDoctorId());
//            ps.setString(3, a.getDate());
//            ps.setString(4, a.getTime());
//            ps.setString(5, a.getReason());
//            ps.executeUpdate();
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT appointment_seq.currval FROM dual");
//            int id = rs.next() ? rs.getInt(1) : 0;
//            con.commit();
//            return id;
//        } catch (Exception ex) {
//            con.rollback();
//            throw ex;
//        } finally {
//            con.close();
//        }
//    }
//
//    public static List<Appointment> getAppointmentsByDoctor(int doctorId) throws Exception {
//        List<Appointment> list = new ArrayList<>();
//        Connection con = DBConnection.getConnection();
//        PreparedStatement ps = con.prepareStatement("SELECT * FROM appointment1 WHERE doctor_id=? ORDER BY appointment_date, appointment_time");
//        ps.setInt(1, doctorId);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            Appointment a = new Appointment(rs.getInt("appointment_id"), rs.getInt("patient_id"),
//                    rs.getInt("doctor_id"), rs.getString("appointment_date"),
//                    rs.getString("appointment_time"), rs.getString("reason"),
//                    rs.getString("status"));
//            list.add(a);
//        }
//        con.close();
//        return list;
//    }
//
//    public static List<Appointment> getAllAppointments() throws Exception {
//        List<Appointment> list = new ArrayList<>();
//        Connection con = DBConnection.getConnection();
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * FROM appointment1 ORDER BY appointment_date DESC, appointment_time DESC");
//        while (rs.next()) {
//            list.add(new Appointment(rs.getInt("appointment_id"), rs.getInt("patient_id"),
//                    rs.getInt("doctor_id"), rs.getString("appointment_date"),
//                    rs.getString("appointment_time"), rs.getString("reason"),
//                    rs.getString("status")));
//        }
//        con.close();
//        return list;
//    }
//}
