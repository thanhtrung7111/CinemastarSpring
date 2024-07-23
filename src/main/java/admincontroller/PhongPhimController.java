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

import dao.GheDAO;
import dao.HangGheDAO;
import dao.LoaiGheDAO;
import dao.PhongPhimDAO;
import dao.RapPhimDAO;
import dao.ThanhPhoDAO;
import model.Ghe;
import model.HangGhe;
import model.LoaiGhe;
import model.PhongPhim;
import model.ThanhPho;

@Controller
@RequestMapping(value = "/admin")
public class PhongPhimController {

	@Autowired
	PhongPhimDAO phongPhimDAO;

	@Autowired
	RapPhimDAO rapPhimDAO;

	@Autowired
	GheDAO gheDAO;

	@Autowired
	HangGheDAO hangGheDAO;

	@Autowired
	LoaiGheDAO loaiGheDAO;

	@GetMapping(value = "/phongphims")
	public String getList(Model model) {
		List<PhongPhim> list = phongPhimDAO.findAll();
		model.addAttribute("list", list);
		model.addAttribute("entity", new PhongPhim());
		return "manager/phongphim/list";
	}

	@GetMapping(value = "/createphongphim")
	public String createView(Model model) {
		model.addAttribute("entity", new PhongPhim());
		model.addAttribute("rapPhims", rapPhimDAO.findAll());
		model.addAttribute("loaiGhes", loaiGheDAO.findAll());
		return "manager/phongphim/form";
	}

	@PostMapping(value = "/createphongphim")
	public String doCreate(@RequestParam(name = "loaiGhe") String maLoaiGhe,
			@Validated @ModelAttribute(name = "entity") PhongPhim phongPhim, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("rapPhims", rapPhimDAO.findAll());
			return "manager/phongphim/form";
		}
		Optional<PhongPhim> findItem = phongPhimDAO.findByTenPhongPhimAndRapPhim(phongPhim.getTenPhongPhim(),
				phongPhim.getRapPhim());
		if (findItem.isPresent()) {
			model.addAttribute("rapPhims", rapPhimDAO.findAll());
			model.addAttribute("message", "Tên phòng phim đã tồn tại");
			return "manager/phongphim/form";
		}
		PhongPhim savePhong = phongPhimDAO.save(phongPhim);
		if (savePhong != null) {
			Optional<LoaiGhe> loaiGhe = loaiGheDAO.findById(maLoaiGhe);
			List<HangGhe> list = hangGheDAO.findAll();
			for (HangGhe hangGhe : list) {
				for (int i = 1; i <= 10; i++) {
					Ghe ghe = new Ghe();
					ghe.setTenGhe(hangGhe.getTenHangGhe() + i);
					ghe.setHangGhe(hangGhe);
					ghe.setLoaiGhe(loaiGhe.get());
					ghe.setPhongPhim(savePhong);
					gheDAO.save(ghe);
				}
			}
		}
		return "redirect:/admin/phongphims";
	}

	@GetMapping(value = "/updatephongphim")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<PhongPhim> phongPhim = phongPhimDAO.findById(id.get());
		if (phongPhim.isPresent()) {
			model.addAttribute("entity", phongPhim.get());
			model.addAttribute("rapPhims", rapPhimDAO.findAll());
			model.addAttribute("hangGhes", hangGheDAO.findAllByPhongPhim(phongPhim.get()));
			model.addAttribute("loaiGhes", loaiGheDAO.findAll());
			model.addAttribute("loaiGhe", phongPhim.get().getGhes().get(0).getLoaiGhe().getMaLoaiGhe());
			model.addAttribute("update", true);
			return "manager/phongphim/form";
		}
		return "redirect:/admin/phongphims";
	}

	@PostMapping(value = "/updatephongphim")
	public String doUpdate(@RequestParam(name = "loaiGhe") String maLoaiGhe,
			@Validated @ModelAttribute(name = "entity") PhongPhim phongPhim, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("update", true);
			model.addAttribute("rapPhims", rapPhimDAO.findAll());
			return "manager/phongphim/form";
		}
		PhongPhim savePhong = phongPhimDAO.save(phongPhim);
		if (savePhong != null) {
			Optional<LoaiGhe> loaiGhe = loaiGheDAO.findById(maLoaiGhe);
			List<Ghe> ghes = gheDAO.findByAllByPhongPhim(savePhong);
			for (Ghe ghe : ghes) {
				ghe.setLoaiGhe(loaiGhe.get());
				gheDAO.save(ghe);
			}
		}
		phongPhimDAO.save(phongPhim);
		return "redirect:/admin/phongphims";
	}

	@GetMapping(value = "/deletephongphim")
	public String doDelete(@RequestParam(name = "id") String id) {
		phongPhimDAO.deleteById(id);
		return "redirect:/admin/phongphims";
	}
}
