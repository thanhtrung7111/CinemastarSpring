<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Modal đăng kí-->
<div class="modal fade" id="modalRegister" tabindex="-1"
	aria-hidden="true">
	<div class="modal-dialog">
		<form class="modal-content pb-5 px-4 needs-validation" method="post"
			action="/register" novalidate>
			<div class="modal-header border-0">
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<h3 class="text-first fw-bolder text-center mb-5">Đăng kí tài
				khoản</h3>

			<div class="px-3">
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Tên đăng
						nhập<span class="text-danger fs-5">*</span>
					</label> <input type="text" required pattern="(.|\n)*\S(.|\n)*"
						name="maTaiKhoan" value="${taiKhoanRegister.maTaiKhoan}"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập họ và tên" />

					<div class="invalid-feedback text-danger" style="font-size: 12px">Không
						để trống tên đăng nhập!</div>
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Họ và tên <span
						class="text-danger fs-5">*</span>
					</label> <input type="text" required pattern="(.|\n)*\S(.|\n)*"
						name="tenTaiKhoan" value="${taiKhoanRegister.tenTaiKhoan}"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập họ và tên" />

					<div class="invalid-feedback text-danger" style="font-size: 12px">Không
						để trống họ tên!</div>
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Email <span
						class="text-danger fs-5">*</span>
					</label> <input type="email" name="email" value="${taiKhoanRegister.email}"
						class="form-control text-sm focus-ring focus-ring-info" required
						placeholder="Nhập họ và tên" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Email
						không đúng định dạng!</div>
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Số điện
						thoại <span class="text-danger fs-5">*</span>
					</label> <input type="text" name="soDienThoai"
						value="${taiKhoanRegister.soDienThoai}"
						class="form-control text-sm focus-ring focus-ring-info" required
						pattern="0[0-9]{9}" placeholder="Nhập mật khẩu" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Số
						điện thoại không đúng định dạng!</div>
				</div>
				<div class="mb-2 text-sm d-flex column-gap-3">
					<div>
						<input type="radio" name="gioiTinh" checked /> Nam
					</div>
					<div>
						<input type="radio" name="gioiTinh" /> Nữ
					</div>
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Ngày sinh <span
						class="text-danger fs-5">*</span>
					</label> <input type="date" required name="ngaySinh"
						value="${taiKhoanRegister.ngaySinh}"
						class="form-control text-sm focus-ring focus-ring-info" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Ngày
						sinh không để trống!</div>
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Mật khẩu <span
						class="text-danger fs-5">*</span>
					</label> <input type="password" required
						pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" name="matKhau"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập mật khẩu" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Không
						để trống mật khẩu!</div>
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Nhập lại mật
						khẩu <span class="text-danger fs-5">*</span>
					</label> <input type="password" required pattern="(.|\n)*\S(.|\n)*"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập lại mật khẩu" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Không
						để trống xác nhận mật khẩu!</div>
				</div>
				<div class="text-danger" style="font-size: 12px">${errorRegister}</div>
				<button class="border-0 text-white bg-first text-sm w-100 py-2 mt-3"
					id="buttonDangKy">Đăng kí</button>
				<div class="text-sm">
					Bạn đã có tài khoản? <span class="text-first"
						style="cursor: pointer" data-bs-toggle="modal"
						data-bs-target="#modalLogin">Đăng nhập</span>
				</div>
			</div>
		</form>
	</div>
</div>
<c:if test="${sessionScope.errorRegister != null}">
	<script type="text/javascript">
		let errorRegister = true;
		let errorLogin = false;
	</script>
</c:if>

<script type="text/javascript">// Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
	  'use strict'

	  // Fetch all the forms we want to apply custom Bootstrap validation styles to
	  const forms = document.querySelectorAll('.needs-validation')

	  // Loop over them and prevent submission
	  Array.from(forms).forEach(form => {
	    form.addEventListener('submit', event => {
	      if (!form.checkValidity()) {
	        event.preventDefault()
	        event.stopPropagation()
	      }

	      form.classList.add('was-validated')
	    }, false)
	  })
	})()
	
	</script>