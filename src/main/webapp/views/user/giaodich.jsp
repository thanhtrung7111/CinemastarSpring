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
		<div class="container mt-4" style="min-height: 500px">
			<div class="row g-4">
				<jsp:include page="./component/sidebarpersonal.jsp"></jsp:include>

				<div class="col-12 col-lg-7 col-xl-8">
					<div class="bg-white rounded-3 py-3 px-3 shadow-sm">
						<h5 class="fw-bolder text-light">Lịch sử giao dịch</h5>
						<div>
							<div class=" overflow-y-scroll" style="height: 400px">
								<table class="table">
									<thead class="sticky-top">
										<tr>
											<th scope="col">#</th>
											<th scope="col">Mã hoá đơn</th>
											<th scope="col">Ngày giao dịch</th>
											<th scope="col">Tên phim</th>
											<th scope="col">Trạng thái</th>
											<th scope="col">Chi tiết</th>
										</tr>
									</thead>
									<tbody class="text-sm">
										<c:forEach items="${hoaDons}" var="hoaDon" varStatus="loop">
											<tr>
												<th scope="row">${loop.index +1}</th>
												<td>${hoaDon.maHD}</td>
												<td>${hoaDon.ngayLapHD}</td>
												<td>${hoaDon.ves.get(0).suatChieu.phim.tenPhim}</td>
												<td>
													<div
														class="text-white ${hoaDon.trangThai ? 'bg-success' : 'bg-danger'} px-2 py-1"
														style="width: fit-content">${hoaDon.trangThai ? 'Đã thanh toán' : 'Chưa thanh toán'}</div>
												</td>
												<td><a href="/user/chitietgiaodich?id=${hoaDon.maHD}"
													class="border rounded-1 text-decoration-none text-dark text-center py-1 px-2">
														<i class="ri-error-warning-line"></i> Chi tiết
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
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
