<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Jura:wght@300..700&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="../bootstrap-5.3.3-dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/remixicon/4.2.0/remixicon.min.css" />
<link rel="stylesheet" href="../bootstrap-5.3.3-dist/css/style.css" />
<title>Quản trị viên</title>
</head>
<body style="height: 100vh" class="d-flex flex-column">
	<header class="bg-white py-4 shadow-sm sticky-top">
		<!-- logo  -->
		<div
			class="container d-flex justify-content-between align-items-center">
			<div class="d-flex">
				<span class="fw-bolder fs-3 text-first">Cinema</span>
				<div class="d-flex align-items-start">
					<span class="fw-medium text-danger text-sm">Star</span> <i
						class="ri-star-fill text-xs text-third"></i>
				</div>
			</div>
			<div class="d-flex align-items-center column-gap-2">
				<i class="ri-customer-service-line"></i> Quản trị viên
			</div>
		</div>
	</header>
	<!-- main  -->
	<main class="mt-4 flex-fill">
		<form:form action="/admin/login" method="post" modelAttribute="entity">
			<div class="mx-auto bg-white shadow-sm px-3 py-4 rounded-3"
				style="width: 500px">
				<h3 class="fw-bold mb-3 mt-3 text-center">Đăng nhập</h3>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Tài
						khoản</label>
					<form:input type="text" path="email" class="form-control"
						id="exampleFormControlInput1" placeholder="name@example.com" />
					<form:errors path="email" cssClass="text-danger"
						style="font-size:12px"></form:errors>
				</div>
				<div class="mb-4">
					<label for="exampleFormControlInput1" class="form-label">Mật
						khẩu</label>
					<form:password class="form-control" path="matKhau"
						id="exampleFormControlInput1" placeholder="Hãy nhập mật khẩu" />
					<form:errors path="matKhau" cssClass="text-danger"
						style="font-size:12px"></form:errors>
				</div>
				<div class="mb-3 text-center">
					<button class="btn bg-first text-white w-100" type="submit">Đăng
						nhập</button>
				</div>
				<p class="text-danger" style="font-size: 12px">${error }</p>
			</div>
		</form:form>
	</main>
	<div class="d-block text-center py-2 text-dark text-sm bg-white">
		Dự án được thiết kế dựa trên Gallaxy Cinema</div>
	<script src="./bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="./bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>
