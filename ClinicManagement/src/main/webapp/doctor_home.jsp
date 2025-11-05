<%@ page import="dao.AppointmentDAO" %>
<%@ page import="model.Appointment" %>
<%@ page import="java.util.List" %>
<%
  // Simple demo: show all appointments (filter by doctorId if stored in session)
  List<Appointment> appts = AppointmentDAO.getAllAppointments();
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Doctor Dashboard</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg navbar-white bg-white shadow-sm">
  <div class="container">
    <a class="navbar-brand" href="#">ClinicMS - Doctor</a>
    <div>
      <a href="LogoutServlet" class="btn btn-outline-danger btn-sm">Logout</a>
    </div>
  </div>
</nav>

<div class="container py-4">
  <h4>Your Appointments</h4>
  <div class="card shadow mt-3">
    <div class="card-body">
      <table class="table">
        <thead><tr><th>ID</th><th>Patient ID</th><th>Date</th><th>Time</th><th>Reason</th></tr></thead>
        <tbody>
          <% for (Appointment a : appts) { %>
            <tr>
              <td><%=a.getAppointmentId()%></td>
              <td><%=a.getPatientId()%></td>
              <td><%=a.getDate()%></td>
              <td><%=a.getTime()%></td>
              <td><%=a.getReason()%></td>
            </tr>
          <% } %>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>
