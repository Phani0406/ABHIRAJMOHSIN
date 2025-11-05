<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Admin Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
  <div class="col-md-5 mx-auto">
    <div class="card shadow">
      <div class="card-body p-4">
        <h4 class="mb-3 text-center">Admin Login</h4>
        <form action="AdminLoginServlet" method="post">
          <input type="text" name="username" class="form-control mb-3" placeholder="Username" required>
          <input type="password" name="password" class="form-control mb-3" placeholder="Password" required>
          <button class="btn btn-primary w-100">Login</button>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>
