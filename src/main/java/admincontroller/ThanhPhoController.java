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

import dao.ThanhPhoDAO;
import model.ThanhPho;

@Controller
@RequestMapping(value = "/admin")
public class ThanhPhoController {
	@Autowired
	ThanhPhoDAO thanhPhoDAO;

	@GetMapping(value = "/thanhphos")
	public String getList(Model model) {
		List<ThanhPho> thanhPhos = thanhPhoDAO.findAll();
		model.addAttribute("list", thanhPhos);
		return "manager/thanhpho/list";
	}

	@GetMapping(value = "/createthanhpho")
	public String createView(Model model) {
		model.addAttribute("entity", new ThanhPho());
		return "manager/thanhpho/form";
	}

	@PostMapping(value = "/createthanhpho")
	public String doCreate(@Validated @ModelAttribute(name = "entity") ThanhPho thanhPho, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "manager/thanhpho/form";
		}
		Optional<ThanhPho> findItem = thanhPhoDAO.findByTenThanhPho(thanhPho.getTenThanhPho());
		if (findItem.isPresent()) {
			model.addAttribute("message", "Tên thành phố đã tồn tại");
			return "manager/thanhpho/form";
		}
		thanhPhoDAO.save(thanhPho);
		model.addAttribute("entity", new ThanhPho());
		return "redirect:/admin/thanhphos";
	}

	@GetMapping(value = "/updatethanhpho")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<ThanhPho> thanhPho = thanhPhoDAO.findById(id.get());
		if (thanhPho.isPresent()) {
			model.addAttribute("entity", thanhPho.get());
			model.addAttribute("update", true);
			return "manager/thanhpho/form";
		}
		return "redirect:/admin/thanhphos";
	}

	@PostMapping(value = "/updatethanhpho")
	public String doUpdate(@Validated @ModelAttribute(name = "entity") ThanhPho thanhPho, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("update", true);
			return "manager/thanhpho/form";
		}

		thanhPhoDAO.save(thanhPho);
		model.addAttribute("entity", new ThanhPho());
		return "redirect:/admin/thanhphos";
	}

	@GetMapping(value = "/deletethanhpho")
	public String doDelete(@RequestParam(name = "id") String id) {
		thanhPhoDAO.deleteById(id);
		return "redirect:/admin/thanhphos";
	}

}
