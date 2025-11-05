package servlet;
import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBConnection;

public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("Username entered: " + username);
        System.out.println("Password entered: " + password);

        try (Connection con = DBConnection.getConnection()) {

            // ✅ ADD THIS SNIPPET RIGHT AFTER GETTING CONNECTION
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("SELECT user FROM dual");
            if (r.next()) {
                System.out.println("Connected schema: " + r.getString(1));
            }

            // ✅ Actual login query
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM admin WHERE TRIM(LOWER(USERNAME)) = TRIM(LOWER(?)) AND TRIM(PASSWORD) = TRIM(?)");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("✅ Login success for: " + username);
                HttpSession session = req.getSession();
                session.setAttribute("adminUser", username);
                res.sendRedirect("admin_home.jsp");
            } else {
                System.out.println("❌ No match for: " + username + " / " + password);
                res.sendRedirect("admin_login.jsp?error=1");
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("admin_login.jsp?error=2");
        }
    }
}




//package servlet;
//import java.io.*;
//import java.sql.*;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import dao.DBConnection;
//
//public class AdminLoginServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        
//        System.out.println("Username entered: " + username);
//        System.out.println("Password entered: " + password);
//
//
//        try (Connection con = DBConnection.getConnection()) {
//        	PreparedStatement ps = con.prepareStatement(
//        		    "SELECT * FROM admin WHERE TRIM(LOWER(username)) = TRIM(LOWER(?)) AND TRIM(password) = TRIM(?)");
//            ps.setString(1, username);
//            ps.setString(2, password);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                HttpSession session = req.getSession();
//                session.setAttribute("adminUser", username);
//                res.sendRedirect("admin_home.jsp");
//            } else {
//                res.sendRedirect("admin_login.jsp?error=1");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            res.sendRedirect("admin_login.jsp?error=1");
//        }
//    }
//}
