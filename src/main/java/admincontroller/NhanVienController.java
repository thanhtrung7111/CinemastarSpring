package admincontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import dao.LoaiNhanVienDAO;
import dao.NhanVienDAO;
import dao.RapPhimDAO;
import model.NhanVien;
import service.SessionService;
import service.UploadImageService;

@Controller
@RequestMapping(value="/admin")
public class NhanVienController {
	@Autowired
	SessionService session;
	@Autowired
	NhanVienDAO nhanvienDAO;
	@Autowired
	LoaiNhanVienDAO loaiNhanVienDAO;
	@Autowired
	RapPhimDAO rapPhimDAO;
	@Autowired
	UploadImageService uploadImageService;
	
	Page<NhanVien> list;
	
	@GetMapping(value="/nhanviens")
	public String nhanViens(Model model, @RequestParam("p") Optional<Integer> p) {
		reset();
		Pageable pageable = PageRequest.of(p.orElse(0), 1);
		list = nhanvienDAO.findAll(pageable);
		model.addAttribute("list",list);
		return "manager/nhanvien/list";
	}
	@PostMapping(value="/nhanviens")
	public String nhanViens2(Model model, @RequestParam("p") Optional<Integer> p,@RequestParam("keywords")Optional<String>keywords,@RequestParam("type")String type){
		System.out.println(type);
		Pageable pageable = PageRequest.of(p.orElse(0), 1);
		String kwords = keywords.orElse(session.getAttribute("keywords"));
		if (kwords == null) {
			kwords = "";
		}
		session.setAttribute("keywords", kwords);
		if(type.equalsIgnoreCase("2")) {
			list = nhanvienDAO.findAllByMaNhanVienLike("%" + kwords + "%", pageable);
		}else if(type.equalsIgnoreCase("1")) {
			list = nhanvienDAO.findAllByTenNhanVienLike("%" + kwords + "%", pageable);
		}else {
			list = nhanvienDAO.findAllByEmailLike("%" + kwords + "%", pageable);
		}
		model.addAttribute("list", list);
		return "manager/nhanvien/list";
	}
	@GetMapping(value = "/createnhanvien")
	public String createView(Model model) {
		model.addAttribute("entity", new NhanVien());
		model.addAttribute("loaiNhanVien", loaiNhanVienDAO.findAll());
		model.addAttribute("rapPhim", rapPhimDAO.findAll());
		return "manager/nhanvien/form";
	}

	@PostMapping(value = "/createnhanvien")
	public String doCreate(@RequestParam(name = "image") MultipartFile file,
			@Validated @ModelAttribute(name = "entity") NhanVien nhanVien, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("loaiNhanVien", loaiNhanVienDAO.findAll());
			model.addAttribute("rapPhim", rapPhimDAO.findAll());
			return "manager/nhanvien/form";
		}
		if (file.isEmpty()) {
			model.addAttribute("loaiNhanVien", loaiNhanVienDAO.findAll());
			model.addAttribute("rapPhim", rapPhimDAO.findAll());
			model.addAttribute("message", "Chưa thêm hình ảnh vào!");
			return "manager/nhanvien/form";
		}

		Optional<NhanVien> findItem = nhanvienDAO.findByTenNhanVien(nhanVien.getTenNhanVien());
		if (findItem.isPresent()) {
			model.addAttribute("loaiNhanVien", loaiNhanVienDAO.findAll());
			model.addAttribute("rapPhim", rapPhimDAO.findAll());
			model.addAttribute("message", "Tên nhân viên đã tồn tại");
			return "manager/nhanvien/form";
		}
		try {
			nhanVien.setHinhAnh(uploadImageService.upload(file));
		} catch (Exception e) {
			model.addAttribute("message", "Có lỗi upload hình ảnh!");
			return "manager/dienvien/form";
		}
		nhanvienDAO.save(nhanVien);
		return "redirect:/admin/nhanviens";
	}

	@GetMapping(value = "/updatenhanvien")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<NhanVien> nhanVien = nhanvienDAO.findById(id.get());
		if (nhanVien.isPresent()) {
			model.addAttribute("entity", nhanVien.get());
			model.addAttribute("loaiNhanVien", loaiNhanVienDAO.findAll());
			model.addAttribute("rapPhim", rapPhimDAO.findAll());
			model.addAttribute("update", true);
			return "manager/nhanvien/form";
		}
		return "redirect:/admin/nhanviens";
	}

	@PostMapping(value = "/updatenhanvien")
	public String doUpdate(@RequestParam(name = "image") MultipartFile file,
			@Validated @ModelAttribute(name = "entity") NhanVien nhanVien, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("update", true);
			model.addAttribute("loaiNhanVien", loaiNhanVienDAO.findAll());
			model.addAttribute("rapPhim", rapPhimDAO.findAll());
			return "manager/nhanvien/form";
		}

		if (!file.isEmpty()) {
			try {
				nhanVien.setHinhAnh(uploadImageService.upload(file));
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "Có lỗi upload hình ảnh!");
				return "manager/nhanvien/form";
			}
		}
		nhanvienDAO.save(nhanVien);
		return "redirect:/admin/nhanviens";
	}

	@GetMapping(value = "/deletenhanvien")
	public String doDelete(@RequestParam(name = "id") String id) {
		nhanvienDAO.deleteById(id);
		return "redirect:/admin/nhanviens";
	}
	public void reset() {
		session.setAttribute("type","1");
		session.setAttribute("keywords", null);
	}
}
