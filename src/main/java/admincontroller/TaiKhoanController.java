package admincontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.TaiKhoanDAO;
import model.TaiKhoan;
import service.SessionService;

@Controller
@RequestMapping(value = "/admin")
public class TaiKhoanController {
	@Autowired
	SessionService session;
	@Autowired
	TaiKhoanDAO taiKhoanDAO;

	Page<TaiKhoan> list;

	@GetMapping(value = "/taikhoans")
	public String taiKhoans(Model model, @RequestParam("p") Optional<Integer> p) {
		session.setAttribute("type", "1");
		session.setAttribute("keywords", "");
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		list = taiKhoanDAO.findAll(pageable);
		model.addAttribute("list", list);
		return "manager/taikhoan/list";
	}

	@PostMapping(value = "/taikhoans")
	public String taiKhoans(Model model, @RequestParam("p") Optional<Integer> p,
			@RequestParam("keywords") Optional<String> keywords, @RequestParam("type") String type) {
		System.out.println(type);
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		String kwords = keywords.orElse(session.getAttribute("keywords"));
		if (kwords == null) {
			kwords = "";
		}
		session.setAttribute("keywords", kwords);
		if (type.equalsIgnoreCase("2")) {
			list = taiKhoanDAO.findAllByMaTaiKhoanLike("%" + kwords + "%", pageable);
		} else if (type.equalsIgnoreCase("1")) {
			list = taiKhoanDAO.findAllByTenTaiKhoanLike("%" + kwords + "%", pageable);
		} else {
			list = taiKhoanDAO.findAllByEmailLike("%" + kwords + "%", pageable);
		}
		model.addAttribute("list", list);
		return "manager/taikhoan/list";
	}
}
