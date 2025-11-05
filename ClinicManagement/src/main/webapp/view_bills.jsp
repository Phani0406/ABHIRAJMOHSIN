<%@ page import="dao.BillDAO" %>
<%@ page import="model.Bill" %>
<%@ page import="java.util.List" %>
<%
 List<Bill> bills = BillDAO.getAllBills();
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>View Bills</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
  <div class="card shadow">
    <div class="card-body">
      <h3>All Bills</h3>
      <table class="table table-hover mt-3">
        <thead><tr><th>Bill ID</th><th>Appointment ID</th><th>Total</th><th>Date</th><th>Action</th></tr></thead>
        <tbody>
          <% for (Bill b : bills) { %>
            <tr>
              <td><%=b.getBillId()%></td>
              <td><%=b.getAppointmentId()%></td>
              <td>₹<%=b.getTotal()%></td>
              <td><%=b.getBillDate()%></td>
              <td><a href="downloadBill.jsp?bill_id=<%=b.getBillId()%>" class="btn btn-outline-primary btn-sm">View/Print</a></td>
            </tr>
          <% } %>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>
