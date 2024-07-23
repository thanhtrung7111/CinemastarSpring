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
					<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý phòng
						phim/ ${update ? 'Cập nhật' : 'Thêm mới'}</h5>
					<form:form modelAttribute="entity" method="post"
						action="${update ? '/admin/updatephongphim' : '/admin/createphongphim'}"
						cssClass="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
						<!-- <div class="d-flex justify-content-between"> -->
						<h5 class="mb-4">${update ? 'Cập nhật ' : 'Thêm mới '}phòng
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
								<form:input type="text" path="maPhongPhim"
									cssClass="form-control form-control-sm d-none" />
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
										phòng phim</label>
									<form:input type="text" path="tenPhongPhim"
										cssClass="form-control form-control-sm"
										cssErrorClass="form-control form-control-sm border-danger"
										placeholder="Nhập tên phòng phim!" />
									<form:errors path="tenPhongPhim" cssClass="text-danger"
										style="font-size:12px"></form:errors>
								</div>

							</div>


							<div class="col-6">
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Trạng
										thái</label>
									<form:select path="trangThai"
										cssClass="form-select form-select-sm"
										cssErrorClass="form-control form-control-sm border-danger">
										<form:option value="true" label="Đang hoạt động"></form:option>
										<form:option value="false" label="Ngừng hoạt động"></form:option>

									</form:select>
								</div>

							</div>
							<div class="col-6">
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Rạp
										phim</label>
									<form:select path="rapPhim.maRapPhim"
										cssClass="form-select form-select-sm"
										cssErrorClass="form-control form-control-sm border-danger">
										<c:forEach items="${rapPhims}" var="i">
											<form:option value="${i.maRapPhim}" label="${i.tenRapPhim}"></form:option>
										</c:forEach>
									</form:select>
								</div>

							</div>
							<div class="col-6">
								<div>
									<label class="form-label text-sm text-dark fw-bolder mb-1">Rạp
										phim</label> <select name="loaiGhe" class="form-select form-select-sm">
										<c:forEach items="${loaiGhes}" var="i">
											<option ${loaiGhe == i.maLoaiGhe ? 'selected' : ''}
												value="${i.maLoaiGhe}">${i.tenLoaiGhe}</option>
										</c:forEach>
									</select>
								</div>

							</div>
						</div>
						<div class="text-danger" style="font-size: 12px">${message}</div>
						<div class="d-block text-end">
							<a href="/admin/phongphims"
								class="btn btn-sm bg-danger text-white">Hủy</a>
							<button class="btn btn-sm bg-first text-white">${update ? 'Cập nhật' : 'Thêm mới'}</button>
						</div>
					</form:form>

					<c:if test="${update}">
						<div
							class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3 mt-3">
							<div>
								<div class="bg-second" style="height: 5px; width: 100%"></div>
								<div class="d-block text-center mb-5 text-light">Màn hình</div>
								<div class="d-flex flex-column row-gap-2">
									<c:forEach items="${hangGhes}" var="hangGhe">
										<div class="d-flex">
											<span class="text-dark fw-bolder">${hangGhe.tenHangGhe}</span>
											<div
												class="flex-fill d-flex column-gap-2 justify-content-center px-5 grid-col-10">
												<c:forEach items="${entity.ghes}" var="ghe">
													<c:if test="${ghe.hangGhe.maHangGhe == hangGhe.maHangGhe}">
														<div style="width: 30px; height: 30px"
															class="border d-flex align-items-center justify-content-center rounded-2 text-sm">
															${ghe.tenGhe}</div>
													</c:if>
												</c:forEach>
											</div>
											<span class="text-dark fw-bolder">${hangGhe.tenHangGhe}</span>
										</div>
									</c:forEach>

								</div>


							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<div></div>


	<script src="../bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="../bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>

