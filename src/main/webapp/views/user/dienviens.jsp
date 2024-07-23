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
	href="./bootstrap-5.3.3-dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/remixicon/4.2.0/remixicon.min.css" />
<link rel="stylesheet" href="./bootstrap-5.3.3-dist/css/style.css" />
<title>Danh sách phim</title>
</head>
<body>
	<jsp:include page="./component/modallogin.jsp"></jsp:include>
	<jsp:include page="./component/modalregister.jsp"></jsp:include>
	<jsp:include page="./component/header.jsp"></jsp:include>
	<!-- main  -->
	<main class="mt-4">
		<!-- PHIM CHIẾU TRONG TUẦN  -->
		<div class="container">
			<!-- Phim chiếu trong tuần  -->
			<h4
				class="text-dark border-4 border-start border-dark px-2 fw-bold mb-4">
				${type}</h4>
			<div class="row g-4">
				<div class="col-12 col-lg-8 col-xl-9">
					<div class="d-flex align-items-center column-gap-2 mb-3"
						style="width: 400px">
						<select class="form-select form-select-lg text-sm text-dark"
							aria-label="Large select example">
							<option selected>Quốc gia</option>
							<option value="1">One</option>
							<option value="2">Two</option>
							<option value="3">Three</option>
						</select> <select class="form-select form-select-lg text-sm text-dark"
							aria-label="Large select example">
							<option selected>Xem nhiều nhất</option>
							<option value="1">One</option>
							<option value="2">Two</option>
							<option value="3">Three</option>
						</select>
					</div>

					<div class="d-flex row-gap-3 flex-column">
						<!-- ITEM THE LOAI PHIM  -->
						<c:forEach items="${list.getContent()}" var="item">
							<a href="/dienvien?id=${item.maDV_DD}"
								class="row gx-3 text-decoration-none">
								<div class="col-xl-3 col-5">
									<img src="/img/${item.hinhAnh}" alt=""
										style="width: 100%; height: 300px; object-fit: cover; object-position: center;"
										class="rounded-3" />
								</div>
								<div class="col-7 col-xl-9">
									<h4 class="fw-bold text-dark">${item.tenDV_DD}</h4>
									<div class="d-flex column-gap-3 mb-2">
										<div class="d-flex align-items-center column-gap-1 text-first">
											<i class="ri-thumb-up-fill"></i> 25
										</div>
										<div class="d-flex align-items-center column-gap-1 text-first">
											<i class="ri-eye-fill"></i>${item.luotXem}
										</div>
									</div>
									<p class="text-sm text-light">${item.mota}</p>
								</div>
							</a>
						</c:forEach>
					</div>
					<c:if test="${list.totalPages > 1}">
						<form action="" method="post" class="mt-4">
							<nav aria-label="Page navigation example">
								<ul class="pagination pagination-sm justify-content-center">
									<li class="page-item"><button class="page-link text-dark"
											${list.number  == 0 ? 'disabled' : ''}
											formaction="/dienviens?p=${list.number - 1}"
											aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
										</button></li>

									<c:forEach var="st" begin="1" end="${list.totalPages}">
										<li class="page-item"><button
												class="page-link ${list.number == (st-1) ? 'bg-primary text-white' : 'text-dark bg-white'}"
												formaction="/dienviens?p=${st-1}">${st}</button></li>
									</c:forEach>

									<li class="page-item"><button class="page-link text-dark"
											${list.number +1 == list.totalPages ? 'disabled' : ''}
											formaction="/dienviens?p=${list.number + 1}"
											aria-label="Previous">
											<span aria-hidden="true">&raquo;</span>
										</button></li>
								</ul>
							</nav>
						</form>
					</c:if>
				</div>
				<div class="col-12 col-lg-4 col-xl-3">
					<div class="rounded-4 bg-white shadow-sm overflow-hidden mb-4">
						<div class="p-3 d-flex flex-column row-gap-3">
							<select
								class="form-select form-select-lg text-dark text-sm focus-ring focus-ring-info"
								aria-label="Default select example">
								<option selected>Chọn suất</option>
								<option value="1">One</option>
								<option value="2">Two</option>
								<option value="3">Three</option>
							</select> <select
								class="form-select form-select-lg text-dark text-sm focus-ring focus-ring-info"
								aria-label="Default select example">
								<option selected>Chọn phim</option>
								<option value="1">One</option>
								<option value="2">Two</option>
								<option value="3">Three</option>
							</select>
							<div>
								<h5 class="fs-6 text-dark">Chọn suất:</h5>
								<div class="d-flex flex-wrap gap-2">
									<div
										class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
										7:30</div>
									<div
										class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
										7:30</div>
									<div
										class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
										7:30</div>
									<div
										class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
										7:30</div>
									<div
										class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
										7:30</div>
									<div
										class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
										7:30</div>
									<div
										class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
										7:30</div>
								</div>
							</div>
						</div>
						<button class="border-0 w-100 py-2 bg-first text-white">
							Mua vé</button>
					</div>
					<div>
						<h4
							class="text-first border-4 border-start border-first px-2 fs-5 fw-bold mb-4">
							Đang chiếu</h4>
						<c:forEach items="${phimCurrentShows}" var="phim">
							<div class="product-item mb-3" style="cursor: pointer">
								<div class="rounded-3 overflow-hidden mb-2 position-relative">
									<img src="/img/${phim.hinhAnh}" alt=""
										style="height: 400px; width: 100%; object-fit: cover; object-position: center;" />

									<div
										class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
										style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
										10 <i class="ri-star-fill"></i>
									</div>
									<div
										class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
										style="width: 100%; height: 100%">
										<a href="/user/muave?id=${phim.maPhim}"
											class="btn btn-warning text-sm"> <i
											class="ri-coupon-3-line"></i> Mua vé
										</a> <a href="/phimchieu?id=${phim.maPhim}"
											class="btn btn-outline-info text-sm"> <i
											class="ri-folder-video-line"></i> Trailer
										</a>
									</div>
								</div>
								<h4 class="fw-bold fs-6">${phim.tenPhim}</h4>
							</div>
						</c:forEach>
						<!-- PHIM ITEM  -->
					</div>
				</div>
			</div>
		</div>
		<div class="w-100 bg-dark-subtle my-5" style="height: 10px"></div>

		<!-- Tin khuyến mãi  -->
		<div class="container">

			<h4
				class="text-dark border-4 border-start border-dark px-2 fw-bold mb-4">
				Tin khuyến mãi</h4>

			<!-- Content khuyến mãi  -->
			<div>

				<div class="row">
					<c:forEach items="${khuyenMais}" var="khuyenMai">
						<div class="col-6 col-lg-3">
							<img src="/img/${khuyenMai.hinhAnh}" alt=""
								class="rounded-3 mb-2"
								style="height: 300px; width: 100%; object-fit: cover; object-position: right;" />
							<h4 class="text-dark fw-bold fs-6">${khuyenMai.tenKhuyenMai}
								- Giảm ${khuyenMai.phanTramGiam}%</h4>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
	</main>

	<jsp:include page="./component/footer.jsp"></jsp:include>
	<script src="./bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="./bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>
