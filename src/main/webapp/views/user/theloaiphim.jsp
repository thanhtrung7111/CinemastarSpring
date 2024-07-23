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
			<h4 class="text-dark border-dark px-2 fw-medium fs-5 mb-4">
				Trang chủ / Phim / ${phim.tenPhim}</h4>
			<div class="row gx-5">
				<div class="col-12 col-lg-8 col-xl-9">
					<!-- Main phim  -->
					<div class="d-flex flex-column row-gap-3">
						<div class="row g-3">
							<div class="col-12 col-md-4">
								<img src="/img/${phim.hinhAnh}" alt=""
									style="height: 400px; width: 100%; object-fit: cover; object-position: center;" />
							</div>
							<div class="col-12 col-md-8 d-flex flex-column row-gap-1">
								<h4 class="fw-bold fs-3 mb-0">${phim.tenPhim}</h4>
								<div class="d-flex align-items-center column-gap-3">
									<div class="d-flex align-items-center column-gap-1">
										<i class="ri-time-line text-second"></i> <span
											class="text-dark text-sm fw-bold">${phim.thoiLuong}
											phút</span>
									</div>
									<div class="d-flex align-items-center column-gap-1">
										<i class="ri-calendar-2-line text-second"></i> <span
											class="text-dark fw-bold text-sm">${phim.namSanXuat}</span>
									</div>
								</div>
								<div class="d-flex column-gap-3 mb-1 text-sm">
									<div class="d-flex align-items-center column-gap-1 text-first">
										<i class="ri-thumb-up-fill"></i> 25
									</div>
									<div class="d-flex align-items-center column-gap-1 text-first">
										<i class="ri-eye-fill"></i> ${phim.luotXem}
									</div>
								</div>
								<p class="text-light mb-1">${phim.moTa}</p>
								<div class="d-flex flex-column row-gap-2">
									<div class="text-dark fw-bold text-sm">
										<span class="text-light fw-light">Diễn viên: </span>
										<c:forEach items="${phim.thamGias}" var="thamGia">
											<c:if
												test="${thamGia.dienVienDaoDien.vaiTro.tenVaiTro == 'Diễn Viên'}">${thamGia.dienVienDaoDien.tenDV_DD},</c:if>
										</c:forEach>
									</div>
									<div class="text-dark fw-bold text-sm">
										<span class="text-light fw-light">Đạo diễn: </span>
										<c:forEach items="${phim.thamGias}" var="thamGia">
											<c:if
												test="${thamGia.dienVienDaoDien.vaiTro.tenVaiTro == 'Đạo Diễn'}">${thamGia.dienVienDaoDien.tenDV_DD}</c:if>
										</c:forEach>
									</div>
									<div class="text-dark fw-bold text-sm">
										<span class="text-light fw-light">Thể loại: </span>
										${phim.theLoai.tenTheLoai}
									</div>

									<div class="text-dark fw-bold text-sm">
										<span class="text-light fw-light">Quốc gia: </span>${phim.quocGia.tenQuocGia}
									</div>
								</div>
							</div>
						</div>

						<!-- NỘi dung phim  -->
						<div>
							<h4
								class="text-dark border-4 fs-5 border-start border-dark px-2 fw-bold mb-3">
								Nội dung phim</h4>
							<p class="text-light mb-0">${phim.moTa}</p>
							<p class="text-light mb-0">${phim.noiDung}</p>
						</div>

						<!-- Diễn viên  -->
						<div>
							<h4
								class="text-dark border-4 fs-5 border-start border-dark px-2 fw-bold mb-3">
								Diễn viên, Đạo Diễn</h4>
							<div class="row g-3">
								<c:forEach items="${phim.thamGias}" var="thamGia">
									<div class="col-6">
										<a href="/dienvien?id=${thamGia.dienVienDaoDien.maDV_DD}"
											class=" d-flex align-items-start column-gap-2 text-decoration-none">
											<img src="/img/${thamGia.dienVienDaoDien.hinhAnh}" alt=""
											style="width: 90px; height: 100px; object-fit: cover; object-position: center;" />
											<div class="d-flex flex-column row-gap-2">
												<span class="fs-6 fw-bold text-dark">${thamGia.dienVienDaoDien.tenDV_DD}</span>
												<span style="font-size: 13px" class="fw-normal text-dark">${thamGia.dienVienDaoDien.vaiTro.tenVaiTro}</span>
											</div>
										</a>
									</div>
								</c:forEach>


							</div>
						</div>
						<!-- Diễn viên  -->
						<div class="mt-4">
							<h4
								class="text-dark border-4 fs-5 border-start border-dark px-2 fw-bold mb-3">
								Đánh giá</h4>
							<div class="d-flex flex-column row-gap-2">
								<div class="d-flex column-gap-3">
									<img src="./img/dienvien1.jpg" class="rounded-circle" alt=""
										style="height: 70px; width: 70px; object-fit: cover; object-position: center;" />
									<div>
										<h5 class="text-dark fs-6 fw-bold mb-1">John Trần</h5>
										<p class="text-light text-xs mb-2 fst-italic">15/03/2024
											8:00AM</p>
										<p class="text-dark fs-6">"Phim hay với tình tiết gay
											cuốn"</p>
									</div>
								</div>
								<div class="d-flex column-gap-3">
									<img src="./img/dienvien2.jpg" class="rounded-circle" alt=""
										style="height: 70px; width: 70px; object-fit: cover; object-position: center;" />
									<div>
										<h5 class="text-dark fs-6 fw-bold mb-1">Hendry Nguyễn</h5>
										<p class="text-light text-xs mb-2 fst-italic">15/03/2024
											8:00AM</p>
										<p class="text-dark fs-6">"Phim hay với tình tiết gay
											cuốn"</p>
									</div>
								</div>
							</div>
						</div>

						<!-- Bài viết liên quan  -->
					</div>
					<div class="mt-4">

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
	</main>

	<jsp:include page="./component/footer.jsp"></jsp:include>
	<script src="./bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="./bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>
