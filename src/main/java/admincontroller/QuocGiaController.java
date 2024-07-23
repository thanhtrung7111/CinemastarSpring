package admincontroller;

import java.util.List;
import java.util.Optional;

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

import dao.QuocGiaDAO;
import model.QuocGia;
import model.ThanhPho;

@Controller
@RequestMapping(value = "/admin")
public class QuocGiaController {

	@Autowired
	QuocGiaDAO quocGiaDAO;

	@GetMapping(value = "/quocgias")
	public String getList(Model model) {
		List<QuocGia> quocGias = quocGiaDAO.findAll();
		model.addAttribute("list", quocGias);
		model.addAttribute("entity", new QuocGia());
		return "manager/quocgia/list";
	}

	@GetMapping(value = "/createquocgia")
	public String createView(Model model) {
		model.addAttribute("entity", new QuocGia());
		return "manager/quocgia/form";
	}

	@PostMapping(value = "/createquocgia")
	public String doCreate(@Validated @ModelAttribute(name = "entity") QuocGia quocGia, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "manager/quocgia/form";
		}
		Optional<QuocGia> findItem = quocGiaDAO.findByTenQuocGia(quocGia.getTenQuocGia());
		if (findItem.isPresent()) {
			model.addAttribute("message", "Tên quốc gia đã tồn tại");
			return "manager/quocgia/form";
		}
		quocGiaDAO.save(quocGia);
		return "redirect:/admin/quocgias";
	}

	@GetMapping(value = "/updatequocgia")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<QuocGia> quocGia = quocGiaDAO.findById(id.get());
		if (quocGia.isPresent()) {
			model.addAttribute("entity", quocGia.get());
			model.addAttribute("update", true);
			return "manager/quocgia/form";
		}
		return "redirect:/admin/quocgias";
	}

	@PostMapping(value = "/updatequocgia")
	public String doUpdate(@Validated @ModelAttribute(name = "entity") QuocGia quocGia, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("update", true);
			return "manager/quocgia/form";
		}

		quocGiaDAO.save(quocGia);
		model.addAttribute("entity", new ThanhPho());
		return "redirect:/admin/quocgias";
	}

	@GetMapping(value = "/deletequocgia")
	public String doDelete(@RequestParam(name = "id") String id) {
		quocGiaDAO.deleteById(id);
		return "redirect:/admin/quocgias";
	}
}
