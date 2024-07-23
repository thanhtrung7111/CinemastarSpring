<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div
	class="d-flex justify-content-between bg-white shadow-sm align-items-center px-3 py-3">
	<div
		class="input-group bg-white input-group-sm rounded-3 border overflow-hidden px-2"
		style="width: 400px; height: fit-content">
		<input type="text" class="form-control border-0"
			placeholder="Tìm kiếm..." aria-label="Username"
			aria-describedby="basic-addon1" /> <span
			class="input-group-text bg-transparent border-0" id="basic-addon1"><i
			class="ri-search-line"></i></span>
	</div>
	<div class="d-flex align-items-center column-gap-5">
		<div>
			<div class="position-relative">
				<i class="ri-notification-line"></i> <span
					class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
					99+ </span>
			</div>
		</div>
		<div class="d-flex column-gap-3 align-self-start">
			<img src="/img/${sessionScope.nhanVien.get().hinhAnh}"
				class="rounded-circle" alt=""
				style="height: 40px; width: 40px; object-fit: cover; object-position: center;" />
			<div>
				<h5 class="fs-6 mb-0">${sessionScope.nhanVien.get().tenNhanVien}</h5>
				<span class="text-sm">(${sessionScope.nhanVien.get().loaiNhanVien.tenLoaiNhanVien})</span>
			</div>
		</div>
	</div>
</div>