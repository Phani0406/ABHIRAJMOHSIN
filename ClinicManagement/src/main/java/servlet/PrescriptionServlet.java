package servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PrescriptionDAO;
import model.Prescription;

public class PrescriptionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            int appointmentId = Integer.parseInt(req.getParameter("appointment_id"));
            String diagnosis = req.getParameter("diagnosis");
            String medicines = req.getParameter("medicines");

            Prescription p = new Prescription();
            p.setAppointmentId(appointmentId);
            p.setDiagnosis(diagnosis);
            p.setMedicines(medicines);

            PrescriptionDAO.addPrescription(p);
            res.sendRedirect("doctor_home.jsp?msg=prescribed");
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("prescription.jsp?msg=error");
        }
    }
}
