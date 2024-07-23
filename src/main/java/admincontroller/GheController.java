package admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class GheController {

	@GetMapping(value = "/ghes")
	public String ghes() {
		return "manager/ghe/list";
	}
	@GetMapping(value = "/createghe")
	public String createGhe() {
		return "manager/ghe/create";
	}
}
