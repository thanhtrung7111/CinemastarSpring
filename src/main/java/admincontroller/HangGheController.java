package admincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

import dao.HangGheDAO;
import dao.HangGheDAO;
import model.HangGhe;

@Controller
@RequestMapping(value = "/admin")
public class HangGheController {
	@Autowired
	HangGheDAO hangGheDAO;

	@GetMapping(value = "/hangghes")
	public String getList(Model model) {
		List<HangGhe> list = hangGheDAO.findAll();
		model.addAttribute("list", list);
		return "manager/hangghe/list";
	}

	@GetMapping(value = "/createhangghe")
	public String createView(Model model) {
		model.addAttribute("entity", new HangGhe());
		return "manager/hangghe/form";
	}

	@PostMapping(value = "/createhangghe")
	public String doCreate(@Validated @ModelAttribute(name = "entity") HangGhe hangGhe, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "manager/hangghe/form";
		}
		Optional<HangGhe> findItem = hangGheDAO.findByTenHangGhe(hangGhe.getTenHangGhe());
		if (findItem.isPresent()) {
			model.addAttribute("message", "Tên hàng ghế đã tồn tại                                                                   đã tồn tại");
			return "manager/hangghe/form";
		}
		hangGheDAO.save(hangGhe);
		model.addAttribute("entity", new HangGhe());
		return "redirect:/admin/hangghes";
	}

	@GetMapping(value = "/updatehangghe")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<HangGhe> hangGhe = hangGheDAO.findById(id.get());
		if (hangGhe.isPresent()) {
			model.addAttribute("entity", hangGhe.get());
			model.addAttribute("update", true);
			return "manager/hangghe/form";
		}
		return "redirect:/admin/hangghes";
	}

	@PostMapping(value = "/updatehangghe")
	public String doUpdate(@Validated @ModelAttribute(name = "entity") HangGhe hangGhe, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("update", true);
			return "manager/hangghe/form";
		}

		hangGheDAO.save(hangGhe);
		model.addAttribute("entity", new HangGhe());
		return "redirect:/admin/hangghes";
	}

	@GetMapping(value = "/deletehangghe")
	public String doDelete(@RequestParam(name = "id") String id) {
		hangGheDAO.deleteById(id);
		return "redirect:/admin/hangghes";
	}

}
