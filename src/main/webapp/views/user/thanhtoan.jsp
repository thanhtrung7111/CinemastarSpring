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
	<main>
		<div
			class="bg-white py-4 d-flex justify-content-center align-items-center">
			<div class="border-1 border-bottom d-flex" style="width: fit-content">
				<div class="px-3 pb-2 fs-5 text-dark">Chọn rạp/phim/suất</div>
				<div class="px-3 pb-2 fs-5 text-dark">Chọn ghế</div>
				<div class="px-3 pb-2 fs-5 text-dark">Chọn thức ăn</div>
				<div
					class="px-3 pb-2 fs-5 text-first border-bottom border-2 border-first">
					Thanh toán</div>
				<div class="px-3 pb-2 fs-5 text-dark">Xác nhận</div>
			</div>
		</div>

		<form action="/user/thanhtoan" method="post" class="container mt-4">
			<div class="row">
				<div class="col-12 col-lg-7 col-xl-8">
					<div
						class="gap-3 align-items-center bg-white py-3 px-4 rounded-3 shadow-sm mb-4">

						<h5 class="text-dark mb-3 fs-6">Khuyến mãi dành cho bạn</h5>
						<div class="d-flex column-gap-2 mb-3">
							<select name="khuyenMai" class="form-select form-select-sm"
								aria-label="Default select example">
								<c:forEach items="${khuyenMais}" var="itemKhuyenMai">
									<option
										${khuyenMai.get().maKhuyenMai == itemKhuyenMai.maKhuyenMai ? 'selected' : ''}
										value="${itemKhuyenMai.maKhuyenMai}">${itemKhuyenMai.tenKhuyenMai}
										- Giảm ${itemKhuyenMai.phanTramGiam}</option>
								</c:forEach>
							</select>
							<button class="btn text-sm bg-first text-white"
								formaction="/user/apdungkhuyenmai" style="width: 200px">Áp
								dụng</button>
						</div>
					</div>

					<div class="px-4 bg-white py-3 shadow-sm rounded-3">
						<h5 class="text-dark mb-2">Thanh toán</h5>

						<div class="d-flex row-gap-3 flex-column">

							<div class="d-flex column-gap-1 align-items-center">
								<input type="radio" name="thanhToan" value="vnpay" /> <img
									src="../img/thanhtoan/vnpay.png" alt=""
									style="height: 50px; width: 50px" /> <span
									class="text-light text-sm">Ví VNPAY</span>
							</div>
						</div>
						<div class="text-danger" style="font-size: 12px">${message}</div>
					</div>
				</div>
				<div class="col-8 col-md-6 col-lg-5 col-xl-4">
					<jsp:include page="./component/infoticket.jsp"></jsp:include>
					<div class="d-flex column-gap-2 justify-content-end mt-3">
						<a class="btn bg-danger text-white text-sm text-decoration-none"
							href="./chonthucan.html">Quay lại</a>
						<button
							class="btn bg-first text-white text-sm text-decoration-none">Thanh
							toán</button>
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
