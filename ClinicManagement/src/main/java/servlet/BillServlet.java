package servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BillDAO;
import model.Bill;

public class BillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            int appointmentId = Integer.parseInt(req.getParameter("appointment_id"));
            double consultationFee = Double.parseDouble(req.getParameter("consultation_fee"));
            double medicineCharges = Double.parseDouble(req.getParameter("medicine_charges"));
            double labCharges = Double.parseDouble(req.getParameter("lab_charges"));

            double total = consultationFee + medicineCharges + labCharges;

            Bill b = new Bill();
            b.setAppointmentId(appointmentId);
            b.setConsultationFee(consultationFee);
            b.setMedicineCharges(medicineCharges);
            b.setLabCharges(labCharges);
            b.setTotal(total);

            BillDAO.generateBill(b);
            res.sendRedirect("view_bills.jsp?msg=success");
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("bill.jsp?msg=error");
        }
    }
}
