package admincontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import dao.NhanVienDAO;
import model.NhanVien;
import service.CookieService;
import service.SessionService;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {

	@Autowired
	SessionService session;

	@Autowired
	CookieService cookie;

	@Autowired
	NhanVienDAO nhanvienDAO;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("entity", new NhanVien());
		return "manager/login";
	}

	@PostMapping("/login")
	public String login1(@Validated @ModelAttribute("entity") NhanVien nhanVien) {
		String username = nhanVien.getEmail();
		String password = nhanVien.getMatKhau();
		Optional<NhanVien> nhanVien2 = nhanvienDAO.findByEmail(username);
		if (!nhanVien2.isEmpty() && nhanVien2.get().getMatKhau().equals(password)) {
			String uri = session.getAttribute("security-uri");
			session.setAttribute("nhanVien", nhanVien2);
			session.setAttribute("error", "");
			return "redirect:" + uri;
		} else {

			{
				session.setAttribute("error", "Sai tài khoản hoặc mật khẩu");
			}
		}
		return "redirect:/admin/login";
	}

	
}
