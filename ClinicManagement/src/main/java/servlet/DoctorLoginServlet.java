package servlet;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DoctorDAO;

public class DoctorLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        try {
            boolean ok = DoctorDAO.validateDoctor(user, pass);
            if (ok) {
                HttpSession session = req.getSession();
                session.setAttribute("doctorUser", user);
                // Optionally fetch doctor id and store
                res.sendRedirect("doctor_home.jsp");
            } else {
                res.sendRedirect("doctor_login.jsp?error=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("doctor_login.jsp?error=1");
        }
    }
}
