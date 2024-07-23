<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
					<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý combo /
						${update ? 'Cập nhật' : 'Thêm mới'}</h5>
					<form:form modelAttribute="entity" method="post"
						enctype="multipart/form-data"
						action="${update ? '/admin/updatecombo' : '/admin/createcombo'}"
						cssClass="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
						<!-- <div class="d-flex justify-content-between"> -->
						<h5 class="mb-4">${update ? 'Cập nhật combo' : 'Thêm mới combo'}</h5>
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
							<div class="col-4">
								<input type="file" name="image" id="image"
									accept="image/png, image/jpeg" pattern="(.|\n)*\S(.|\n)*"
									onchange="document.getElementById('output').src = window.URL.createObjectURL(this.files[0])"
									hidden> <label style="width: 100%" for="image">
									<img id="output" src="/img/${entity.hinhAnh}" alt=""
									style="height: 300px; width: 100%; object-fit: cover; object-position: top" />
									<form:input type="text" path="hinhAnh"
										cssClass="form-control form-control-sm d-none" />
								</label>
							</div>
							<div class="col-8">
								<form:input type="text" path="maCombo"
									cssClass="form-control form-control-sm d-none" />
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
										combo</label>
									<form:input type="text" path="tenCombo"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập tên combo!" />
									<form:errors path="tenCombo" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Giá
										combo</label>
									<form:input type="number" path="giaCombo"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger" />
									<form:errors path="giaCombo" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Mô
										tả</label>
									<form:textarea rows="5" type="text" path="moTa"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập mô tả!" />
									<form:errors path="moTa" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>
							</div>
						</div>
						<div class="text-danger" style="font-size: 12px">${message}</div>
						<div class="d-block text-end">
							<a href="/admin/combos" class="btn btn-sm bg-danger text-white">Hủy</a>
							<button class="btn btn-sm bg-first text-white">${update ? 'Cập nhật' : 'Thêm mới'}</button>
						</div>
					</form:form>

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

