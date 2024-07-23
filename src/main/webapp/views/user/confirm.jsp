<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<main class="" style="min-height: 600px">
		<div
			class="bg-white py-4 d-flex justify-content-center align-items-center">
			<div class="border-1 border-bottom d-flex" style="width: fit-content">
				<div class="px-3 pb-2 fs-5 text-dark">Chọn rạp/phim/suất</div>
				<div class="px-3 pb-2 fs-5 text-dark">Chọn ghế</div>
				<div class="px-3 pb-2 fs-5 text-dark">Chọn thức ăn</div>
				<div class="px-3 pb-2 fs-5 text-dark">Thanh toán</div>
				<div
					class="px-3 pb-2 fs-5 text-first border-bottom border-2 border-first">Xác
					nhận</div>
			</div>
		</div>
		<div class="d-flex flex-column row-gap-2 mt-3 align-items-center">
			<h5>${status ? 'Đặt vé thành công' : 'Đặt vé thất bại'}</h5>
			<div>
				<c:if test="${status}">
					<a href="/home"
						class="rounded-3 bg-first text-white text-decoration-none px-3 py-2"
						style="width: fit-content">Quay về trang chủ</a>
					<a href="/history"
						class="rounded-3 bg-first text-white text-decoration-none px-3 py-2"
						style="width: fit-content">Xem vé đã đặt</a>
				</c:if>

				<c:if test="${status == false}">
					<a href="${sessionScope.url}"
						class="rounded-3 bg-first text-white text-decoration-none px-3 py-2"
						style="width: fit-content">Thanh toán hóa đơn</a>
				</c:if>
			</div>
		</div>
	</main>

	<jsp:include page="./component/footer.jsp"></jsp:include>
	<script src="../bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="../bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>
