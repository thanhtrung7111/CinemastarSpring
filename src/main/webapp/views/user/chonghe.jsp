<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<div
			class="bg-white py-4 d-flex justify-content-center align-items-center">
			<div class="border-1 border-bottom d-flex" style="width: fit-content">
				<div class="px-3 pb-2 fs-5 text-dark">Chọn rạp/phim/suất</div>
				<div
					class="px-3 pb-2 fs-5 text-first border-bottom border-2 border-first">
					Chọn ghế</div>
				<div class="px-3 pb-2 fs-5 text-dark">Chọn thức ăn</div>
				<div class="px-3 pb-2 fs-5 text-dark">Thanh toán</div>
				<div class="px-3 pb-2 fs-5 text-dark">Xác nhận</div>
			</div>
		</div>

		<form class="container mt-4" action="/user/chonghe" method="post">
			<div class="row g-4">
				<div class="col-12 col-xl-8">
					<div
						class="d-flex gap-3 flex-wrap align-items-center bg-white py-3 px-5 rounded-3 shadow-sm mb-4">
						<span>Đổi suất chiếu:</span>
						<c:forEach items="${suatChieus}" var="itemSuatChieu">

							<button
								formaction="/user/chonsuat?id=${itemSuatChieu.maSuatChieu}"
								class="border border-1 px-3 py-1 rounded-2 ${sessionScope.suatChieu.get().maSuatChieu == itemSuatChieu.maSuatChieu ? 'text-white bg-second' : ' text-dark bg-white'}">
								${itemSuatChieu.thoiGianChieu} -
								${itemSuatChieu.thoiGianKetThuc}</button>
						</c:forEach>

					</div>

					<div class="px-4 bg-white py-5 shadow-sm">
						<div class="bg-second" style="height: 5px; width: 100%"></div>
						<div class="d-block text-center mb-5 text-light">Màn hình</div>
						<div class="d-flex flex-column row-gap-2">

							<c:forEach items="${hangGhes}" var="hangGhe">
								<div class="d-flex">
									<span class="text-dark fw-bolder">${hangGhe.key.tenHangGhe}</span>
									<div
										class="flex-fill d-flex column-gap-2 justify-content-center px-5 grid-col-10">
										<c:forEach items="${hangGhe.value}" var="ve">
											<input hidden name="ves"
												${ve.hoaDon != null ? 'disabled' : ''} id="${ve.maVe}"
												value="${ve.maVe}" type="checkbox" />
											<label for="${ve.maVe}" style="width: 30px; height: 30px"
												class="border d-flex ${ve.hoaDon != null ? 'bg-secondary text-white' : 'bg-white text-dark  checkghe'} align-items-center justify-content-center rounded-2 text-sm">
												${ve.ghe.tenGhe}</label>
										</c:forEach>

									</div>

									<span class="text-dark fw-bolder">${hangGhe.key.tenHangGhe}</span>
								</div>
							</c:forEach>
						</div>

						<div class="border-top mt-3 py-2">
							<div class="d-flex align-items-center column-gap-4">
								<div class="d-flex align-items-center column-gap-md-2">
									<div style="width: 30px; height: 30px"
										class="border d-flex bg-dark align-items-center justify-content-center rounded-2 text-sm"></div>
									<span>Ghế đã bán</span>
								</div>
								<div class="d-flex align-items-center column-gap-md-2">
									<div style="width: 30px; height: 30px"
										class="border d-flex bg-second align-items-center justify-content-center rounded-2 text-sm"></div>
									<span>Ghế đang chọn</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-12 col-xl-4">
					<jsp:include page="./component/infoticket.jsp"></jsp:include>
					<div class="d-flex column-gap-2 justify-content-end mt-3">
						<a class="btn bg-danger text-white text-sm text-decoration-none"
							href="./muave.html">Quay lại</a>
						<button
							class="btn bg-first text-white text-sm text-decoration-none">Tiếp
							tục</button>
					</div>
				</div>
			</div>
		</form>
	</main>

	<jsp:include page="./component/footer.jsp"></jsp:include>

	<script src="../bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="../bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>
