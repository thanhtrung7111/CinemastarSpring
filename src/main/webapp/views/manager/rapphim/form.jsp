<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý rạp phim /
						${update ? 'Cập nhật' : 'Thêm mới'}</h5>
					<form:form modelAttribute="entity" method="post"
						action="${update ? '/admin/updaterapphim' : '/admin/createrapphim'}"
						cssClass="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
						<!-- <div class="d-flex justify-content-between"> -->
						<h5 class="mb-4">${update ? 'Cập nhật ' : 'Thêm mới '}rạp
							phim</h5>
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
								<form:input type="text" path="maRapPhim"
									cssClass="form-control form-control-sm d-none" />
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
										rạp phim</label>
									<form:input type="text" path="tenRapPhim"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập tên rạp phim!" />
									<form:errors path="tenRapPhim" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>

							</div>

							<div class="col-6">
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Số
										điện thoại</label>
									<form:input type="text" path="soDienThoai"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập số điện thoại!" />
									<form:errors path="soDienThoai" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>

							</div>
							<div class="col-6">
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Địa
										chỉ</label>
									<form:input type="text" path="diaChi"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập địa chỉ rạp phim!" />
									<form:errors path="diaChi" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>

							</div>
							<div class="col-6">
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Thành
										phô</label>
									<form:select path="thanhPho.maThanhPho"
										cssClass="form-select form-select-sm"
										cssErrorClass="form-control form-control-sm border-danger">
										<c:forEach items="${thanhPhos}" var="i">
											<form:option value="${i.maThanhPho}" label="${i.tenThanhPho}"></form:option>
										</c:forEach>
									</form:select>
								</div>

							</div>
						</div>
						<div class="text-danger" style="font-size: 12px">${message}</div>
						<div class="d-block text-end">
							<a href="/admin/rapphims" class="btn btn-sm bg-danger text-white">Hủy</a>
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

