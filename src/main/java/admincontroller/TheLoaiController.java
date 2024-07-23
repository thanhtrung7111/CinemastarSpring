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

import dao.TheLoaiDAO;
import model.TheLoai;
import model.ThanhPho;

@Controller
@RequestMapping(value = "/admin")
public class TheLoaiController {

	@Autowired
	TheLoaiDAO theLoaiDAO;

	@GetMapping(value = "/theloais")
	public String getList(Model model) {
		List<TheLoai> theLoais = theLoaiDAO.findAll();
		model.addAttribute("list", theLoais);
		model.addAttribute("entity", new TheLoai());
		return "manager/theloai/list";
	}

	@GetMapping(value = "/createtheloai")
	public String createView(Model model) {
		model.addAttribute("entity", new TheLoai());
		return "manager/theloai/form";
	}

	@PostMapping(value = "/createtheloai")
	public String doCreate(@Validated @ModelAttribute(name = "entity") TheLoai theLoai, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "manager/theloai/form";
		}
		Optional<TheLoai> findItem = theLoaiDAO.findByTenTheLoai(theLoai.getTenTheLoai());
		if (findItem.isPresent()) {
			model.addAttribute("message", "Tên quốc gia đã tồn tại");
			return "manager/theloai/form";
		}
		theLoaiDAO.save(theLoai);
		return "redirect:/admin/theloais";
	}

	@GetMapping(value = "/updatetheloai")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<TheLoai> theLoai = theLoaiDAO.findById(id.get());
		if (theLoai.isPresent()) {
			model.addAttribute("entity", theLoai.get());
			model.addAttribute("update", true);
			return "manager/theloai/form";
		}
		return "redirect:/admin/theloais";
	}

	@PostMapping(value = "/updatetheloai")
	public String doUpdate(@Validated @ModelAttribute(name = "entity") TheLoai theLoai, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("update", true);
			return "manager/theloai/form";
		}

		theLoaiDAO.save(theLoai);
		model.addAttribute("entity", new ThanhPho());
		return "redirect:/admin/theloais";
	}

	@GetMapping(value = "/deletetheloai")
	public String doDelete(@RequestParam(name = "id") String id) {
		theLoaiDAO.deleteById(id);
		return "redirect:/admin/theloais";
	}
}
