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
					<div class="accordion d-flex flex-column row-gap-3"
						id="accordionExample">
						<div class="accordion-item rounded-3">
							<h2 class="accordion-header">
								<div
									class="fw-bold fs-5 p-2 px-3 text-dark w-100 border-bottom d-flex justify-content-between align-items-center"
									type="button" data-bs-toggle="collapse"
									data-bs-target="#collapseOne" aria-expanded="true"
									aria-controls="collapseOne">
									<span>Chọn vị trí</span> <i class="ri-arrow-down-s-fill"></i>
								</div>
							</h2>
							<div id="collapseOne" class="accordion-collapse collapse show"
								data-bs-parent="#accordionExample">
								<div class="accordion-body d-flex gap-3 flex-wrap">
									<c:forEach items="${thanhPhos}" var="thanhPhoItem">
										<button
											formaction="/user/chonthanhpho?id=${thanhPhoItem.maThanhPho}"
											class="border-0 bg-transparent">
											<div
												class="border px-2 py-1 rounded-3 ${thanhPho.get().maThanhPho == thanhPhoItem.maThanhPho ? 'bg-second text-white' :'bg-white'}"
												style="cursor: pointer">${thanhPhoItem.tenThanhPho}</div>
										</button>
									</c:forEach>

								</div>
							</div>
						</div>

						<div class="accordion-item rounded-3 border-top">
							<h2 class="accordion-header">
								<div
									class="fw-bold fs-5 p-2 px-3 text-dark w-100 border-bottom d-flex justify-content-between align-items-center"
									type="button" data-bs-toggle="collapse"
									data-bs-target="#collapseTwo" aria-expanded="true"
									aria-controls="collapseOne">
									<span>Chọn phim</span> <i class="ri-arrow-down-s-fill"></i>
								</div>
							</h2>
							<div id="collapseTwo" class="accordion-collapse collapse show"
								data-bs-parent="#accordionExample">
								<div class="accordion-body d-flex flex-column row-gap-3">
									<div>
										<!-- Content khuyến mãi  -->
										<div>
											<div class="row g-2">
												<!-- PHIM ITEM  -->
												<c:forEach items="${phims}" var="phimItem">
													<div class="col-6 col-md-4 col-xl-3">
														<div
															class="${phimItem.maPhim == sessionScope.phim.get().maPhim ? 'border rounded-2 p-2':'border-0 p-0 rounded-0'}">

															<button
																formaction="/user/chonphim?maPhim=${phimItem.maPhim}"
																class="bg-white w-100 border-0 p-0">
																<div class="bg-white bg-white p-0" style="border: none;"
																	style="cursor: pointer">
																	<div
																		class="rounded-3 overflow-hidden mb-2 position-relative">
																		<img src="/img/${phimItem.hinhAnh}" alt=""
																			style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

																		<div
																			class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
																			style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
																			10 <i class="ri-star-fill"></i>
																		</div>

																	</div>
																	<h4 class="fw-bold fs-6">${phimItem.tenPhim}</h4>
																</div>
															</button>
														</div>
													</div>
												</c:forEach>
												<!-- PHIM ITEM  -->
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="accordion-item rounded-3">
							<h2 class="accordion-header">
								<div
									class="fw-bold fs-5 p-2 px-3 text-dark w-100 border-bottom d-flex justify-content-between align-items-center"
									type="button" data-bs-toggle="collapse"
									data-bs-target="#collapseThree" aria-expanded="true"
									aria-controls="collapseThree">
									<span>Chọn suất</span> <i class="ri-arrow-down-s-fill"></i>
								</div>
							</h2>
							<div id="collapseThree" class="accordion-collapse collapse show"
								data-bs-parent="#accordionExample">
								<div class="accordion-body d-flex flex-column row-gap-3">
									<c:forEach items="${rapPhims}" var="rapPhimItem">
										<div class="border rounded-3 p-3">
											<h4 class="text-dark fs-6 fw-bold">${rapPhimItem.key.tenRapPhim}</h4>
											<div class="d-flex gap-3 flex-wrap">
												<c:forEach items="${rapPhimItem.value}" var="itemSuatChieu">
													<input type="radio" name="id"
														id="${itemSuatChieu.maSuatChieu}"
														value="${itemSuatChieu.maSuatChieu}" hidden />
													<label for="${itemSuatChieu.maSuatChieu}"
														class="border border-1 px-3 py-1 rounded-2 text-dark radioCheck">
														${itemSuatChieu.thoiGianChieu} -
														${itemSuatChieu.thoiGianKetThuc }</label>
												</c:forEach>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
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
