package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.NhanVien;

@Service
public class AuthInterceptor implements HandlerInterceptor {
	@Autowired
	SessionService session;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		System.out.println(uri);
		Optional<NhanVien> nhanVien = (Optional<NhanVien>) session.getAttribute("nhanVien"); // lấy từ session
		String error = "";
		if (nhanVien == null) { // chưa đăng nhập
			error = "Phải đăng nhập trước khi sử dụng chức năng!!";
		}
		if (error.length() > 0) { // có lỗi
			session.setAttribute("security-uri", uri);
			session.setAttribute("error", error);
			response.sendRedirect("/admin/login"); // điều hướng đến trang login thay vì dùng forward
			return false;
		}
		return true;
	}

}
