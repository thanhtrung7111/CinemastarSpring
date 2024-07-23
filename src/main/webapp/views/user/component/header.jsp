<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="bg-white py-4 shadow-sm sticky-top">
	<!-- logo  -->
	<div
		class="container d-flex justify-content-between align-items-center">
		<div>
			<a href="/home" class="text-decoration-none d-flex"> <span
				class="fw-bolder fs-3 text-first">Cinema</span>
				<div class="d-flex align-items-start">
					<span class="fw-medium text-danger text-sm">Star</span> <i
						class="ri-star-fill text-xs text-third"></i>
				</div>
			</a>
		</div>
		<ul
			class="list-unstyled d-flex flex-xl-row column-gap-4 text-dark fw-bold align-items-center mb-0 flex-column bg-white menu">
			<li
				class="menu-item text-dark d-flex align-items-center column-gap-1">
				<a href="/user/chonthanhpho"
				class="text-decoration-none text-dark menu-link"><i
					class="ri-coupon-3-line" style="font-size: 16px"></i> Mua vé</a>
			</li>
			<li class="menu-item position-relative"><a href="/phims"
				class="text-decoration-none text-dark menu-link"
				style="font-size: 16px"> Phim đang chiếu</a></li>
			<li class="menu-item position-relative" style="font-size: 16px">Góc
				điện ảnh <i class="ri-arrow-down-s-line"></i>
				<ul
					class="position-absolute menu-list top-100 start-0 bg-white list-unstyled text-dark rounded-1 border border-1 overflow-hidden"
					style="width: 250px">
					<li><a href="/theloaiphims"
						class="menu-list-item text-decoration-none text-dark">Thể loại
							phim</a></li>
					<li><a href="/dienviens"
						class="menu-list-item text-decoration-none text-dark">Diễn
							viên</a></li>
					<li><a href="/daodiens"
						class="menu-list-item text-decoration-none text-dark">Đạo diễn</a></li>
					<%--
					<li><a href="./theloaiphim.html"
						class="menu-list-item text-decoration-none text-dark">Bình
							luận phim</a></li>
					 --%>
				</ul>
			</li>
			<li class="menu-item position-relative" style="font-size: 16px">Sự
				kiện <i class="ri-arrow-down-s-line"></i>
				<ul
					class="position-absolute menu-list top-100 start-0 bg-white list-unstyled text-dark rounded-1 border border-1 overflow-hidden"
					style="width: 250px">
					<li><a href="/uudais"
						class="menu-list-item text-decoration-none text-dark">Ưu đãi
							tháng</a></li>
					<li><a href="./uudais"
						class="menu-list-item text-decoration-none text-dark">Khuyến
							mãi tháng</a></li>
				</ul>
			</li>
		</ul>
		<div class="d-flex align-items-center column-gap-2">
			<div class="input-group border-1 border rounded-1">
				<input type="text" class="form-control border-0 text-sm"
					placeholder="Tìm kiếm" aria-label="Username"
					aria-describedby="basic-addon1" /> <span
					class="input-group-text border-0 bg-transparent" id="basic-addon1"
					style="cursor: pointer"><i class="ri-search-line"></i></span>
			</div>

			<c:if test="${sessionScope.taiKhoan == null}">
				<button class="bg-transparent border-0 text-sm text-dark"
					data-bs-toggle="modal" data-bs-target="#modalLogin">Đăng
					nhập</button>
			</c:if>
			<c:if test="${sessionScope.taiKhoan != null}">
				<div class="position-relative menu-item">
					<button class="bg-transparent border-0 text-sm text-dark">
						${sessionScope.taiKhoan.tenTaiKhoan}</button>
					<div
						class="position-absolute d-flex flex-column bg-white shadow-lg menu-list"
						style="width: 200px; z-index: 100; right: 0px; top: 100%">
						<a href="/user/personal"
							class="text-decoration-none text-dark text-sm block px-3 py-2 info-item">Trang
							cá nhân</a> <a href="/logout"
							class="text-decoration-none text-dark text-sm text-sm block px-3 py-2 info-item">Đăng
							xuất</a>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</header>