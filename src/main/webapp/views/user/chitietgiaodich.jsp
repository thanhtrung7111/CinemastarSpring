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
		<div class="container mt-4" style="min-height: 500px">
			<div class="row g-4">
				<jsp:include page="./component/sidebarpersonal.jsp"></jsp:include>

				<div class="col-12 col-lg-7 col-xl-8">
					<div class="bg-white rounded-3 py-3 px-3 shadow-sm">
						<div class="d-flex column-gap-2">
							<a href="/giaodichs" class="text-dark text-decoration-none"><i
								class="ri-corner-down-left-fill"></i></a>
							<h5 class="fw-bolder text-light">Chi tiết giao dịch</h5>
						</div>
						<div class="row">
							<div class="col-5">
								<img
									style="width: 100%; height: 400px; object-fit: contain; object-position: top"
									src="/img/${hoaDon.ves.get(0).suatChieu.phim.hinhAnh}" />
							</div>
							<div class="col-7 fs-5 d-flex flex-column row-gap-2">
								<div class="fw-bolder text-danger">${hoaDon.ves.get(0).suatChieu.phim.tenPhim}</div>
								<div
									class="d-flex align-items-center justify-content-between text-sm">
									<div>
										<span class="fw-bold">Mã hóa đơn: </span>${hoaDon.maHD}</div>
									<div>
										<span class="fw-bold">Ngày lập HD: </span>${hoaDon.ngayLapHD}</div>
								</div>
								<div class="text-sm">
									<span class="fw-bold">Rạp phim: </span>${hoaDon.ves.get(0).suatChieu.phongPhim.rapPhim.tenRapPhim}</div>
								<div class="text-sm">
									<span class="fw-bold">Phòng phim: </span>${hoaDon.ves.get(0).suatChieu.phongPhim.tenPhongPhim}</div>
								<div
									class="d-flex align-items-center justify-content-between text-sm">
									<div>
										<span class="fw-bold">Ngày chiếu: </span>${hoaDon.ves.get(0).suatChieu.ngayChieu}</div>
									<div>
										<span class="fw-bold">Thời gian chiếu: </span>${hoaDon.ves.get(0).suatChieu.thoiGianChieu}</div>
								</div>

								<div class="text-sm">
									<span class="fw-bold">Ghế: </span>
									<c:forEach items="${hoaDon.ves}" var="ve">
										${ve.ghe.tenGhe},
									</c:forEach>
								</div>
								<div class="text-sm">
									<span class="fw-bold">Combo: </span>
									<c:forEach items="${hoaDon.chiTietCombos}" var="combo">
										${combo.chiTietComboID.comboDoAn.tenCombo},
									</c:forEach>
								</div>
								<div class="text-sm">
									<span class="fw-bold">Khuyến mãi: </span>
									<c:forEach items="${hoaDon.apDungKhuyenMais}" var="combo">
										${combo.apDungKhuyenMaiID.khuyenMai.tenKhuyenMai},
									</c:forEach>
								</div>
								<div class="text-sm border-b">
									<span class="fw-bold">Tổng tiền: </span>
									<fmt:formatNumber value="${hoaDon.tongTien}" pattern="#,###" />
									VNĐ
								</div>
								<div class="text-sm border-b">
									<span class="fw-bold">Trạng thái: </span><span
										class="text-white py-1 px-2 ${hoaDon.trangThai ? 'bg-success' : 'bg-danger'}">${hoaDon.trangThai ? 'Đã thanh toán' : 'Chưa thanh toán'}</span>
								</div>
								<div class="text-sm"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</main>

	<jsp:include page="./component/footer.jsp"></jsp:include>
	<script src="../bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="../bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>
