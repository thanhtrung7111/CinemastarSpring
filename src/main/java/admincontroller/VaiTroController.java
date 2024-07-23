package admincontroller;

import java.lang.StackWalker.Option;
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

import dao.VaiTroDAO;
import model.VaiTro;
import model.ThanhPho;

@Controller
@RequestMapping(value = "/admin")
public class VaiTroController {

	@Autowired
	VaiTroDAO vaiTroDAO;

	@GetMapping(value = "/vaitros")
	public String getList(Model model) {
		List<VaiTro> list = vaiTroDAO.findAll();
		model.addAttribute("list", list);
		model.addAttribute("entity", new VaiTro());
		return "manager/vaitro/list";
	}

	@GetMapping(value = "/createvaitro")
	public String createView(Model model) {
		model.addAttribute("entity", new VaiTro());
		return "manager/vaitro/form";
	}

	@PostMapping(value = "/createvaitro")
	public String doCreate(@Validated @ModelAttribute(name = "entity") VaiTro vaiTro, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "manager/vaitro/form";
		}
		Optional<VaiTro> findItem = vaiTroDAO.findByTenVaiTro(vaiTro.getTenVaiTro());
		if (findItem.isPresent()) {
			model.addAttribute("message", "Tên quốc gia đã tồn tại");
			return "manager/vaitro/form";
		}
		vaiTroDAO.save(vaiTro);
		return "redirect:/admin/vaitros";
	}

	@GetMapping(value = "/updatevaitro")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<VaiTro> vaiTro = vaiTroDAO.findById(id.get());
		if (vaiTro.isPresent()) {
			model.addAttribute("entity", vaiTro.get());
			model.addAttribute("update", true);
			return "manager/vaitro/form";
		}
		return "redirect:/admin/vaitros";
	}

	@PostMapping(value = "/updatevaitro")
	public String doUpdate(@Validated @ModelAttribute(name = "entity") VaiTro vaiTro, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("update", true);
			return "manager/vaitro/form";
		}
		Optional<VaiTro> vaiOptional = vaiTroDAO.findByTenVaiTro(vaiTro.getTenVaiTro());
		if (vaiOptional.isPresent()) {
			model.addAttribute("update", true);
			model.addAttribute("message", "Tên vai trò đã tồn tại!");
			return "manager/vaitro/form";
		}

		vaiTroDAO.save(vaiTro);
		model.addAttribute("entity", new ThanhPho());
		return "redirect:/admin/vaitros";
	}

	@GetMapping(value = "/deletevaitro")
	public String doDelete(@RequestParam(name = "id") String id) {
		vaiTroDAO.deleteById(id);
		return "redirect:/admin/vaitros";
	}
}
