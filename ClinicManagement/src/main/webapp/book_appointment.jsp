<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Appointment</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>

<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">ClinicMS</a>
    <div class="d-flex">
      <a href="admin_home.jsp" class="btn btn-light btn-sm">Back to Dashboard</a>
    </div>
  </div>
</nav>

<div class="container py-5">
  <div class="card shadow-lg border-0">
    <div class="card-body p-5">
      <h3 class="mb-4 text-center text-primary fw-bold">Book Appointment</h3>

      <form action="BookAppointmentServlet" method="post" class="row g-3">

        <div class="col-md-6">
          <label class="form-label">Name</label>
          <input type="text" name="name" class="form-control" placeholder="Full name" required>
        </div>

        <div class="col-md-6">
          <label class="form-label">Contact</label>
          <input type="text" name="contact" class="form-control" placeholder="+91 9XXXXXXXXX" required>
        </div>

        <div class="col-md-6">
          <label class="form-label">Email</label>
          <input type="email" name="email" class="form-control" placeholder="name@example.com">
        </div>

        <div class="col-md-6">
          <label class="form-label">Address</label>
          <input type="text" name="address" class="form-control" placeholder="City, State">
        </div>

        <div class="col-md-6">
          <label class="form-label">Reason / Symptoms</label>
          <input type="text" name="reason" class="form-control" placeholder="e.g. fever, cough, headache" required>
        </div>

        <div class="col-md-6">
          <label class="form-label">Assign Doctor (ID)</label>
          <input type="number" name="doctorId" class="form-control" placeholder="Doctor ID" required>
        </div>

        <div class="col-md-6">
          <label class="form-label">Appointment Date</label>
          <input type="date" name="appointmentDate" class="form-control" required>
        </div>

        <div class="col-md-6">
          <label class="form-label">Appointment Time</label>
          <input type="time" name="appointmentTime" class="form-control" required>
        </div>

        <div class="col-12 text-center mt-4">
          <button type="submit" class="btn btn-success btn-lg px-5">Confirm Appointment</button>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- ✅ SweetAlert messages -->
<%
  String msg = request.getParameter("msg");
  if ("success".equals(msg)) {
%>
<script>
Swal.fire({
  icon: "success",
  title: "Appointment Booked!",
  text: "The appointment was successfully booked.",
  confirmButtonText: "OK"
});
</script>
<%
  } else if ("error".equals(msg)) {
%>
<script>
Swal.fire({
  icon: "error",
  title: "Oops!",
  text: "There was a problem booking the appointment. Try again.",
  confirmButtonText: "Back"
});
</script>
<%
  }
%>

</body>
</html> --%>


 <%@ page import="dao.DoctorDAO" %>
<%@ page import="model.Doctor" %>
<%@ page import="java.util.List" %>
<%
    String msg = request.getParameter("msg");
    String aid = request.getParameter("aid");
    List<Doctor> doctors = DoctorDAO.getAllDoctors();
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Book Appointment</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/custom.css">
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg navbar-white bg-white shadow-sm">
  <div class="container">
    <a class="navbar-brand" href="#">ClinicMS</a>
    <div>
      <a class="btn btn-outline-secondary" href="admin_home.jsp">Back to Dashboard</a>
    </div>
  </div>
</nav>

<div class="container py-5">
  <div class="row justify-content-center">
    <div class="col-lg-10">
      <div class="card shadow-lg">
        <div class="card-body p-5">
          <h2 class="mb-4">Book Appointment</h2>
          <p class="text-muted">Enter patient details and appointment info. Use Patient ID to reuse an existing patient.</p>

          <form action="BookAppointmentServlet" method="post" class="row g-3">
            <!-- LEFT: Patient -->
            <div class="col-md-4">
              <div class="mb-3">
                <label class="form-label">Patient ID (optional)</label>
                <input type="text" name="patient_id" class="form-control" placeholder="Existing patient id (if any)">
              </div>
              <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text" name="name" class="form-control" placeholder="Full name" required>
              </div>
              <div class="mb-3">
                <label class="form-label">Contact</label>
                <input type="tel" name="contact" class="form-control" placeholder="+91 9XXXXXXXXX" required>
              </div>
              <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" class="form-control" placeholder="name@example.com">
              </div>
              <div class="mb-3">
                <label class="form-label">Address</label>
                <textarea name="address" class="form-control" rows="2" placeholder="Address"></textarea>
              </div>
            </div>

            <!-- RIGHT: Appointment -->
            <div class="col-md-8">
              <div class="row">
                <div class="col-md-6 mb-3">
                  <label class="form-label">Assign Doctor</label>
                  <select name="doctor_id" class="form-select" required>
                    <option value="">Choose doctor</option>
                    <% for (Doctor d : doctors) { %>
                      <option value="<%=d.getDoctorId()%>"><%=d.getName()%> — <%=d.getSpecialization()%></option>
                    <% } %>
                  </select>
                </div>
                <div class="col-md-3 mb-3">
                  <label class="form-label">Appointment Date</label>
                  <input type="date" name="appointment_date" class="form-control" required>
                </div>
                <div class="col-md-3 mb-3">
                  <label class="form-label">Time</label>
                  <input type="time" name="appointment_time" class="form-control" required>
                </div>
              </div>

              <div class="mb-3">
                <label class="form-label">Reason for Visit</label>
                <textarea name="reason" class="form-control" rows="4" placeholder="e.g. fever, checkup, cough"></textarea>
              </div>

              <div class="text-end mt-4">
                <button type="submit" class="btn btn-success btn-lg">Confirm Appointment</button>
              </div>
            </div>
          </form>

        </div>
      </div>
    </div>
  </div>
</div>

<!-- Success Modal -->
<div class="modal fade" id="successModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-sm modal-dialog-centered">
    <div class="modal-content border-0 shadow">
      <div class="modal-body text-center p-4">
        <div class="mb-3">
          <svg width="64" height="64" viewBox="0 0 24 24" fill="none" class="mb-2">
            <path d="M12 2a10 10 0 100 20 10 10 0 000-20z" fill="#28a745"/>
            <path d="M7 12l2.5 2.5L17 7" stroke="#fff" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
          </svg>
        </div>
        <h5 class="mb-1">Appointment Booked</h5>
        <p class="text-muted mb-3">Your appointment has been scheduled successfully.</p>
        <div class="d-grid">
          <a href="book_appointment.jsp" class="btn btn-primary">Book Another</a>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Error Modal -->
<div class="modal fade" id="errorModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-sm modal-dialog-centered">
    <div class="modal-content border-0 shadow">
      <div class="modal-body text-center p-4">
        <h5 class="mb-1 text-danger">Oops!</h5>
        <p class="text-muted mb-3">There was a problem booking the appointment. Try again.</p>
        <div class="d-grid">
          <a href="book_appointment.jsp" class="btn btn-secondary">Back</a>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
  (function(){
    const params = new URLSearchParams(window.location.search);
    if (params.get('msg') === 'success') {
      const m = new bootstrap.Modal(document.getElementById('successModal'));
      m.show();
    } else if (params.get('msg') === 'error') {
      const m = new bootstrap.Modal(document.getElementById('errorModal'));
      m.show();
    }
  })();
</script>
</body>
</html>
