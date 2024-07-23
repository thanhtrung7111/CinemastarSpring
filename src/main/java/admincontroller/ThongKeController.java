package admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class ThongKeController {

	@GetMapping(value = "/thongkes")
	public String thongKes() {
		return "manager/thongke/list";
	}
}
