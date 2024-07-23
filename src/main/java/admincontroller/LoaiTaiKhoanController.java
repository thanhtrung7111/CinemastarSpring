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

import dao.LoaiTaiKhoanDAO;
import model.LoaiTaiKhoan;
import model.ThanhPho;

@Controller
@RequestMapping(value = "/admin")
public class LoaiTaiKhoanController {

	@Autowired
	LoaiTaiKhoanDAO loaiTaiKhoanDAO;

	@GetMapping(value = "/loaitaikhoans")
	public String getList(Model model) {
		List<LoaiTaiKhoan> list = loaiTaiKhoanDAO.findAll();
		model.addAttribute("list", list);
		model.addAttribute("entity", new LoaiTaiKhoan());
		return "manager/loaitaikhoan/list";
	}

	@GetMapping(value = "/createloaitaikhoan")
	public String createView(Model model) {
		model.addAttribute("entity", new LoaiTaiKhoan());
		return "manager/loaitaikhoan/form";
	}

	@PostMapping(value = "/createloaitaikhoan")
	public String doCreate(@Validated @ModelAttribute(name = "entity") LoaiTaiKhoan loaiTaiKhoan, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "manager/loaitaikhoan/form";
		}
		Optional<LoaiTaiKhoan> findItem = loaiTaiKhoanDAO.findByTenLoaiTaiKhoan(loaiTaiKhoan.getTenLoaiTaiKhoan());
		if (findItem.isPresent()) {
			model.addAttribute("message", "Tên loại tài khoản đã tồn tại");
			return "manager/loaitaikhoan/form";
		}
		loaiTaiKhoanDAO.save(loaiTaiKhoan);
		return "redirect:/admin/loaitaikhoans";
	}

	@GetMapping(value = "/updateloaitaikhoan")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<LoaiTaiKhoan> loaiTaiKhoan = loaiTaiKhoanDAO.findById(id.get());
		if (loaiTaiKhoan.isPresent()) {
			model.addAttribute("entity", loaiTaiKhoan.get());
			model.addAttribute("update", true);
			return "manager/loaitaikhoan/form";
		}
		return "redirect:/admin/loaitaikhoans";
	}

	@PostMapping(value = "/updateloaitaikhoan")
	public String doUpdate(@Validated @ModelAttribute(name = "entity") LoaiTaiKhoan loaiTaiKhoan, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("update", true);
			return "manager/loaitaikhoan/form";
		}

		loaiTaiKhoanDAO.save(loaiTaiKhoan);
		model.addAttribute("entity", new LoaiTaiKhoan());
		return "redirect:/admin/loaitaikhoans";
	}

	@GetMapping(value = "/deleteloaitaikhoan")
	public String doDelete(@RequestParam(name = "id") String id) {
		loaiTaiKhoanDAO.deleteById(id);
		return "redirect:/admin/loaitaikhoans";
	}
}
