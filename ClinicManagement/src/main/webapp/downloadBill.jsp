<%@ page import="dao.BillDAO" %>
<%@ page import="model.Bill" %>
<%
 int billId = Integer.parseInt(request.getParameter("bill_id"));
 Bill b = BillDAO.getBillById(billId);
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Bill #<%=billId%></title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>@media print { .no-print { display:none; } }</style>
</head>
<body class="p-4">
  <div class="container border p-4">
    <div class="row">
      <div class="col-8">
        <h3>Clinic Name</h3>
        <p>Address line 1<br/>Phone: +91-XXXXXXXXXX</p>
      </div>
      <div class="col-4 text-end">
        <h4>Bill #: <%=b.getBillId()%></h4>
        <p>Date: <%=b.getBillDate()%></p>
      </div>
    </div>
    <hr/>
    <p><strong>Appointment ID:</strong> <%=b.getAppointmentId()%></p>
    <table class="table">
      <tr><td>Consultation Fee</td><td>₹<%=b.getConsultationFee()%></td></tr>
      <tr><td>Medicine Charges</td><td>₹<%=b.getMedicineCharges()%></td></tr>
      <tr><td>Lab Charges</td><td>₹<%=b.getLabCharges()%></td></tr>
      <tr class="table-success"><td><strong>Total</strong></td><td><strong>₹<%=b.getTotal()%></strong></td></tr>
    </table>
    <div class="text-end no-print">
      <button class="btn btn-primary" onclick="window.print()">Print / Download</button>
      <a class="btn btn-secondary" href="view_bills.jsp">Back</a>
    </div>
  </div>
</body>
</html>
