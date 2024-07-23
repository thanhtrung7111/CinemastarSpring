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

import dao.LoaiNhanVienDAO;
import model.LoaiNhanVien;

@Controller
@RequestMapping(value = "/admin")
public class LoaiNhanVienController {
	@Autowired
	LoaiNhanVienDAO loaiNhanVienDAO;

	@GetMapping(value = "/loainhanviens")
	public String getList(Model model) {
		List<LoaiNhanVien> list = loaiNhanVienDAO.findAll();
		model.addAttribute("list", list);
		model.addAttribute("entity", new LoaiNhanVien());
		return "manager/loainhanvien/list";
	}

	@GetMapping(value = "/createloainhanvien")
	public String createView(Model model) {
		model.addAttribute("entity", new LoaiNhanVien());
		return "manager/loainhanvien/form";
	}

	@PostMapping(value = "/createloainhanvien")
	public String doCreate(@Validated @ModelAttribute(name = "entity") LoaiNhanVien loaiNhanVien, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "manager/loainhanvien/form";
		}
		Optional<LoaiNhanVien> findItem = loaiNhanVienDAO.findByTenLoaiNhanVien(loaiNhanVien.getTenLoaiNhanVien());
		if (findItem.isPresent()) {
			model.addAttribute("message", "Tên loại nhân viên đã tồn tại");
			return "manager/loainhanvien/form";
		}
		loaiNhanVienDAO.save(loaiNhanVien);
		return "redirect:/admin/loainhanviens";
	}

	@GetMapping(value = "/updateloainhanvien")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<LoaiNhanVien> loaiNhanVien = loaiNhanVienDAO.findById(id.get());
		if (loaiNhanVien.isPresent()) {
			model.addAttribute("entity", loaiNhanVien.get());
			model.addAttribute("update", true);
			return "manager/loainhanvien/form";
		}
		return "redirect:/admin/loainhanviens";
	}

	@PostMapping(value = "/updateloainhanvien")
	public String doUpdate(@Validated @ModelAttribute(name = "entity") LoaiNhanVien loaiNhanVien, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("update", true);
			return "manager/loainhanvien/form";
		}
		loaiNhanVienDAO.save(loaiNhanVien);
		model.addAttribute("entity", new LoaiNhanVien());
		return "redirect:/admin/loainhanviens";
	}

	@GetMapping(value = "/deleteloainhanvien")
	public String doDelete(@RequestParam(name = "id") String id) {
		loaiNhanVienDAO.deleteById(id);
		return "redirect:/admin/loainhanviens";
	}
}
