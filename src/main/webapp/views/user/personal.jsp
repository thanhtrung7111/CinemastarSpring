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
<title>Trang chủ</title>
</head>
<body>
	<jsp:include page="./component/modallogin.jsp"></jsp:include>
	<jsp:include page="./component/modalregister.jsp"></jsp:include>
	<jsp:include page="./component/header.jsp"></jsp:include>
	<!-- main  -->
	<main>
		<!-- <div
        class="bg-white py-4 d-flex justify-content-center align-items-center"
      >
        <div class="border-1 border-bottom d-flex" style="width: fit-content">
          <div class="px-3 pb-2 fs-5 text-dark">Chọn rạp/phim/suất</div>
          <div
            class="px-3 pb-2 fs-5 text-first border-bottom border-2 border-first"
          >
            Chọn ghế
          </div>
          <div class="px-3 pb-2 fs-5 text-dark">Chọn thức ăn</div>
          <div class="px-3 pb-2 fs-5 text-dark">Thanh toán</div>
          <div class="px-3 pb-2 fs-5 text-dark">Xác nhận</div>
        </div>
      </div> -->

		<div class="container mt-4">
			<div class="row g-4">

				<jsp:include page="./component/sidebarpersonal.jsp"></jsp:include>

				<div class="col-12 col-lg-7 col-xl-8">
					<form:form modelAttribute="taiKhoan" action="/user/personal"
						method="post" class="bg-white rounded-3 py-3 px-3 shadow-sm">
						<h5 class="fw-bolder text-light">Thông tin cá nhân</h5>
						<div class="row g-3">

							<form:input type="text" path="maTaiKhoan"
								class="form-control text-sm d-none" placeholder="Nhập họ và tên" />

							<div class="col-6">
								<div>
									<label class="form-label text-sm">Họ và tên</label>
									<form:input type="text" path="tenTaiKhoan"
										class="form-control text-sm"
										cssErrorClass="border-danger form-control text-sm"
										placeholder="Nhập họ và tên" />
									<form:errors path="tenTaiKhoan" cssStyle="font-size:12px"
										cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="col-6">
								<div>
									<label class="form-label text-sm">Email</label>
									<form:input type="text" path="email"
										cssErrorClass="border-danger form-control text-sm"
										class="form-control text-sm" placeholder="Nhập email" />
									<form:errors path="email" cssStyle="font-size:12px"
										cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="col-6">
								<div>
									<label class="form-label text-sm">Số điện thoại</label>
									<form:input type="text" path="soDienThoai"
										cssErrorClass="border-danger form-control text-sm"
										class="form-control text-sm" placeholder="Nhập số điện thoại" />
									<form:errors path="soDienThoai" cssStyle="font-size:12px"
										cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="col-6">
								<div>
									<label class="form-label text-sm">Ngày sinh</label>
									<form:input type="date" class="form-control text-sm"
										cssErrorClass="border-danger form-control text-sm"
										path="ngaySinh" placeholder="Nhập số điện thoại" />
									<form:errors path="ngaySinh" cssStyle="font-size:12px"
										cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="col-6">
								<label class="form-label text-sm">Giới tính</label>
								<form:select path="gioiTinh" class="form-select text-sm"
									aria-label="Default select example">

									<form:option value="true">Nam</form:option>
									<form:option value="false">Nữ</form:option>
								</form:select>
							</div>
							<form:input type="password" class="form-control text-sm d-none"
								path="matKhau" placeholder="Nhập số điện thoại" />
							<form:input type="text" class="form-control text-sm d-none"
								path="trangThai" value="true" />
							<form:input type="text" class="form-control text-sm d-none"
								path="loaiTaiKhoan.maLoaiTaiKhoan" />
							<div>
								<button class="btn bg-first text-white text-sm ms-auto d-block">
									Cập nhật thông tin</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</main>

	<jsp:include page="./component/footer.jsp"></jsp:include>
	<script src="../bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="../bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>
