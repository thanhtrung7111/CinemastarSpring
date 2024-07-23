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
					<form action="/user/changepassword" method="post"
						class="bg-white rounded-3 py-3 px-3 shadow-sm">
						<h5 class="fw-bolder text-light">Thay đổi mật khẩu</h5>

						<div class="col-6 d-flex flex-column row-gap-2">
							<div>
								<label class="text-sm">Mật khẩu hiện tại</label> <input
									name="matKhauHienTai" type="password"
									class="form-control form-control-sm text-sm"
									placeholder="Nhập mật khẩu hiện tại!" />
							</div>
							<div>
								<label class="text-sm">Mật khẩu mới</label> <input
									type="password" name="matKhauMoi"
									class="form-control form-control-sm text-sm"
									placeholder="Nhập mật khẩu mới!" />
							</div>
							<div>
								<label class="text-sm">Xác nhận mật khẩu mới</label> <input
									name="xacNhanMatKhau" type="password"
									class="form-control form-control-sm text-sm"
									placeholder="Nhập mật khẩu hiện tại!" />
							</div>
						</div>
						<div class="text-danger" style="font-size: 12px">${message}</div>
						<button class="btn btn-sm btn-primary text-sm ms-auto d-block">Đổi
							mật khẩu</button>
					</form>
				</div>
			</div>
		</div>
	</main>

	<jsp:include page="./component/footer.jsp"></jsp:include>
	<script src="../bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="../bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>
