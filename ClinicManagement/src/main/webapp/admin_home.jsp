<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Admin Dashboard</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg navbar-white bg-white shadow-sm">
  <div class="container">
    <a class="navbar-brand" href="#">ClinicMS - Admin</a>
    <div>
      <a href="LogoutServlet" class="btn btn-outline-danger btn-sm">Logout</a>
    </div>
  </div>
</nav>

<div class="container py-4">
  <div class="row">
    <div class="col-md-3">
      <div class="list-group shadow">
        <a href="book_appointment.jsp" class="list-group-item list-group-item-action">Book Appointment</a>
        <a href="patient.jsp" class="list-group-item list-group-item-action"> Patients</a>
        <a href="doctor.jsp" class="list-group-item list-group-item-action"> Doctors</a>
        <a href="bill.jsp" class="list-group-item list-group-item-action"> Generate Bill</a>
        <a href="view_bills.jsp" class="list-group-item list-group-item-action">View Bills</a>
      </div>
    </div>

    <div class="col-md-9">
      <div class="card shadow">
        <div class="card-body">
          <h4>Welcome, Admin</h4>
          <p class="text-muted">Use the left menu to manage clinic functions.</p>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
