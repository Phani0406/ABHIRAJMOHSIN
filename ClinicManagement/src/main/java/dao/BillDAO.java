package dao;
import java.sql.*;
import java.util.*;
import model.Bill;

public class BillDAO {

    public static void generateBill(Bill b) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO bill VALUES(bill_seq.nextval, ?, ?, ?, ?, ?, SYSDATE)");
        ps.setInt(1, b.getAppointmentId());
        ps.setDouble(2, b.getConsultationFee());
        ps.setDouble(3, b.getMedicineCharges());
        ps.setDouble(4, b.getLabCharges());
        ps.setDouble(5, b.getTotal());
        ps.executeUpdate();
        con.close();
    }

    public static List<Bill> getAllBills() throws Exception {
        List<Bill> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM bill ORDER BY bill_date DESC");
        while (rs.next()) {
            Bill b = new Bill(
                rs.getInt("bill_id"),
                rs.getInt("appointment_id"),
                rs.getDouble("consultation_fee"),
                rs.getDouble("medicine_charges"),
                rs.getDouble("lab_charges"),
                rs.getDouble("total"),
                rs.getDate("bill_date")
            );
            list.add(b);
        }
        con.close();
        return list;
    }

    public static Bill getBillById(int billId) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM bill WHERE bill_id=?");
        ps.setInt(1, billId);
        ResultSet rs = ps.executeQuery();
        Bill b = null;
        if (rs.next()) {
            b = new Bill(
                rs.getInt("bill_id"),
                rs.getInt("appointment_id"),
                rs.getDouble("consultation_fee"),
                rs.getDouble("medicine_charges"),
                rs.getDouble("lab_charges"),
                rs.getDouble("total"),
                rs.getDate("bill_date")
            );
        }
        con.close();
        return b;
    }
}
