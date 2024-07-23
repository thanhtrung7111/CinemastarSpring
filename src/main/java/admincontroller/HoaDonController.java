package admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class HoaDonController {

	@GetMapping(value = "/hoadons")
	public String hoaDons() {
		return "manager/hoadon/list";
	}
}
