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

import dao.DienVienDAO;
import dao.QuocGiaDAO;
import dao.VaiTroDAO;
import model.DienVienDaoDien;
import service.UploadImageService;

@Controller
@RequestMapping(value = "/admin")
public class DienVienController {

	@Autowired
	DienVienDAO dienVienDAO;

	@Autowired
	UploadImageService uploadImageService;

	@Autowired
	VaiTroDAO vaiTroDAO;

	@Autowired
	QuocGiaDAO quocGiaDAO;

	@GetMapping(value = "/dienviens")
	public String getList(Model model) {
		List<DienVienDaoDien> list = dienVienDAO.findAll();
		model.addAttribute("list", list);
		model.addAttribute("entity", new DienVienDaoDien());
		return "manager/dienvien/list";
	}

	@GetMapping(value = "/createdienvien")
	public String createView(Model model) {
		model.addAttribute("entity", new DienVienDaoDien());
		model.addAttribute("quocGias", quocGiaDAO.findAll());
		model.addAttribute("vaiTros", vaiTroDAO.findAll());
		return "manager/dienvien/form";
	}

	@PostMapping(value = "/createdienvien")
	public String doCreate(@RequestParam(name = "image") MultipartFile file,
			@Validated @ModelAttribute(name = "entity") DienVienDaoDien dienVien, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("quocGias", quocGiaDAO.findAll());
			model.addAttribute("vaiTros", vaiTroDAO.findAll());
			return "manager/dienvien/form";
		}
		if (file.isEmpty()) {
			model.addAttribute("quocGias", quocGiaDAO.findAll());
			model.addAttribute("vaiTros", vaiTroDAO.findAll());
			model.addAttribute("message", "Chưa thêm hình ảnh vào!");
			return "manager/dienvien/form";
		}

		Optional<DienVienDaoDien> findItem = dienVienDAO.findByTenDV_DD(dienVien.getTenDV_DD());
		if (findItem.isPresent()) {
			model.addAttribute("quocGias", quocGiaDAO.findAll());
			model.addAttribute("vaiTros", vaiTroDAO.findAll());
			model.addAttribute("message", "Tên diễn viên đã tồn tại");
			return "manager/dienvien/form";
		}
		try {
			dienVien.setHinhAnh(uploadImageService.upload(file));
		} catch (Exception e) {
			model.addAttribute("message", "Có lỗi upload hình ảnh!");
			return "manager/dienvien/form";
		}
		dienVienDAO.save(dienVien);
		return "redirect:/admin/dienviens";
	}

	@GetMapping(value = "/updatedienvien")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<DienVienDaoDien> dienVien = dienVienDAO.findById(id.get());
		if (dienVien.isPresent()) {
			model.addAttribute("entity", dienVien.get());
			model.addAttribute("quocGias", quocGiaDAO.findAll());
			model.addAttribute("vaiTros", vaiTroDAO.findAll());
			model.addAttribute("update", true);
			return "manager/dienvien/form";
		}
		return "redirect:/admin/dienviens";
	}

	@PostMapping(value = "/updatedienvien")
	public String doUpdate(@RequestParam(name = "image") MultipartFile file,
			@Validated @ModelAttribute(name = "entity") DienVienDaoDien dienVien, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("update", true);
			model.addAttribute("quocGias", quocGiaDAO.findAll());
			model.addAttribute("vaiTros", vaiTroDAO.findAll());
			return "manager/dienvien/form";
		}

		if (!file.isEmpty()) {
			try {
				dienVien.setHinhAnh(uploadImageService.upload(file));
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "Có lỗi upload hình ảnh!");
				return "manager/dienvien/form";
			}
		}
		dienVienDAO.save(dienVien);
		return "redirect:/admin/dienviens";
	}

	@GetMapping(value = "/deletedienvien")
	public String doDelete(@RequestParam(name = "id") String id) {
		dienVienDAO.deleteById(id);
		return "redirect:/admin/dienviens";
	}
}
