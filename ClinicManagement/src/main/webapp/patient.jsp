<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Patients</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
  <div class="card shadow">
    <div class="card-body p-4">
      <h4>Add Patient</h4>
      <form action="PatientServlet" method="post" class="row g-3">
        <div class="col-md-6"><input name="name" class="form-control" placeholder="Name" required></div>
        <div class="col-md-6"><input name="contact" class="form-control" placeholder="Contact" required></div>
        <div class="col-md-6"><input name="email" class="form-control" placeholder="Email"></div>
        <div class="col-md-6"><input name="address" class="form-control" placeholder="Address"></div>
        <div class="col-12 text-end"><button class="btn btn-primary">Save</button></div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
