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
<title>Trang chủ</title>
</head>
<body class="overflow-x-hidden">


	<jsp:include page="./component/modallogin.jsp"></jsp:include>
	<jsp:include page="./component/modalregister.jsp"></jsp:include>
	<jsp:include page="./component/header.jsp"></jsp:include>
	<!-- banner  -->
	<div class="position-relative">
		<div id="carouselExampleInterval" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<c:forEach items="${banner}" var="item" varStatus="loop">
					<div class="carousel-item ${loop.index == 0 ?'active' : ''}"
						data-bs-interval="2000">
						<a href="/user/muave?id=${item.maPhim}"> <img
							style="height: 600px; object-fit: cover; object-position: bottom"
							src="${item.banner}" class="d-block w-100" alt="..." />
						</a>
					</div>

				</c:forEach>
			</div>
			<button class="carousel-control-prev bg-opacity-50 bg-black p-2"
				type="button" data-bs-target="#carouselExampleInterval"
				data-bs-slide="prev"
				style="height: fit-content; width: fit-content; top: 50%; transform: translateY(-50%); left: 70px;">
				<i class="ri-arrow-left-s-line fs-3"></i>
			</button>
			<button class="carousel-control-next bg-opacity-50 bg-black p-2"
				type="button" data-bs-target="#carouselExampleInterval"
				data-bs-slide="next"
				style="height: fit-content; width: fit-content; top: 50%; transform: translateY(-50%); right: 70px;">
				<i class="ri-arrow-right-s-line fs-3"></i>
			</button>
		</div>

		<div
			class="d-lg-flex d-none column-gap-2 px-5 py-4 position-absolute bg-white shadow-sm rounded-2"
			style="width: 800px; bottom: -5%; right: 50%; transform: translateX(50%);">
			<select
				class="form-select form-select-lg text-sm focus-ring focus-ring-info"
				aria-label="Default select example">
				<option selected>Chọn phim</option>
				<option value="1">One</option>
				<option value="2">Two</option>
				<option value="3">Three</option>
			</select> <select
				class="form-select form-select-lg text-sm focus-ring focus-ring-info"
				aria-label="Default select example">
				<option selected>Chọn ngày</option>
				<option value="1">One</option>
				<option value="2">Two</option>
				<option value="3">Three</option>
			</select> <select
				class="form-select form-select-lg text-sm focus-ring focus-ring-info"
				aria-label="Default select example">
				<option selected>Chọn suất</option>
				<option value="1">One</option>
				<option value="2">Two</option>
				<option value="3">Three</option>
			</select>
			<button class="bg-first w-100 text-white border-0 rounded-1">
				Mua vé</button>
		</div>
	</div>
	<!-- main  -->
	<main class="mt-5">
		<!-- PHIM CHIẾU TRONG TUẦN  -->
		<div class="container">
			<!-- Phim chiếu trong tuần  -->
			<h4
				class="text-dark border-4 border-start border-dark px-2 fw-bold mb-4">
				Phim chiếu hôm nay</h4>

			<div class="row g-4">
				<c:forEach items="${banner}" var="phim">
					<div class="col-6 col-md-4 col-lg-3 product-item"
						style="cursor: pointer">
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
						<h4 class="fw-bold">${phim.tenPhim}</h4>
					</div>
				</c:forEach>
				<!-- PHIM ITEM  -->
			</div>

			<a href="/phims"
				class="border-first border text-first bg-white text-sm px-4 py-2 d-block mx-auto mt-5 text-decoration-none"
				style="width: fit-content"> Xem thêm </a>
		</div>

		<div class="w-100 bg-dark-subtle my-5" style="height: 10px"></div>

		<!-- GÓC ĐIẸN ẢNH  -->
		<div class="container">
			<h4
				class="text-dark border-4 border-start border-dark px-2 fw-bold mb-4">
				Góc điện ảnh</h4>
			<div class="row g-4 justify-content-start">
				<div class="col-12 col-md-7 col-xl-8">
					<div class="mb-2 overflow-hidden rounded-3"
						style="width: 100%; height: 400px">
						<img src="./img/dienanh1.jpeg" alt=""
							style="object-fit: cover; object-position: center; width: 100%; height: 100%;"
							class="scale-img" />
					</div>
					<div class="d-flex column-gap-3 mb-2">
						<div class="d-flex align-items-center column-gap-1 text-first">
							<i class="ri-thumb-up-fill"></i> 25
						</div>
						<div class="d-flex align-items-center column-gap-1 text-first">
							<i class="ri-eye-fill"></i> 200
						</div>
					</div>
					<h4 class="fs-5">[Review] Exhuma Quật Mộ Trùng Ma: Bom Tấn Hàn
						Quốc Đáng Xem Nhất 2024?</h4>
				</div>
				<div class="col-10 col-md-5 col-xl-4 d-flex flex-column row-gap-3">
					<div class="row">
						<div class="col-5 p-0 rounded-3 overflow-hidden">
							<img src="./img/dieananh2.jpg" alt=""
								style="width: 100%; height: 100px; object-fit: cover; object-position: center;"
								class="scale-img" />
						</div>
						<div class="col-7">
							<h4 class="fs-6 text">[Review] Kungfu Panda 4</h4>
							<div class="d-flex column-gap-3 mb-2">
								<div class="d-flex align-items-center column-gap-1 text-first">
									<i class="ri-thumb-up-fill"></i> 25
								</div>
								<div class="d-flex align-items-center column-gap-1 text-first">
									<i class="ri-eye-fill"></i> 200
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-5 rounded-3 overflow-hidden p-0">
							<img src="./img/dienanh3.jpg" alt=""
								style="width: 100%; height: 100px; object-fit: cover; object-position: center;"
								class="scale-img" />
						</div>
						<div class="col-7">
							<h4 class="fs-6 text">[Review] Hành tinh cát có hay như lời
								đồn?</h4>
							<div class="d-flex column-gap-3 mb-2">
								<div class="d-flex align-items-center column-gap-1 text-first">
									<i class="ri-thumb-up-fill"></i> 25
								</div>
								<div class="d-flex align-items-center column-gap-1 text-first">
									<i class="ri-eye-fill"></i> 200
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-5 rounded-3 p-0 overflow-hidden">
							<img src="./img/dienanh4.jpg" alt=""
								style="width: 100%; height: 100px; object-fit: cover; object-position: center;"
								class="scale-img" />
						</div>
						<div class="col-7">
							<h4 class="fs-6 text">[Review] phim hoạt hình hot nhất hiện
								nay?</h4>
							<div class="d-flex column-gap-3 mb-2">
								<div class="d-flex align-items-center column-gap-1 text-first">
									<i class="ri-thumb-up-fill"></i> 25
								</div>
								<div class="d-flex align-items-center column-gap-1 text-first">
									<i class="ri-eye-fill"></i> 200
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-5 rounded-3 overflow-hidden p-0">
							<img src="./img/imgphim4.jpg" alt=""
								style="width: 100%; height: 100px; object-fit: cover; object-position: center;"
								class="scale-img" />
						</div>
						<div class="col-7">
							<h4 class="fs-6 text">[Review] Quý cô thừa kế 2</h4>
							<div class="d-flex column-gap-3 mb-2">
								<div class="d-flex align-items-center column-gap-1 text-first">
									<i class="ri-thumb-up-fill"></i> 25
								</div>
								<div class="d-flex align-items-center column-gap-1 text-first">
									<i class="ri-eye-fill"></i> 200
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<button
				class="border-first border text-first bg-white text-sm px-4 py-2 d-block mx-auto mt-5">
				Xem thêm</button>
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
