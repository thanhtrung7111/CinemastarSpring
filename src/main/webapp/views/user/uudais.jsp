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
				Ưu đãi</h4>
			<div class="row">
				<div class="col-12 col-lg-8 col-xl-9">
					<div class="row g-3">
						<c:forEach items="${khuyenMais}" var="khuyenMai">

							<div class="col-6 col-xl-4">
								<div class="position-relative product-item">
									<img src="/img/${khuyenMai.hinhAnh}" alt=""
										style="width: 100%; height: 300px; object-fit: cover; object-position: right;" />
									<div
										class="position-absolute product-overlay top-0 start-0 bg-black bg-opacity-25 d-flex align-items-center justify-content-center"
										style="width: 100%; height: 100%">
										<button class="btn btn-warning">Xem chi tiết</button>
									</div>
								</div>
								<h5 class="mt-2">${khuyenMai.tenKhuyenMai}</h5>
							</div>
						</c:forEach>


					</div>
					<!-- <div
              class="mt-5 text-center d-flex align-items-center justify-content-center column-gap-2"
            >
              <button
                class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
                style="height: 30px; width: 30px; outline: none"
              >
                <i class="ri-arrow-left-s-line"></i>
              </button>
              <button
                class="border-1 bg-first border-first bg-transparent text-white d-flex align-items-center justify-content-center text-sm"
                style="height: 30px; width: 30px; outline: none"
              >
                1
              </button>
              <button
                class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
                style="height: 30px; width: 30px; outline: none"
              >
                2
              </button>
              <button
                class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
                style="height: 30px; width: 30px; outline: none"
              >
                3
              </button>

              <span>...</span>
              <button
                class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
                style="height: 30px; width: 30px; outline: none"
              >
                7
              </button>
              <button
                class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
                style="height: 30px; width: 30px; outline: none"
              >
                8
              </button>
              <button
                class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
                style="height: 30px; width: 30px; outline: none"
              >
                9
              </button>
              <button
                class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
                style="height: 30px; width: 30px; outline: none"
              >
                <i class="ri-arrow-right-s-line"></i>
              </button>
            </div> -->
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
										<a href="/muave?id=${phim.maPhim}"
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



	</main>
	<jsp:include page="./component/footer.jsp"></jsp:include>
	<script src="./bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="./bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>
