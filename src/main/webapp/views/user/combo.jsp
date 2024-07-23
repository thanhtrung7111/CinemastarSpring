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
	<!-- logo  -->

	<!-- main  -->
	<main>
		<div
			class="bg-white py-4 d-flex justify-content-center align-items-center">
			<div class="border-1 border-bottom d-flex" style="width: fit-content">
				<div class="px-3 pb-2 fs-5 text-dark">Chọn rạp/phim/suất</div>
				<div class="px-3 pb-2 fs-5 text-dark">Chọn ghế</div>
				<div
					class="px-3 pb-2 fs-5 text-first border-bottom border-2 border-first">
					Chọn thức ăn</div>
				<div class="px-3 pb-2 fs-5 text-dark">Thanh toán</div>
				<div class="px-3 pb-2 fs-5 text-dark">Xác nhận</div>
			</div>
		</div>

		<form class="container mt-4" method="post">
			<div class="row g-4">
				<div class="col-12 col-xl-8">
					<div class="px-4 bg-white py-3 shadow-sm rounded-3">
						<h5 class="mb-3">Chọn combo</h5>

						<div class="d-flex flex-column row-gap-3">

							<c:forEach items="${combos}" var="comboItem">
								<div class="d-flex column-gap-2">
									<img src="/img/${comboItem.hinhAnh}" alt=""
										style="height: 100px; width: 100px; object-fit: cover; object-position: center;"
										class="rounded-3" />

									<div class="flex-fill d-flex flex-column row-gap-1">
										<h5 class="mb-0 fw-bold">${comboItem.tenCombo}</h5>
										<p class="mb-1 text-sm">${comboItem.moTa}</p>
										<span class="fw-bold">Giá: <fmt:formatNumber
												value="${comboItem.giaCombo}" pattern="#,###" /> VNĐ
										</span>
									</div>
									<div class="d-flex column-gap-1">
										<button formaction="/user/increment?id=${comboItem.maCombo}"
											class="border text-decoration-none bg-white d-flex align-items-center justify-content-center rounded-1 text-sm"
											style="height: 25px; width: 25px">+</button>
										<input formaction="/user/changeamout?id=${comboItem.maCombo}"
											onblur="this.form.submit()" min="0" name="soluong"
											class="border d-flex align-items-center justify-content-center rounded-1 text-sm"
											style="height: 25px; width: 25px"
											value="${mapCombo.get(comboItem) > 0 ? mapCombo.get(comboItem) :'0'}" />
										<button formaction="/user/decrement?id=${comboItem.maCombo}"
											class="border text-decoration-none bg-white d-flex align-items-center justify-content-center rounded-1 text-sm"
											style="height: 25px; width: 25px">-</button>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="col-12 col-xl-4">
					<jsp:include page="./component/infoticket.jsp"></jsp:include>
					<div class="d-flex column-gap-2 justify-content-end mt-3">
						<a class="btn bg-danger text-white text-sm text-decoration-none"
							href="./chonghe.html">Quay lại</a> <a
							class="btn bg-first text-white text-sm text-decoration-none"
							href="/user/thanhtoan">Tiếp tục</a>
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
