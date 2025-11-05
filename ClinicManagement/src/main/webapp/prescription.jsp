<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Add Prescription</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
  <div class="card shadow">
    <div class="card-body p-4">
      <h4>Add Prescription</h4>
      <form action="PrescriptionServlet" method="post" class="row g-3">
        <div class="col-md-6"><input name="appointment_id" class="form-control" placeholder="Appointment ID" required></div>
        <div class="col-12"><textarea name="diagnosis" class="form-control" placeholder="Diagnosis" rows="3"></textarea></div>
        <div class="col-12"><textarea name="medicines" class="form-control" placeholder="Medicines & dosage" rows="4"></textarea></div>
        <div class="col-12 text-end"><button class="btn btn-primary">Save Prescription</button></div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
