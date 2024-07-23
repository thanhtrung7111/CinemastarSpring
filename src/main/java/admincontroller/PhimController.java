package admincontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.DienVienDAO;
import dao.PhimDAO;
import dao.QuocGiaDAO;
import dao.ThamGiaDAO;
import dao.TheLoaiDAO;
import dao.VaiTroDAO;
import jakarta.servlet.annotation.MultipartConfig;
import model.DienVienDaoDien;
import model.Phim;
import model.ThamGia;
import service.UploadImageService;

@Controller
@RequestMapping(value = "/admin")
@MultipartConfig
public class PhimController {

	@Autowired
	PhimDAO phimDAO;

	@Autowired
	UploadImageService uploadImageService;

	@Autowired
	QuocGiaDAO quocGiaDAO;

	@Autowired
	DienVienDAO dienVienDAO;

	@Autowired
	ThamGiaDAO thamGiaDAO;

	@Autowired
	TheLoaiDAO theLoaiDAO;

	@GetMapping(value = "/phims")
	public String getList(Model model) {
		List<Phim> list = phimDAO.findAll();
		model.addAttribute("list", list);
		model.addAttribute("entity", new Phim());
		return "manager/phim/list";
	}

	@GetMapping(value = "/createphim")
	public String createView(Model model) {
		model.addAttribute("entity", new Phim());
		model.addAttribute("quocGias", quocGiaDAO.findAll());
		model.addAttribute("dienViens", dienVienDAO.findAllByTenVaiTro("Diễn Viên"));
		model.addAttribute("daoDiens", dienVienDAO.findAllByTenVaiTro("Đạo Diễn"));
		model.addAttribute("theLoais", theLoaiDAO.findAll());
		return "manager/phim/form";
	}

	@PostMapping(value = "/createphim")
	public String doCreate(@RequestParam(name = "dienViens") List<DienVienDaoDien> dienViens,
			@RequestParam(name = "image") MultipartFile file, @Validated @ModelAttribute(name = "entity") Phim phim,
			BindingResult result, Model model) {
		if (result.hasErrors()) {

			model.addAttribute("quocGias", quocGiaDAO.findAll());
			model.addAttribute("dienViens", dienVienDAO.findAllByTenVaiTro("Diễn Viên"));
			model.addAttribute("daoDiens", dienVienDAO.findAllByTenVaiTro("Đạo Diễn"));
			model.addAttribute("theLoais", theLoaiDAO.findAll());
			return "manager/phim/form";
		}
		if (file.isEmpty()) {
			model.addAttribute("message", "Chưa thêm hình ảnh vào!");
			model.addAttribute("dienViens", dienVienDAO.findAllByTenVaiTro("Diễn Viên"));
			model.addAttribute("daoDiens", dienVienDAO.findAllByTenVaiTro("Đạo Diễn"));
			model.addAttribute("theLoais", theLoaiDAO.findAll());
			model.addAttribute("quocGias", quocGiaDAO.findAll());
			return "manager/phim/form";
		}

		Optional<Phim> findItem = phimDAO.findByTenPhim(phim.getTenPhim());
		if (findItem.isPresent()) {
			model.addAttribute("message", "Tên phim đã tồn tại");
			model.addAttribute("dienViens", dienVienDAO.findAllByTenVaiTro("Diễn Viên"));
			model.addAttribute("daoDiens", dienVienDAO.findAllByTenVaiTro("Đạo Diễn"));
			model.addAttribute("quocGias", quocGiaDAO.findAll());
			model.addAttribute("theLoais", theLoaiDAO.findAll());
			return "manager/phim/form";
		}
		try {
			phim.setHinhAnh(uploadImageService.upload(file));
		} catch (Exception e) {
			model.addAttribute("message", "Có lỗi upload hình ảnh!");
			model.addAttribute("theLoais", theLoaiDAO.findAll());
			model.addAttribute("dienViens", dienVienDAO.findAllByTenVaiTro("Diễn Viên"));
			model.addAttribute("daoDiens", dienVienDAO.findAllByTenVaiTro("Đạo Diễn"));
			model.addAttribute("quocGias", quocGiaDAO.findAll());
			return "manager/phim/form";
		}

		Phim savePhim = phimDAO.save(phim);
		if (dienViens.size() > 0 && !(dienViens.get(0) == null)) {
			for (DienVienDaoDien dv : dienViens) {
				thamGiaDAO.save(new ThamGia(dv, savePhim));
			}
		}
		return "redirect:/admin/phims";
	}

	@GetMapping(value = "/updatephim")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<Phim> phim = phimDAO.findById(id.get());
		if (phim.isPresent()) {
			model.addAttribute("entity", phim.get());
			model.addAttribute("quocGias", quocGiaDAO.findAll());
			model.addAttribute("dienViens", dienVienDAO.findAllByTenVaiTro("Diễn Viên"));
			model.addAttribute("daoDiens", dienVienDAO.findAllByTenVaiTro("Đạo Diễn"));
			model.addAttribute("theLoais", theLoaiDAO.findAll());
			model.addAttribute("update", true);
			return "manager/phim/form";
		}
		return "redirect:/admin/phims";
	}

	@PostMapping(value = "/updatephim")
	public String doUpdate(@RequestParam(name = "dienViens", defaultValue = "null") List<DienVienDaoDien> dienViens,
			@RequestParam(name = "image") MultipartFile file, @Validated @ModelAttribute(name = "entity") Phim phim,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("update", true);
			model.addAttribute("quocGias", quocGiaDAO.findAll());
			model.addAttribute("dienViens", dienVienDAO.findAllByTenVaiTro("Diễn Viên"));
			model.addAttribute("daoDiens", dienVienDAO.findAllByTenVaiTro("Đạo Diễn"));
			model.addAttribute("theLoais", theLoaiDAO.findAll());
			return "manager/phim/form";
		}

		if (!file.isEmpty()) {
			try {
				phim.setHinhAnh(uploadImageService.upload(file));
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "Có lỗi upload hình ảnh!");
				model.addAttribute("quocGias", quocGiaDAO.findAll());
				model.addAttribute("dienViens", dienVienDAO.findAllByTenVaiTro("Diễn Viên"));
				model.addAttribute("daoDiens", dienVienDAO.findAllByTenVaiTro("Đạo Diễn"));
				model.addAttribute("theLoais", theLoaiDAO.findAll());
				return "manager/phim/form";
			}
		}

		Phim savePhim = phimDAO.save(phim);
		thamGiaDAO.deleteAllByPhim(savePhim);

		if (dienViens.size() > 0 && !(dienViens.get(0) == null)) {
			for (DienVienDaoDien dv : dienViens) {
				thamGiaDAO.save(new ThamGia(dv, savePhim));
			}
		}
		return "redirect:/admin/phims";
	}

	@GetMapping(value = "/deletephim")
	public String doDelete(@RequestParam(name = "id") String id) {
		phimDAO.deleteById(id);
		return "redirect:/admin/phims";
	}
}
