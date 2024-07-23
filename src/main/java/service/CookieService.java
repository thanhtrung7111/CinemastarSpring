package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieService {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	public Cookie createCookie(String name, String value, int days) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(days * 60 * 60);
		response.addCookie(cookie);
		cookie.setPath("/");
		return cookie;
	}

	public Cookie getCookie(String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase(name))

					return cookie;
			}
		return null;
	}

	public Boolean getCookie() {
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("user")) {
					System.out.println("có cookie");
					return true;
				}
			}
		System.out.println("kh có cookie");
		return false;
	}

	public void removeCookie(String name) {
		Cookie cookie = getCookie(name);
		cookie.setMaxAge(0);
		System.out.println(cookie.getName());
		response.addCookie(cookie);
		return;
	}
}
