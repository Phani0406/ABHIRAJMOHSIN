<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Generate Bill</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
  <div class="card shadow-lg">
    <div class="card-body p-5">
      <h3 class="mb-4">Generate Bill</h3>
      <form action="BillServlet" method="post" class="row g-3">
        <div class="col-md-6">
          <label class="form-label">Appointment ID</label>
          <input type="number" name="appointment_id" class="form-control" required>
        </div>
        <div class="col-md-6">
          <label class="form-label">Consultation Fee (₹)</label>
          <input type="number" step="0.01" name="consultation_fee" class="form-control" required>
        </div>
        <div class="col-md-6">
          <label class="form-label">Medicine Charges (₹)</label>
          <input type="number" step="0.01" name="medicine_charges" class="form-control" required>
        </div>
        <div class="col-md-6">
          <label class="form-label">Lab Charges (₹)</label>
          <input type="number" step="0.01" name="lab_charges" class="form-control" required>
        </div>

        <div class="col-12 text-end mt-4">
          <button type="submit" class="btn btn-success px-5">Generate Bill</button>
        </div>
      </form>
    </div>
  </div>
</div>

<script>
  const params = new URLSearchParams(window.location.search);
  if (params.get('msg') === 'success') alert("✅ Bill generated successfully!");
  if (params.get('msg') === 'error') alert("❌ Error generating bill.");
</script>
</body>
</html>
