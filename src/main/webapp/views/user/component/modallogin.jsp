<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Modal đăng nhập-->
<div class="modal fade" id="modalLogin" tabindex="-1" aria-hidden="true">
	<form action="/login" method="post" class="modal-dialog">
		<div class="modal-content pb-5 px-4">
			<div class="modal-header border-0">
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<h3 class="text-first fw-bolder text-center mb-5">Đăng nhập</h3>

			<div class="px-3">
				<div class="mb-3">
					<label class="form-label fw-bold text-sm mb-1">Email hoặc
						số điện thoại</label> <input type="text" name="email"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập email hoặc số điện thoại" />
				</div>
				<div class="mb-1">
					<label class="form-label fw-bold text-sm mb-1">Mật khẩu</label> <input
						type="password" name="matKhau"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập mật khẩu" />
				</div>
				<div class="text-danger" style="font-size: 12px">${sessionScope.errorLogin}</div>
				<div
					class="d-flex column-gap-1 text-sm my-3 justify-content-between">
					<div>
						<input type="checkbox" class="" /> <span>Ghi nhớ?</span>
					</div>
					<div>
						Bạn chưa có tài khoản? <span class="text-first"
							style="cursor: pointer" data-bs-toggle="modal"
							data-bs-target="#modalRegister">Đăng ký</span>
					</div>
				</div>
				<button class="border-0 text-white bg-first text-sm w-100 py-2">
					Đăng nhập</button>
				<div
					class="d-flex align-items-center justify-content-center column-gap-1 my-2">
					<div class="bg-dark-subtle" style="height: 1px; width: 50px"></div>
					<span class="text-light mb-0 text-xs">hoặc</span>
					<div class="bg-dark-subtle" style="height: 1px; width: 50px"></div>
				</div>
				<div
					class="d-flex align-items-center column-gap-3 justify-content-center">
					<img src="./img/icon/facebook.png" alt=""
						style="height: 30px; width: 30px" /> <img
						src="./img/icon/google.png" alt=""
						style="height: 30px; width: 30px" /> <img
						src="./img/icon/twitter.png" alt=""
						style="height: 30px; width: 30px" />
				</div>
			</div>
		</div>
	</form>
</div>

<c:if test="${sessionScope.errorLogin != null}">
	<script type="text/javascript">
		let errorLogin = true;
		let errorRegister = false;
	</script>
</c:if>

