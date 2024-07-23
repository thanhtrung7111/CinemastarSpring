<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../component/header.jsp"></jsp:include>
<body style="height: 100vh" class="d-flex flex-column">
	<!-- MODAL  -->
	<div class="modal fade" id="modalRapphim" tabindex="-1"
		aria-labelledby="modalRapphim" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="modalRapphim">Modal title</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
	<div>
		<div class="d-flex">
			<jsp:include page="../component/sidebar.jsp"></jsp:include>
			<div class="flex-fill">
				<jsp:include page="../component/navbar.jsp"></jsp:include>

				<div class="py-2 px-3">
					<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý ghế / ${update ? 'Cập nhật' : 'Thêm mới'}</h5>
					<div class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
						<!-- <div class="d-flex justify-content-between"> -->
						<h5 class="mb-4">${update ? 'Cập nhật' : 'Thêm mới'} ghế</h5>
						<!-- <div>
                  <button
                    class="btn bg-first btn-sm text-white"
                    data-bs-toggle="modal"
                    data-bs-target="#modalRapphim"
                  >
                    <i class="ri-file-add-line"></i> Thêm mới
                  </button>
                </div> -->
						<!-- </div> -->
						<div class="row g-3 mb-3">
							<div class="col-6">
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Mã
										ghế</label> <input type="email" class="form-control form-control-sm"
										id="exampleFormControlInput1" placeholder="Nhập mã ghế" />
								</div>
							</div>

							<div class="col-6">
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
										ghế</label> <input type="email" class="form-control form-control-sm"
										id="exampleFormControlInput1" placeholder="Nhập tên ghế" />
								</div>
							</div>

							<div class="col-6">
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Loại
										ghế</label> <select class="form-select form-select-sm"
										aria-label="Small select example">
										<option selected>Chọn loại ghế</option>
										<option value="1">One</option>
										<option value="2">Two</option>
										<option value="3">Three</option>
									</select>
								</div>
							</div>
							<div class="col-6">
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Phòng
										phim</label> <select class="form-select form-select-sm"
										aria-label="Small select example">
										<option selected>Chọn phòng phim</option>
										<option value="1">One</option>
										<option value="2">Two</option>
										<option value="3">Three</option>
									</select>
								</div>
							</div>
						</div>

						<div class="d-block text-end">
							<a href="./quanlyrapphim.html"
								class="btn btn-sm bg-danger text-white">Hủy</a>
							<button class="btn btn-sm bg-first text-white">Thêm mới</button>
						</div>
					</div>

					<div>
						<div></div>
					</div>
				</div>
			</div>
		</div>
		<div></div>
	</div>

	<script src="../bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="../bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>
