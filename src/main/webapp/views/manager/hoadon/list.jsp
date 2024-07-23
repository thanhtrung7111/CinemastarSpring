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
					<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý hóa đơn</h5>
					<div class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
						<div class="d-flex justify-content-between">
							<h5 class="mb-3">Danh sách hóa đơn</h5>
							<div>
								<a href="./themmoicombo.html"
									class="btn btn-primary btn-sm text-white"> <i
									class="ri-file-copy-line"></i> Sao chép
								</a> <a href="./themmoicombo.html"
									class="btn btn-success btn-sm text-white"> <i
									class="ri-file-excel-line"></i> Xuất excel
								</a>
								<button class="btn bg-first btn-sm text-white"
									data-bs-toggle="modal" data-bs-target="#modalRapphim">
									<i class="ri-file-add-line"></i> Thêm mới
								</button>
							</div>
						</div>
						<table class="table">
							<thead>
								<tr>
									<th><input type="checkbox" /></th>
									<th scope="col">#</th>
									<th scope="col">Mã hóa đơn</th>
									<th scope="col">Tổng tiền</th>
									<th scope="col">Trạng thái</th>
									<th scope="col">Nhân viên xử lý</th>
									<th scope="col">Tài khoản đặt vé</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<tr class="text-sm">
									<td><input type="checkbox" /></td>
									<td>1</td>
									<td>HD0006</td>
									<td>300.000VNĐ</td>
									<td>
										<div class="bg-success text-white py-2 px-2"
											style="width: fit-content">Đã thanh toán</div>
									</td>
									<td>Thành Trung</td>
									<td>nguyenvietduc</td>
									<td>
										<div class="d-flex column-gap-2">
											<i class="ri-delete-bin-6-line" style="cursor: pointer"
												title="Xóa"></i><i class="ri-error-warning-line"
												style="cursor: pointer" title="Xem chi tiết"></i>
										</div>
									</td>
								</tr>

								<tr class="text-sm">
									<td><input type="checkbox" /></td>
									<td>1</td>
									<td>HD0006</td>
									<td>300.000VNĐ</td>
									<td>
										<div class="bg-success text-white py-2 px-2"
											style="width: fit-content">Đã thanh toán</div>
									</td>
									<td>Thành Trung</td>
									<td>nguyenvietduc</td>
									<td>
										<div class="d-flex column-gap-2">
											<i class="ri-delete-bin-6-line" style="cursor: pointer"
												title="Xóa"></i><i class="ri-error-warning-line"
												style="cursor: pointer" title="Xem chi tiết"></i>
										</div>
									</td>
								</tr>

								<tr class="text-sm">
									<td><input type="checkbox" /></td>
									<td>1</td>
									<td>HD0006</td>
									<td>300.000VNĐ</td>
									<td>
										<div class="bg-success text-white py-2 px-2"
											style="width: fit-content">Đã thanh toán</div>
									</td>
									<td>Thành Trung</td>
									<td>nguyenvietduc</td>
									<td>
										<div class="d-flex column-gap-2">
											<i class="ri-delete-bin-6-line" style="cursor: pointer"
												title="Xóa"></i><i class="ri-error-warning-line"
												style="cursor: pointer" title="Xem chi tiết"></i>
										</div>
									</td>
								</tr>

								<tr class="text-sm">
									<td><input type="checkbox" /></td>
									<td>1</td>
									<td>HD0006</td>
									<td>300.000VNĐ</td>
									<td>
										<div class="bg-success text-white py-2 px-2"
											style="width: fit-content">Đã thanh toán</div>
									</td>
									<td>Thành Trung</td>
									<td>nguyenvietduc</td>
									<td>
										<div class="d-flex column-gap-2">
											<i class="ri-delete-bin-6-line" style="cursor: pointer"
												title="Xóa"></i><i class="ri-error-warning-line"
												style="cursor: pointer" title="Xem chi tiết"></i>
										</div>
									</td>
								</tr>

								<tr class="text-sm">
									<td><input type="checkbox" /></td>
									<td>1</td>
									<td>HD0006</td>
									<td>300.000VNĐ</td>
									<td>
										<div class="bg-success text-white py-2 px-2"
											style="width: fit-content">Đã thanh toán</div>
									</td>
									<td>Thành Trung</td>
									<td>nguyenvietduc</td>
									<td>
										<div class="d-flex column-gap-2">
											<i class="ri-delete-bin-6-line" style="cursor: pointer"
												title="Xóa"></i><i class="ri-error-warning-line"
												style="cursor: pointer" title="Xem chi tiết"></i>
										</div>
									</td>
								</tr>

								<tr class="text-sm">
									<td><input type="checkbox" /></td>
									<td>1</td>
									<td>HD0006</td>
									<td>300.000VNĐ</td>
									<td>
										<div class="bg-success text-white py-2 px-2"
											style="width: fit-content">Đã thanh toán</div>
									</td>
									<td>Thành Trung</td>
									<td>nguyenvietduc</td>
									<td>
										<div class="d-flex column-gap-2">
											<i class="ri-delete-bin-6-line" style="cursor: pointer"
												title="Xóa"></i><i class="ri-error-warning-line"
												style="cursor: pointer" title="Xem chi tiết"></i>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>

					<div>
						<div></div>
					</div>
				</div>
			</div>
			<div></div>
		</div>
	</div>
	<script src="../bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script src="../bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>
