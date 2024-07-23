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

import dao.KhuyenMaiDAO;
import dao.KhuyenMaiDAO;
import dao.ThanhPhoDAO;
import jakarta.servlet.annotation.MultipartConfig;
import model.KhuyenMai;
import model.ThanhPho;
import service.UploadImageService;

@Controller
@RequestMapping(value = "/admin")
@MultipartConfig
public class KhuyenMaiController {

	@Autowired
	KhuyenMaiDAO khuyenMaiDAO;

	@Autowired
	UploadImageService uploadImageService;

	@GetMapping(value = "/khuyenmais")
	public String getList(Model model) {
		List<KhuyenMai> list = khuyenMaiDAO.findAll();
		model.addAttribute("list", list);
		model.addAttribute("entity", new KhuyenMai());
		return "manager/khuyenmai/list";
	}

	@GetMapping(value = "/createkhuyenmai")
	public String createView(Model model) {
		model.addAttribute("entity", new KhuyenMai());
		return "manager/khuyenmai/form";
	}

	@PostMapping(value = "/createkhuyenmai")
	public String doCreate(@RequestParam(name = "image") MultipartFile file,
			@Validated @ModelAttribute(name = "entity") KhuyenMai khuyenMai, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("image", file);
			return "manager/khuyenmai/form";
		}
		if (file.isEmpty()) {
			model.addAttribute("message", "Chưa thêm hình ảnh vào!");
			return "manager/khuyenmai/form";
		}

		if (khuyenMai.getNgayApDung().after(khuyenMai.getNgayKetThuc())) {
			model.addAttribute("message", "Ngày bắt đầu không được lớn hơn ngày kết thúc!");
			return "manager/khuyenmai/form";
		}
		Optional<KhuyenMai> findItem = khuyenMaiDAO.findByTenKhuyenMai(khuyenMai.getTenKhuyenMai());
		if (findItem.isPresent()) {
			model.addAttribute("message", "Tên khuyến mãi đã tồn tại");
			return "manager/khuyenmai/form";
		}
		try {
			khuyenMai.setHinhAnh(uploadImageService.upload(file));
		} catch (Exception e) {
			model.addAttribute("message", "Có lỗi upload hình ảnh!");
			return "manager/khuyenmai/form";
		}
		khuyenMaiDAO.save(khuyenMai);
		return "redirect:/admin/khuyenmais";
	}

	@GetMapping(value = "/updatekhuyenmai")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<KhuyenMai> khuyenMai = khuyenMaiDAO.findById(id.get());
		if (khuyenMai.isPresent()) {
			model.addAttribute("entity", khuyenMai.get());
			model.addAttribute("update", true);
			return "manager/khuyenmai/form";
		}
		return "redirect:/admin/khuyenmais";
	}

	@PostMapping(value = "/updatekhuyenmai")
	public String doUpdate(@RequestParam(name = "image") MultipartFile file,
			@Validated @ModelAttribute(name = "entity") KhuyenMai khuyenMai, BindingResult result, Model model) {
		System.out.println("hello");
		if (result.hasErrors()) {
			model.addAttribute("update", true);
			return "manager/khuyenmai/form";
		}

		if (khuyenMai.getNgayApDung().after(khuyenMai.getNgayKetThuc())) {
			model.addAttribute("update", true);
			model.addAttribute("message", "Ngày bắt đầu không được lớn hơn ngày kết thúc!");
			return "manager/khuyenmai/form";
		}
		if (!file.isEmpty()) {
			try {
				khuyenMai.setHinhAnh(uploadImageService.upload(file));
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "Có lỗi upload hình ảnh!");
				return "manager/khuyenmai/form";
			}
		}
		khuyenMaiDAO.save(khuyenMai);
		return "redirect:/admin/khuyenmais";
	}

	@GetMapping(value = "/deletekhuyenmai")
	public String doDelete(@RequestParam(name = "id") String id) {
		khuyenMaiDAO.deleteById(id);
		return "redirect:/admin/khuyenmais";
	}
}
