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
import org.springframework.web.multipart.MultipartFile;

import dao.ComboDoAnDAO;
import dao.ComboDoAnDAO;
import model.ComboDoAn;
import service.UploadImageService;

@Controller
@RequestMapping(value = "/admin")
public class ComboController {

	@Autowired
	ComboDoAnDAO comboDoAnDAO;

	@Autowired
	UploadImageService uploadImageService;

	@GetMapping(value = "/combos")
	public String getList(Model model) {
		List<ComboDoAn> list = comboDoAnDAO.findAll();
		model.addAttribute("list", list);
		model.addAttribute("entity", new ComboDoAn());
		return "manager/combo/list";
	}

	@GetMapping(value = "/createcombo")
	public String createView(Model model) {
		model.addAttribute("entity", new ComboDoAn());
		return "manager/combo/form";
	}

	@PostMapping(value = "/createcombo")
	public String doCreate(@RequestParam(name = "image") MultipartFile file,
			@Validated @ModelAttribute(name = "entity") ComboDoAn combo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("image", file);
			return "manager/combo/form";
		}
		if (file.isEmpty()) {
			model.addAttribute("message", "Chưa thêm hình ảnh vào!");
			return "manager/combo/form";
		}

		Optional<ComboDoAn> findItem = comboDoAnDAO.findByTenCombo(combo.getTenCombo());
		if (findItem.isPresent()) {
			model.addAttribute("message", "Tên khuyến mãi đã tồn tại");
			return "manager/combo/form";
		}
		try {
			combo.setHinhAnh(uploadImageService.upload(file));
		} catch (Exception e) {
			model.addAttribute("message", "Có lỗi upload hình ảnh!");
			return "manager/combo/form";
		}
		comboDoAnDAO.save(combo);
		return "redirect:/admin/combos";
	}

	@GetMapping(value = "/updatecombo")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<ComboDoAn> combo = comboDoAnDAO.findById(id.get());
		if (combo.isPresent()) {
			model.addAttribute("entity", combo.get());
			model.addAttribute("update", true);
			return "manager/combo/form";
		}
		return "redirect:/admin/combos";
	}

	@PostMapping(value = "/updatecombo")
	public String doUpdate(@RequestParam(name = "image") MultipartFile file,
			@Validated @ModelAttribute(name = "entity") ComboDoAn combo, BindingResult result, Model model) {
		System.out.println("hello");
		if (result.hasErrors()) {
			model.addAttribute("update", true);
			return "manager/combo/form";
		}

		if (!file.isEmpty()) {
			try {
				combo.setHinhAnh(uploadImageService.upload(file));
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "Có lỗi upload hình ảnh!");
				return "manager/combo/form";
			}
		}
		comboDoAnDAO.save(combo);
		return "redirect:/admin/combos";
	}

	@GetMapping(value = "/deletecombo")
	public String doDelete(@RequestParam(name = "id") String id) {
		comboDoAnDAO.deleteById(id);
		return "redirect:/admin/combos";
	}
}
