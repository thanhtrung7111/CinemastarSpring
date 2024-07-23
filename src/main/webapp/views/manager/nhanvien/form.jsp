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
					<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý nhân viên
						/ ${update ? 'Cập nhật ' : 'Thêm mới '}</h5>
					<form:form modelAttribute="entity" method="post"
						enctype="multipart/form-data"
						action="${update ? '/admin/updatenhanvien' : '/admin/createnhanvien'}"
						cssClass="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
						<!-- <div class="d-flex justify-content-between"> -->
						<h5 class="mb-4">${update ? 'Cập nhật ' : 'Thêm mới '}nhân
							viên</h5>
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
									style="height: 700px; width: 100%; object-fit: cover; object-position: top" />
									<form:input type="text" path="hinhAnh"
										cssClass="form-control form-control-sm d-none" />
								</label>
							</div>
							<div class="col-8">
								<form:input type="text" path="maNhanVien"
									cssClass="form-control form-control-sm d-none" />
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
										nhân viên</label>
									<form:input type="text" path="tenNhanVien"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập tên nhân viên!" />
									<form:errors path="tenNhanVien" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Email</label>
									<form:input type="text" path="email"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập email!" />
									<form:errors path="email" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>
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
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Mật
										khẩu</label>
									<form:input type="text" path="matKhau"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập mật khẩu!" />
									<form:errors path="matKhau" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Ngày
										sinh</label>
									<form:input type="date" path="ngaySinh"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập ngày sinh!" />
									<form:errors path="ngaySinh" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>
								<div class="d-flex">
									<div class="col-6">
										<div>
											<label class="form-label text-sm text-dark fw-bolder mb-1">Loại
												nhân viên</label>
											<form:select path="loaiNhanVien.maLoaiNhanVien"
												cssClass="form-select form-select-sm"
												cssErrorClass="form-control form-control-sm border-danger">
												<c:forEach items="${loaiNhanVien}" var="i">
													<form:option value="${i.maLoaiNhanVien}"
														label="${i.tenLoaiNhanVien}"></form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col-6">
										<div>
											<label class="form-label text-sm text-dark fw-bolder mb-1">Nhân
												viên tại rạp</label>
											<form:select path="rapPhim.maRapPhim"
												cssClass="form-select form-select-sm"
												cssErrorClass="form-control form-control-sm border-danger">
												<c:forEach items="${rapPhim}" var="i">
													<form:option value="${i.maRapPhim}" label="${i.tenRapPhim}"></form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
								</div>
							</div>

							<div class="text-danger" style="font-size: 12px">${message}</div>
							<div class="d-block text-end">
								<a href="/admin/nhanviens"
									class="btn btn-sm bg-danger text-white">Hủy</a>
								<button class="btn btn-sm bg-first text-white">${update ? 'Cập nhật' : 'Thêm mới'}</button>
							</div>
						</div>
				</div>

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

