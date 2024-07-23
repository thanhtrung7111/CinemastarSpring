<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<div
					class="px-3 pb-2 fs-5 text-first border-bottom border-2 border-first">
					Chọn rạp/phim/suất</div>
				<div class="px-3 pb-2 fs-5 text-dark">Chọn ghế</div>
				<div class="px-3 pb-2 fs-5 text-dark">Chọn thức ăn</div>
				<div class="px-3 pb-2 fs-5 text-dark">Thanh toán</div>
				<div class="px-3 pb-2 fs-5 text-dark">Xác nhận</div>
			</div>
		</div>

		<form class="container mt-4" action="/user/chonsuat" method="post">
			<div class="row g-4">
				<div class="col-12 col-lg-8 col-xl-8">
					<div>
						<h4
							class="text-dark border-4 fs-5 border-start border-dark px-2 fw-bold mb-3">
							Lịch chiếu hôm nay</h4>
						<div class="d-flex flex-column row-gap-2">

							<c:forEach items="${mapRapPhim}" var="rapPhim">
								<div class="border rounded-3 p-3">
									<div class="d-flex justify-content-between align-items-center">
										<h4 class="text-dark fs-6 fw-bold">${rapPhim.key.tenRapPhim}</h4>
										<span style="font-size: 13px" class="text-gray">${rapPhim.key.diaChi},${rapPhim.key.thanhPho.tenThanhPho}</span>
									</div>
									<div class="d-flex gap-3 flex-wrap">
										<c:forEach items="${rapPhim.value}" var="suatChieu">
											<a
												href="/user/chonphimchieu?maPhim=${suatChieu.phim.maPhim}&maSuatChieu=${suatChieu.maSuatChieu}&maThanhPho=${rapPhim.key.thanhPho.maThanhPho}"
												class="border border-1 text-decoration-none px-3 py-1 rounded-2 text-dark">
												${suatChieu.thoiGianChieu} - ${suatChieu.thoiGianKetThuc}</a>
										</c:forEach>
									</div>
								</div>

							</c:forEach>

						</div>
					</div>
				</div>
				<div class="col-8 col-md-6 col-lg-4 col-xl-4">
					<jsp:include page="./component/infoticket.jsp"></jsp:include>
					<div class="d-flex column-gap-2 justify-content-end mt-3">
						<a class="btn bg-danger text-white text-sm text-decoration-none"
							href="./danhsachphim.html">Quay lại</a>
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
