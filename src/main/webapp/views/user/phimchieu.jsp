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
	<!-- Trailer phim  -->
	<div class="w-100" style="height: 500px">${phim.trailer}</div>
	<!-- main  -->
	<main class="mt-4">
		<div class="container">
			<div class="row g-5">
				<div class="col-12 col-xl-9 d-flex flex-column row-gap-3">
					<!-- Main phim  -->
					<div class="row">
						<div class="col-4">
							<div class="position-relative" style="height: 400px; width: 100%">
								<div style="height: 100%; width: 100%; right: 0; top: -15%"
									class="position-absolute border border-5 border-white">
									<img src="/img/${phim.hinhAnh}" alt="" class="w-100 h-100" />
								</div>
							</div>
						</div>
						<div class="col-8 d-flex flex-column row-gap-1">
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
											test="${thamGia.dienVienDaoDien.vaiTro.tenVaiTro == 'Đạo Diễn'}">${thamGia.dienVienDaoDien.tenDV_DD},</c:if>
									</c:forEach>
								</div>
								<div class="text-dark fw-bold text-sm">
									<span class="text-light fw-light">Thể loại: </span>
									${phim.theLoai.tenTheLoai}
								</div>
								<div class="text-dark fw-bold text-sm">
									<span class="text-light fw-light">Quốc gia: </span>
									${phim.quocGia.tenQuocGia}
								</div>
							</div>
						</div>
					</div>

					<!-- NỘi dung phim  -->
					<div>
						<h4
							class="text-dark border-4 fs-5 border-start border-dark px-2 fw-bold mb-3">
							Nội dung phim</h4>
						<p class="text-light mb-0">${phim.noiDung}</p>
					</div>

					<div>
						<h4
							class="text-dark border-4 fs-5 border-start border-dark px-2 fw-bold mb-3">
							Lịch chiếu hôm nay</h4>
						<div class="d-flex flex-column row-gap-2">

							<c:forEach items="${mapRapPhim}" var="rapPhim">
								<div class="border rounded-3 p-3">
									<h4 class="text-dark fs-6 fw-bold">${rapPhim.key.tenRapPhim}</h4>
									<div class="d-flex gap-3 flex-wrap">
										<c:forEach items="${rapPhim.value}" var="suatChieu">
											<a
												href="/chonphimchieu?maPhim=${suatChieu.phim.maPhim}&maSuatChieu=${suatChieu.maSuatChieu}&maThanhPho=${rapPhim.key.thanhPho.maThanhPho}"
												class="border border-1 text-decoration-none px-3 py-1 rounded-2 text-dark">
												${suatChieu.thoiGianChieu} - ${suatChieu.thoiGianKetThuc}</a>
										</c:forEach>
									</div>
								</div>

							</c:forEach>

						</div>
					</div>
				</div>
				<div class="col-12 col-xl-3">
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
	</main>

	<jsp:include page="./component/footer.jsp"></jsp:include>
	<script src="./bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="./bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>
