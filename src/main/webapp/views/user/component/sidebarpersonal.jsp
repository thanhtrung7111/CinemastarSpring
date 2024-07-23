<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-12 col-lg-5 col-xl-4">
	<div class="py-5 bg-white shadow-sm rounded-3">
		<div
			class="d-flex px-3 column-gap-3 align-items-center justify-content-center mb-3 pb-3 border-bottom">
			<img src="./img/dienvien1.jpg" alt=""
				style="height: 100px; width: 100px; object-fit: cover; object-position: center;"
				class="rounded-circle" />
			<div class="d-flex flex-column row-gap-1">
				<h5 class="text-dark fw-bold mb-0">${sessionScope.taiKhoan.tenTaiKhoan}</h5>
				<span class="text-first">${sessionScope.taiKhoan.loaiTaiKhoan.tenLoaiTaiKhoan}</span>
				<span class="text-first"><i
					class="ri-money-dollar-circle-line"></i> 18.000 điểm</span>
			</div>
		</div>
		<div class="text-sm d-flex flex-column">
			<a href="/user/giaodichs"
				class="block py-2 px-3 info-item text-decoration-none text-dark"
				style="cursor: pointer"> Lịch sử giao dịch </a> <a
				href="/user/personal"
				class="block py-2 px-3 info-item text-decoration-none text-dark"
				style="cursor: pointer"> Thông tin cá nhân </a> <a
				href="/user/changepassword"
				class="block py-2 px-3 info-item text-decoration-none text-dark"
				style="cursor: pointer"> Đổi mật khẩu </a> <a
				class="block py-2 px-3 info-item text-decoration-none text-dark"
				style="cursor: pointer"> Khuyến mãi </a>
		</div>
	</div>
</div>