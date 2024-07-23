package filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttribute;

import helper.ApplicationContextHolder;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.SessionService;

public class UserFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		SessionService sessionService = ApplicationContextHolder.getBean(SessionService.class);
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if (sessionService.getAttribute("taiKhoan") != null) {
			chain.doFilter(httpRequest, httpResponse);
		} else {
			sessionService.setAttribute("errorLogin", "Bạn cần phải đăng nhập!");
			httpResponse.sendRedirect("/home");
		}
	}

}
