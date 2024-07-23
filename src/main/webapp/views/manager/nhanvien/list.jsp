<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý nhân viên</h5>
					<div class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
						<div class="d-flex justify-content-between">
							<h5 class="mb-3">Danh sách nhân viên</h5>
							<div>
								<a href="./themmoicombo.html"
									class="btn btn-primary btn-sm text-white"> <i
									class="ri-file-copy-line"></i> Sao chép
								</a> <a href="./themmoicombo.html"
									class="btn btn-success btn-sm text-white"> <i
									class="ri-file-excel-line"></i> Xuất excel
								</a> <a class="btn bg-first btn-sm text-white"
									href="/admin/createnhanvien"> <i class="ri-file-add-line"></i>
									Thêm mới
								</a>
							</div>
						</div>
						<%-- form search --%>
						<div
							class="input-group bg-white input-group-sm rounded-3 overflow-hidden px-2"
							style="width: 800px; height: fit-content">
							<form class="d-flex column-gap-2" action="/admin/nhanviens"
								method="post">
								<input type="text" name="keywords"
									class="form-control form-control-sm border text-sm"
									placeholder="Nhập keyword..." value="${keywords}"
									aria-describedby="basic-addon1" /> <select class="form-select"
									name="type" aria-label="Default select example">
									<option selected value="1">Tìm theo tên</option>
									<option value="2">Tìm theo Id</option>
									<option value="3">Tìm theo email</option>
								</select>
								<button class="input-group-text btn-outline-primary btn btn-sm"
									id="basic-addon1">Tìm kiếm</button>
								<button formmethod="get" formaction="/admin/nhanviens"
									class="input-group-text btn-outline-primary btn btn-sm"
									id="basic-addon1">Toàn bộ nhân viên</button>

							</form>
						</div>
						<%-- form search --%>
						<table class="table">
							<thead>
								<tr>
									<th><input type="checkbox" /></th>
									<th scope="col">#</th>
									<th scope="col">Mã nhân viên</th>
									<th scope="col">Tên nhân viên</th>
									<th scope="col">Email</th>
									<th scope="col">Số điện thoại</th>
									<th scope="col">Mật khẩu</th>
									<th scope="col">Hình ảnh</th>
									<th scope="col">Ngày sinh</th>
									<th scope="col">Loại nhân viên</th>
									<th scope="col">Nhân viên rạp</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${list.content}" var="item" varStatus="loop">
									<tr class="text-sm">
										<td><input type="checkbox" /></td>
										<td>${loop.index+1}</td>
										<td>${item.maNhanVien}</td>
										<td>${item.tenNhanVien}</td>
										<td>${item.email}</td>
										<td>${item.soDienThoai}</td>
										<td>${item.matKhau}</td>
										<td>${item.hinhAnh}</td>
										<td>${item.ngaySinh}</td>
										<td>${item.loaiNhanVien.tenLoaiNhanVien}</td>
										<td>${item.rapPhim.tenRapPhim}</td>
										<td>
											<div class="d-flex column-gap-2">
												<a
													class="ri-delete-bin-6-line text-decoration-none text-black-50"
													style="cursor: pointer" title="Xóa"
													href="/admin/deletenhanvien?id=${item.maNhanVien}"></a><a
													href="/admin/updatenhanvien?id=${item.maNhanVien}"
													class="ri-error-warning-line text-decoration-none text-black-50"
													style="cursor: pointer" title="Xem chi tiết"></a>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<%-- Pagination --%>
						<form action="" method="post">
							<nav aria-label="Page navigation example">
								<ul class="pagination pagination-sm">
									<li class="page-item"><button class="page-link text-dark"
											${list.number  == 0 ? 'disabled' : ''}
											formaction="/admin/nhanviens?p=${list.number -1 }&type=${type}"
											aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
										</button></li>

									<c:forEach var="st" begin="1" end="${list.totalPages}">
										<li class="page-item"><button
												class="page-link ${list.number == (st-1) ? 'bg-primary text-white' : 'text-dark bg-white'}"
												formaction="
												/admin/nhanviens?p=${st-1}
												&type=${type}">${st}</button></li>
									</c:forEach>


									<li class="page-item"><button class="page-link text-dark"
											${list.number +1 == list.totalPages ? 'disabled' : ''}
											formaction="/admin/nhanviens?p=${list.number  + 1}&type=${type}"
											aria-label="Previous">
											<span aria-hidden="true">&raquo;</span>
										</button></li>
								</ul>
							</nav>
						</form>
						<%-- End pagination --%>
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

