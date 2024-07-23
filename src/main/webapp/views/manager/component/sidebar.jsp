<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 300px"
	class="bg-white vh-100 d-flex flex-column shadow-sm">
	<div
		class="d-flex py-4 align-items-center justify-content-center mb-5 fw-bolder border-bottom mx-5">
		<span class="fw-bolder fs-3 text-first">Cinema</span>
		<div class="d-flex align-items-start">
			<span class="fw-medium text-danger text-sm">Star</span> <i
				class="ri-star-fill text-xs text-third"></i>
		</div>
	</div>

	<!-- Menu -->
	<div class="d-flex flex-column mt-3">
		<div class="scroll" style="cursor: pointer">
			<div
				class="px-3 py-2 info-item d-flex align-items-center justify-content-between">
				<div class="text-sm text-decoration-none">
					<i class="ri-tools-fill"></i> Quản lý chung
				</div>

				<i class="ri-arrow-down-s-line text-sm"></i>
			</div>
			<ul class="list-unstyled mb-0 item-scroll"
				style="height: 0; overflow: hidden; transition: height 0.3s ease;">
				<li><a href="/admin/rapphims"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Rạp
						phim</a></li>
				<li><a href="/admin/phongphims"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Phòng
						phim</a></li>
				<li><a href="/admin/hangghes"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Hàng
						ghế</a></li>
				<li><a href="/admin/loaighes"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Loại
						ghế</a></li>

				<li><a href="/admin/thanhphos"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Thành
						Phố</a></li>
				<li><a href="/admin/quocgias"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Quốc
						gia</a></li>
				<li><a href="/admin/loaitaikhoans"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Loại
						tài khoản</a></li>
				<li><a href="/admin/loainhanviens"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Loại
						nhân viên</a></li>
				<li><a href="/admin/vaitros"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Vai
						trò diễn viên</a></li>
			</ul>
		</div>

		<!-- Rạp phim  -->
		<div class="scroll" style="cursor: pointer">
			<div
				class="px-3 py-2 info-item d-flex align-items-center justify-content-between">
				<div class="text-sm text-decoration-none">
					<i class="ri-home-3-line"></i> Quản lý rạp phim
				</div>

				<i class="ri-arrow-down-s-line text-sm"></i>
			</div>
			<ul class="list-unstyled mb-0 item-scroll"
				style="height: 0; overflow: hidden; transition: height 0.3s ease;">
				<li><a href="/admin/suatchieus"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Suất
						chiếu</a></li>

				<li><a href="/admin/hoadons"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Hóa
						đơn</a></li>
				<li><a href="/admin/khuyenmais"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Khuyến
						mãi</a></li>
				<li><a href="/admin/combos"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Thực
						phẩm / combo</a></li>
			</ul>
		</div>

		<!-- PHIM  -->
		<div class="scroll" style="cursor: pointer">
			<div
				class="px-3 py-2 info-item d-flex align-items-center justify-content-between">
				<div class="text-sm text-decoration-none">
					<i class="ri-film-line"></i> Quản lý phim
				</div>

				<i class="ri-arrow-down-s-line text-sm"></i>
			</div>
			<ul class="list-unstyled mb-0 item-scroll"
				style="height: 0; overflow: hidden; transition: height 0.3s ease;">
				<li><a href="/admin/phims"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Phim</a>
				</li>
				<li><a href="/admin/dienviens"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Đạo
						diễn, diễn viên</a></li>
				<li><a href="/admin/theloais"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Thể
						loại phim</a></li>
			</ul>
		</div>
		<!-- TÀI KHOẢN  -->
		<div class="scroll" style="cursor: pointer">
			<div
				class="px-3 py-2 info-item d-flex align-items-center justify-content-between">
				<div class="text-sm text-decoration-none">
					<i class="ri-user-line"></i> Quản lý tài khoản
				</div>

				<i class="ri-arrow-down-s-line text-sm"></i>
			</div>
			<ul class="list-unstyled mb-0 item-scroll"
				style="height: 0; overflow: hidden; transition: height 0.3s ease;">
				<li><a href="/admin/taikhoans"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Tài
						khoản người dùng</a></li>
				<li><a href="/admin/nhanviens"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Tài
						khoản nhân viên</a></li>
			</ul>
		</div>
		<!-- THỐNG KÊ  -->
		<div class="scroll" style="cursor: pointer">
			<div
				class="px-3 py-2 info-item d-flex align-items-center justify-content-between">
				<div class="text-sm text-decoration-none">
					<i class="ri-bar-chart-box-line"></i> Thống kê chung
				</div>

				<i class="ri-arrow-down-s-line text-sm"></i>
			</div>
			<ul class="list-unstyled mb-0 item-scroll"
				style="height: 0; overflow: hidden; transition: height 0.3s ease;">
				<li><a href="./quanlytaikhoan.html"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Tài
						khoản người dùng</a></li>
				<li><a href="./quanlynhanvien.html"
					class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Tài
						khoản nhân viên</a></li>
			</ul>
		</div>
	</div>

	<div class="flex-fill d-flex flex-column justify-content-end">
		<a href=""
			class="d-block py-2 px-3 info-item text-dark text-sm text-decoration-none"><i
			class="ri-settings-2-line"></i> Cài đặt</a> <a href="/admin/logout"
			class="d-block py-2 px-3 info-item text-dark text-sm text-decoration-none"><i
			class="ri-logout-box-line"></i> Đăng xuất</a>
	</div>
</div>