<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý khuyến mãi</h5>
					<div class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
						<div class="d-flex justify-content-between">
							<h5 class="mb-3">Danh sách khuyến mãi</h5>
							<div>
								<a href="./themmoicombo.html"
									class="btn btn-primary btn-sm text-white"> <i
									class="ri-file-copy-line"></i> Sao chép
								</a> <a href="./themmoicombo.html"
									class="btn btn-success btn-sm text-white"> <i
									class="ri-file-excel-line"></i> Xuất excel
								</a> <a class="btn bg-first btn-sm text-white"
									href="/admin/createkhuyenmai"> <i class="ri-file-add-line"></i>
									Thêm mới
								</a>
							</div>
						</div>
						<table class="table">
							<thead>
								<tr>
									<th><input type="checkbox" /></th>
									<th scope="col">#</th>
									<th scope="col">Mã khuyến mãi</th>
									<th scope="col">Tên khuyến mãi</th>
									<th scope="col">Phăn trăm giảm</th>
									<th scope="col">Ngày áp dụng</th>
									<th scope="col">Ngày kết thúc</th>
									<th scope="col">Hình ảnh</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="item" varStatus="loop">
									<tr class="text-sm">
										<td><input type="checkbox" /></td>
										<td>${loop.index+1}</td>
										<td>${item.maKhuyenMai}</td>
										<td>${item.tenKhuyenMai}</td>
										<td>${item.phanTramGiam}</td>
										<td>${item.ngayApDung}</td>
										<td>${item.ngayKetThuc}</td>
										<td><img src="/img/${item.hinhAnh}"
											style="height: 100px; width: 100px; object-fit: cover; object-position: center" /></td>
										<td>
											<div class="d-flex column-gap-2">
												<a
													class="ri-delete-bin-6-line text-decoration-none text-black-50"
													style="cursor: pointer" title="Xóa"
													href="/admin/deletekhuyenmai?id=${item.maKhuyenMai}"></a><a
													href="/admin/updatekhuyenmai?id=${item.maKhuyenMai}"
													class="ri-error-warning-line text-decoration-none text-black-50"
													style="cursor: pointer" title="Xem chi tiết"></a>
											</div>
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
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

