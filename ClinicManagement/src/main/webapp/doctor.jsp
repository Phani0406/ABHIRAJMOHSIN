<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Doctors</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">

  <div class="card shadow">
    <div class="card-body p-4">
      <h4 class="mb-3">Add Doctor</h4>

      <!-- ✅ Success / Error message -->
      <%
        String msg = request.getParameter("msg");
        if ("success".equals(msg)) {
      %>
        <div class="alert alert-success alert-dismissible fade show" role="alert">
          ✅ Doctor added successfully!
          <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
      <% } else if ("error".equals(msg)) { %>
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
          ❌ Error adding doctor. Please try again.
          <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
      <% } %>
