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
					<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý phim /
						${update ? 'Cập nhật' : 'Thêm mới'}</h5>
					<form:form modelAttribute="entity" method="post"
						enctype="multipart/form-data"
						action="${update ? '/admin/updatephim' : '/admin/createphim'}"
						cssClass="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
						<!-- <div class="d-flex justify-content-between"> -->
						<h5 class="mb-4">${update ? 'Cập nhật ' : 'Thêm mới '}phim</h5>
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
							<div class="col-5">
								<input type="file" name="image" id="image"
									accept="image/png, image/jpeg" pattern="(.|\n)*\S(.|\n)*"
									onchange="document.getElementById('output').src = window.URL.createObjectURL(this.files[0])"
									hidden> <label style="width: 100%" for="image">
									<img id="output" src="/img/${entity.hinhAnh}" alt=""
									style="width: 100%; min-height: 500px; object-fit: contain; object-position: top" />
									<form:input type="text" path="hinhAnh"
										cssClass="form-control form-control-sm d-none" />
								</label>
							</div>
							<div class="col-7">
								<form:input type="text" path="maPhim"
									cssClass="form-control form-control-sm d-none" />
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
										phim</label>
									<form:input type="text" path="tenPhim"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập tên phim!" />
									<form:errors path="tenPhim" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Thời
										lượng</label>
									<form:input type="number" path="thoiLuong" min="0" max="200"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger" />
									<form:errors path="thoiLuong" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Banner</label>
									<form:input type="text" path="banner"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Sao chép banner!" />
									<form:errors path="banner" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Thể
										loại phim</label>
									<form:select path="theLoai.maTheLoai"
										cssClass="form-select form-select-sm"
										cssErrorClass="form-control form-control-sm border-danger">
										<c:forEach items="${theLoais}" var="i">
											<form:option value="${i.maTheLoai}" label="${i.tenTheLoai}"></form:option>
										</c:forEach>
									</form:select>
								</div>
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Mô
										tả</label>
									<form:textarea type="text" path="moTa"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập mô tả!" />
									<form:errors path="moTa" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Nội
										dung</label>
									<form:textarea type="text" path="noiDung" rows="5"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập mô tả!" />
									<form:errors path="noiDung" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Năm
										sản xuất</label>
									<form:input type="number" path="namSanXuat" min="1990"
										max="2030" cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger" />
									<form:errors path="namSanXuat" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Trailer</label>
									<form:textarea type="text" path="trailer"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập trailer!" />
									<form:errors path="trailer" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>


								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Quốc
										gia</label>
									<form:select path="quocGia.maQuocGia"
										cssClass="form-select form-select-sm"
										cssErrorClass="form-control form-control-sm border-danger">
										<c:forEach items="${quocGias}" var="i">
											<form:option value="${i.maQuocGia}" label="${i.tenQuocGia}"></form:option>
										</c:forEach>
									</form:select>
								</div>
								<div class="row">
									<div class="col-6">
										<label class="form-label text-sm text-dark fw-bolder mb-1">Diễn
											viên : <c:forEach items="${entity.thamGias}" var="i">
												<c:if
													test="${i.dienVienDaoDien.vaiTro.tenVaiTro == 'Diễn Viên'}">${i.dienVienDaoDien.tenDV_DD},</c:if>
											</c:forEach>
										</label> <select name="dienViens" multiple="multiple"
											class="form-select form-select-sm">
											<c:forEach items="${dienViens}" var="i">
												<option value="${i.maDV_DD}">${i.tenDV_DD}</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-6">
										<label class="form-label text-sm text-dark fw-bolder mb-1">Đạo
											diễn : <c:forEach items="${entity.thamGias}" var="i">
												<c:if
													test="${i.dienVienDaoDien.vaiTro.tenVaiTro == 'Đạo Diễn'}">${i.dienVienDaoDien.tenDV_DD},</c:if>
											</c:forEach>
										</label> <select name="dienViens" multiple="multiple"
											class="form-select form-select-sm">
											<c:forEach items="${daoDiens}" var="i">
												<option value="${i.maDV_DD}">${i.tenDV_DD}</option>
											</c:forEach>
										</select>
									</div>

								</div>



							</div>
						</div>
						<div class="text-danger" style="font-size: 12px">${message}</div>
						<div class="d-block text-end">
							<a href="/admin/phims" class="btn btn-sm bg-danger text-white">Hủy</a>
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

