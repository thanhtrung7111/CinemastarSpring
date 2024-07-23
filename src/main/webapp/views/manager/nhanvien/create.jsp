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
					<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý loại ghế / Thêm mới</h5>
					<form:form modelAttribute="loaiGhe" action="/admin/createloaighe" method="post">
						<div class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
							<h5 class="mb-4">Thêm loại ghế mới</h5>
							<div class="row g-3 mb-3">
								<div class="col-6">
									<div> 	
										<label class="form-label text-sm text-dark fw-bolder mb-1">Tên loại ghế</label> 
										<form:input path="tenLoaiGhe" type="text" class="form-control form-control-sm" placeholder="Nhập tên loại ghế" />
									</div>
								</div>
								<div class="col-6">
									<div>
										<label class="form-label text-sm text-dark fw-bolder mb-1">Chi phí</label> 
										<form:input path="chiPhi" type="text" class="form-control form-control-sm" placeholder="Nhập chi phí" />
									</div>
								</div>
							</div>
							<div class="d-block text-end">
								<a href="./quanlyrapphim.html" class="btn btn-sm bg-danger text-white">Hủy</a>
								<button type="submit" class="btn btn-sm bg-first text-white">Thêm mới</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div></div>
	</div>

	<script src="../bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="../bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>
