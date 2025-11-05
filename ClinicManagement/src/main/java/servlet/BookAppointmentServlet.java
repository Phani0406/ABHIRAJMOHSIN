package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnection;

public class BookAppointmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String reason = request.getParameter("reason");
        String doctorId = request.getParameter("doctorId");
        String date = request.getParameter("appointmentDate");
        String time = request.getParameter("appointmentTime");

        boolean success = false;

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO appointment (appointment_id, name, contact, email, address, reason, doctor_id, appointment_date, appointment_time) " +
                "VALUES (appointment_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, name);
            ps.setString(2, contact);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, reason);
            ps.setInt(6, Integer.parseInt(doctorId));
            ps.setString(7, date);
            ps.setString(8, time);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                success = true;
                System.out.println("✅ Appointment added successfully for: " + name);
            } else {
                System.out.println("❌ Appointment insert returned 0 rows.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (success) {
            response.sendRedirect("appointment.jsp?msg=success");
        } else {
            response.sendRedirect("appointment.jsp?msg=error");
        }
    }
}






//package servlet;
//
//import java.io.*;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dao.*;
//import model.*;
//
//public class BookAppointmentServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            req.setCharacterEncoding("UTF-8");
//            String patientIdStr = req.getParameter("patient_id"); // optional
//            String name = req.getParameter("name");
//            String contact = req.getParameter("contact");
//            String email = req.getParameter("email");
//            String address = req.getParameter("address");
//            String reason = req.getParameter("reason");
//            int doctorId = Integer.parseInt(req.getParameter("doctor_id"));
//            String date = req.getParameter("appointment_date"); // YYYY-MM-DD
//            String time = req.getParameter("appointment_time"); // HH:mm
//
//            int patientId = 0;
//            if (patientIdStr != null && !patientIdStr.trim().isEmpty()) {
//                patientId = Integer.parseInt(patientIdStr);
//                Patient existing = PatientDAO.getPatientById(patientId);
//                if (existing == null) {
//                    Patient p = new Patient();
//                    p.setName(name); p.setContact(contact); p.setEmail(email); p.setAddress(address);
//                    patientId = PatientDAO.addPatientReturnId(p);
//                }
//            } else {
//                Patient p = new Patient();
//                p.setName(name); p.setContact(contact); p.setEmail(email); p.setAddress(address);
//                patientId = PatientDAO.addPatientReturnId(p);
//            }
//
//            Appointment app = new Appointment();
//            app.setPatientId(patientId);
//            app.setDoctorId(doctorId);
//            app.setDate(date);
//            app.setTime(time);
//            app.setReason(reason);
//            int appointmentId = AppointmentDAO.bookAppointmentReturnId(app);
//
//            resp.sendRedirect("book_appointment.jsp?msg=success&aid=" + appointmentId);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            resp.sendRedirect("book_appointment.jsp?msg=error");
//        }
//    }
//}
