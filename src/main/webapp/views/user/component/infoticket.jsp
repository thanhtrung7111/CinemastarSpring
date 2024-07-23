<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="p-4 bg-white rounded-3 shadow-sm">
	<h4 class="text-center mb-3 text-first fw-bolder">Thông tin vé</h4>
	<img src="/img/${sessionScope.phim.get().hinhAnh}" alt=""
		style="height: 400px; object-fit: cover; object-position: top; width: 100%;"
		class="mb-2" />
	<div class="d-flex align-items-center column-gap-2">
		<h5 class="mb-0 fw-bolder">${sessionScope.phim.get().tenPhim}</h5>

	</div>
	<c:if test="${sessionScope.suatChieu.isEmpty() != true}">
		<div class="text-sm border-bottom pb-2 mb-2">
			<div class="text-light">
				Rạp: <span class="text-dark fw-semibold">${sessionScope.suatChieu.get().phongPhim.rapPhim.tenRapPhim}</span>
			</div>
			<div class="text-light">
				Phòng: <span class="text-dark fw-semibold">${sessionScope.suatChieu.get().phongPhim.tenPhongPhim}</span>
			</div>
			<div class="text-light">
				Suất: <span class="text-dark fw-semibold">${sessionScope.suatChieu.get().thoiGianChieu}
					- ${sessionScope.suatChieu.get().ngayChieu}</span>
			</div>
		</div>
	</c:if>
	<c:if test="${sessionScope.ves.size()>0}">
		<div class="border-bottom pb-2 mb-2">
			<c:forEach items="${sessionScope.ves}" var="ve">
				<div
					class="text-dark text-sm d-flex align-items-center justify-content-between">
					<span>Ghế ${ve.ghe.tenGhe}:</span> <span><fmt:formatNumber
							value="${ve.tongTien}" pattern="#,###" /> VNĐ</span>
				</div>
			</c:forEach>
		</div>
	</c:if>
	<c:if test="${sessionScope.mapCombo.size()>0}">
		<div class="border-bottom pb-2 mb-2">
			<c:forEach items="${sessionScope.mapCombo}" var="combo">
				<div
					class="text-dark text-sm d-flex align-items-center justify-content-between">
					<span>${combo.key.tenCombo}x${combo.value}</span> <span><fmt:formatNumber
							value="${combo.value * combo.key.giaCombo}" pattern="#,###" />
						VNĐ</span>
				</div>
			</c:forEach>
		</div>
	</c:if>
	<c:if test="${sessionScope.khuyenMai.isPresent()}">
		<div class="border-bottom pb-2 mb-2">

			<div
				class="text-dark text-sm d-flex align-items-center justify-content-between">
				<span>${sessionScope.khuyenMai.get().tenKhuyenMai}</span> <span>${sessionScope.khuyenMai.get().phanTramGiam}%</span>
			</div>

		</div>
	</c:if>
	<div
		class="text-dark text-sm d-flex align-items-center justify-content-between">
		<span>Tổng cộng:</span> <span><fmt:formatNumber
				value="${sessionScope.tongTien}" pattern="#,###" /> VNĐ</span>
	</div>