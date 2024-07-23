package admincontroller;

import java.time.LocalTime;
import java.util.Calendar;
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

import dao.PhimDAO;
import dao.PhongPhimDAO;
import dao.SuatChieuDAO;
import dao.VeDAO;
import model.Ghe;
import model.SuatChieu;
import model.ThanhPho;
import model.Ve;

@Controller
@RequestMapping(value = "/admin")
public class SuatChieuController {

	@Autowired
	SuatChieuDAO suatChieuDAO;

	@Autowired
	PhongPhimDAO phongPhimDAO;

	@Autowired
	PhimDAO phimDAO;

	@Autowired
	VeDAO veDAO;

	@GetMapping(value = "/suatchieus")
	public String getList(Model model) {
		List<SuatChieu> list = suatChieuDAO.findAll();
		model.addAttribute("list", list);
		model.addAttribute("entity", new SuatChieu());
		return "manager/suatchieu/list";
	}

	@GetMapping(value = "/createsuatchieu")
	public String createView(Model model) {
		model.addAttribute("phongPhims", phongPhimDAO.findAll());
		model.addAttribute("phims", phimDAO.findAll());
		model.addAttribute("entity", new SuatChieu());
		return "manager/suatchieu/form";
	}

	@PostMapping(value = "/createsuatchieu")
	public String doCreate(@Validated @ModelAttribute(name = "entity") SuatChieu suatChieu, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("phongPhims", phongPhimDAO.findAll());
			model.addAttribute("phims", phimDAO.findAll());
			return "manager/suatchieu/form";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(suatChieu.getThoiGianChieu());
		cal.add(Calendar.MINUTE, phimDAO.findById(suatChieu.getPhim().getMaPhim()).get().getThoiLuong());
		suatChieu.setThoiGianKetThuc(cal.getTime());
		List<SuatChieu> findItem = suatChieuDAO.findPhongPhimExist(suatChieu.getPhongPhim(), suatChieu.getNgayChieu(),
				suatChieu.getThoiGianChieu(), suatChieu.getThoiGianKetThuc());
		if (findItem.size() >= 1) {
			model.addAttribute("message", "Thời gian chiếu đã tồn tại");
			model.addAttribute("phongPhims", phongPhimDAO.findAll());
			model.addAttribute("phims", phimDAO.findAll());
			return "manager/suatchieu/form";
		}
		SuatChieu sc = suatChieuDAO.save(suatChieu);
		if (sc != null) {
			for (Ghe ghe : phongPhimDAO.findById(sc.getPhongPhim().getMaPhongPhim()).get().getGhes()) {
				Ve ve = new Ve();
				ve.setSuatChieu(sc);
				ve.setGhe(ghe);
				ve.setTongTien(ghe.getLoaiGhe().getChiPhi());
				veDAO.save(ve);
			}
		}
		return "redirect:/admin/suatchieus";
	}

	@GetMapping(value = "/updatesuatchieu")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<SuatChieu> suatChieu = suatChieuDAO.findById(id.get());

		if (suatChieu.isPresent()) {
			model.addAttribute("phongPhims", phongPhimDAO.findAll());
			model.addAttribute("phims", phimDAO.findAll());
			model.addAttribute("entity", suatChieu.get());
			model.addAttribute("update", true);
			return "manager/suatchieu/form";
		}
		return "redirect:/admin/suatchieus";
	}

	@PostMapping(value = "/updatesuatchieu")
	public String doUpdate(@Validated @ModelAttribute(name = "entity") SuatChieu suatChieu, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("phongPhims", phongPhimDAO.findAll());
			model.addAttribute("phims", phimDAO.findAll());
			model.addAttribute("update", true);
			return "manager/suatchieu/form";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(suatChieu.getThoiGianChieu());
		cal.add(Calendar.MINUTE, phimDAO.findById(suatChieu.getPhim().getMaPhim()).get().getThoiLuong());
		suatChieu.setThoiGianKetThuc(cal.getTime());
		List<SuatChieu> findItem = suatChieuDAO.findPhongPhimExist(suatChieu.getPhongPhim(), suatChieu.getNgayChieu(),
				suatChieu.getThoiGianChieu(), suatChieu.getThoiGianKetThuc());
		if (findItem.size() >= 2) {
			model.addAttribute("message", "Thời gian chiếu đã tồn tại");
			model.addAttribute("phongPhims", phongPhimDAO.findAll());
			model.addAttribute("phims", phimDAO.findAll());
			model.addAttribute("update", true);
			return "manager/suatchieu/form";
		}
		suatChieuDAO.save(suatChieu);
		return "redirect:/admin/suatchieus";
	}

	@GetMapping(value = "/deletesuatchieu")
	public String doDelete(@RequestParam(name = "id") String id) {
		suatChieuDAO.deleteById(id);
		return "redirect:/admin/suatchieus";
	}
}
