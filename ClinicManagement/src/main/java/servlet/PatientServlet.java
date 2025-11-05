package servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDAO;
import model.Patient;

public class PatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            Patient p = new Patient();
            p.setName(req.getParameter("name"));
            p.setContact(req.getParameter("contact"));
            p.setEmail(req.getParameter("email"));
            p.setAddress(req.getParameter("address"));
            PatientDAO.addPatientReturnId(p);
            res.sendRedirect("patient.jsp?msg=added");
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("patient.jsp?msg=error");
        }
    }
}
