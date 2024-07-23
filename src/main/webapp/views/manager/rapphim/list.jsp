<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../component/header.jsp"></jsp:include>
<body style="height: 100vh" class="d-flex flex-column position-relative">
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
					<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý rạp phim</h5>
					<div class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
						<div class="d-flex justify-content-between">
							<h5 class="mb-3">Danh sách rạp phim</h5>
							<div>
								<a href="./themmoicombo.html"
									class="btn btn-primary btn-sm text-white"> <i
									class="ri-file-copy-line"></i> Sao chép
								</a> <a href="./themmoicombo.html"
									class="btn btn-success btn-sm text-white"> <i
									class="ri-file-excel-line"></i> Xuất excel
								</a> <a href="/admin/createrapphim"
									class="btn bg-first btn-sm text-white"> <i
									class="ri-file-add-line"></i> Thêm mới
								</a>
							</div>
						</div>
						<table class="table">
							<thead>
								<tr>
									<th><input type="checkbox" /></th>
									<th scope="col">#</th>
									<th scope="col">Mã rạp phim</th>
									<th scope="col">Tên rạp phim</th>
									<th scope="col">Địa chỉ</th>
									<th scope="col">Số điện thoại</th>
									<th scope="col">Thành phố</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="item" varStatus="loop">
									<tr class="text-sm">
										<td><input type="checkbox" /></td>
										<td>${loop.index +1}</td>
										<td>${item.maRapPhim}</td>
										<td>${item.tenRapPhim}</td>
										<td>${item.diaChi}</td>
										<td>${item.soDienThoai}</td>
										<td>${item.thanhPho.tenThanhPho}</td>
										<td class="d-flex column-gap-2"><a
											href="/admin/deleterapphim?id=${item.maRapPhim}"
											class="ri-delete-bin-6-line text-decoration-none text-black-50"
											style="cursor: pointer" title="Xóa"></a><a
												href="/admin/updaterapphim?id=${item.maRapPhim}"
											class="ri-error-warning-line text-decoration-none text-black-50"
											style="cursor: pointer" title="Xem chi tiết"></a></td>
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

