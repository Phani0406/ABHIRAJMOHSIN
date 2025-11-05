package servlet;


import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoctorDAO;
import model.Doctor;

public class DoctorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Get data from doctor.jsp form
            String name = request.getParameter("name");
            String specialization = request.getParameter("specialization");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String contact = request.getParameter("contact");

            // Create a Doctor model object and set values
            Doctor doctor = new Doctor();
            doctor.setName(name);
            doctor.setSpecialization(specialization);
            doctor.setUsername(username);
            doctor.setPassword(password);
            doctor.setContact(contact);

            // Save doctor to DB and get generated doctor_id
            int doctorId = DoctorDAO.addDoctorReturnId(doctor);

            // Redirect back to doctor.jsp with a success message
            response.sendRedirect("doctor.jsp?msg=success&id=" + doctorId);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("doctor.jsp?msg=error");
        }
    }
}
