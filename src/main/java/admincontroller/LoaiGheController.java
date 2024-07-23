package admincontroller;

import java.util.List;
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

import dao.LoaiGheDAO;
import dao.ThanhPhoDAO;
import jakarta.persistence.metamodel.SetAttribute;
import model.LoaiGhe;
import model.ThanhPho;
import service.SessionService;

@Controller
@RequestMapping(value = "/admin")
public class LoaiGheController {

	@Autowired
	LoaiGheDAO loaiGheDAO;

	@Autowired
	SessionService session;

	Page<LoaiGhe> list;

	@GetMapping(value = "/loaighes")
	public String getList(Model model, @RequestParam("p") Optional<Integer> p) {
		session.setAttribute("type", "1");
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<LoaiGhe> list = loaiGheDAO.findAll(pageable);
		model.addAttribute("list", list);
		model.addAttribute("entity", new LoaiGhe());
		return "manager/loaighe/list";
	}

//	@PostMapping(value = "/loaighes")
//	public String getList1(Model model, @RequestParam("p") Optional<Integer> p,
//			@RequestParam("keywords") Optional<String> keywords, @RequestParam("min") Optional<Double> min,
//			@RequestParam("max") Optional<Double> max) {
//		String type = session.getAttribute("type");
//		Pageable pageable = PageRequest.of(p.orElse(0), 1);
//		if (type == null) {
//			String kwords = keywords.orElse(session.getAttribute("keywords"));
//			if (kwords == null) {
//				kwords = "";
//			}
//			session.setAttribute("keywords", kwords);
//			Page<LoaiGhe> list = loaiGheDAO.findAllByTenLoaiGheLike("%" + kwords + "%", pageable);
//			model.addAttribute("list", list);
//		} else {
//
//			Double minStr = min.orElse(session.getAttribute("min"));
//			Double maxStr = max.orElse(session.getAttribute("max"));
//			session.setAttribute("min", minStr);
//			session.setAttribute("max", maxStr);
//			System.out.println(minStr);
//			Page<LoaiGhe> list = loaiGheDAO.findByChiPhiBetween(minStr, maxStr, pageable);
//			model.addAttribute("list", list);
//		}
//		return "manager/loaighe/list";
//	}
	@PostMapping(value = "/loaighes")
	public String getList1(Model model, @RequestParam("p") Optional<Integer> p,
			@RequestParam("keywords") Optional<String> keywords, @RequestParam("min") Optional<Double> min,
			@RequestParam("max") Optional<Double> max) {
		String type = session.getAttribute("type");
		System.out.println(type);
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		if (type.equalsIgnoreCase("1")) {
			String kwords = keywords.orElse(session.getAttribute("keywords"));
			if (kwords == null) {
				kwords = "";
			}
			session.setAttribute("keywords", kwords);
			list = loaiGheDAO.findAllByTenLoaiGheLike("%" + kwords + "%", pageable);
		} else if (type.equalsIgnoreCase("2")) {
			Double minStr = min.orElse(session.getAttribute("min"));
			Double maxStr = max.orElse(session.getAttribute("max"));
			String kwords = keywords.orElse(session.getAttribute("keywords"));
			list = loaiGheDAO.findByTenLoaiGheLikeAndChiPhiBetween(kwords, minStr, maxStr, pageable);
		} else {
			Double minStr = min.orElse(session.getAttribute("min"));
			Double maxStr = max.orElse(session.getAttribute("max"));
			session.setAttribute("min", minStr);
			session.setAttribute("max", maxStr);
			System.out.println(minStr);
			list = loaiGheDAO.findByChiPhiBetween(minStr, maxStr, pageable);
		}
		model.addAttribute("list", list);
		return "manager/loaighe/list";
	}

//	@PostMapping(value = "/loaighes-search-price")
//	public String getList2(Model model, @RequestParam("p") Optional<Integer> p, @RequestParam("min") Double min,
//			@RequestParam("max") Double max) {
//		session.setAttribute("keywords", null);
//		session.setAttribute("type", "price");
//		session.setAttribute("min", min);
//		session.setAttribute("max", max);
//		Pageable pageable = PageRequest.of(p.orElse(0), 5);
//		Page<LoaiGhe> list = loaiGheDAO.findByChiPhiBetween(min, max, pageable);
//		model.addAttribute("list", list);
//		return "manager/loaighe/list";
//	}
	@PostMapping(value = "/loaighes-search-price")
	public String getList2(Model model, @RequestParam("p") Optional<Integer> p,
			@RequestParam(name = "min", defaultValue = "0") Double min,
			@RequestParam(name = "max", defaultValue = "0") Double max,
			@RequestParam(name = "keywords", defaultValue = "") String keywords) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		if (min != 0 || max != 0 && !keywords.equals("")) {
			session.setAttribute("type", "2");
			session.setAttribute("min", min);
			session.setAttribute("max", max);
			session.setAttribute("keywords", keywords);
			list = loaiGheDAO.findByTenLoaiGheLikeAndChiPhiBetween(keywords, min, max, pageable);
		} else if (min == 0 && max == 0) {
			session.setAttribute("type", "1");
			session.setAttribute("min", null);
			session.setAttribute("max", null);
			session.setAttribute("keywords", keywords);
			if (keywords == null) {
				keywords = "";
			}
			list = loaiGheDAO.findAllByTenLoaiGheLike("%" + keywords + "%", pageable);
		} else {
			session.setAttribute("type", "3");
			session.setAttribute("min", min);
			session.setAttribute("max", max);
			session.setAttribute("keywords", null);
			list = loaiGheDAO.findByChiPhiBetween(min, max, pageable);
			if (min == null || max == null) {
				System.out.println("error");
				return "manager.loaighe/list";
			}
		}
		model.addAttribute("list", list);
		return "manager/loaighe/list";
	}

	@PostMapping(value = "/loaighes-search-keywords")
	public String getList3(Model model, @RequestParam("p") Optional<Integer> p,
			@RequestParam("keywords") Optional<String> keywords) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		session.setAttribute("type", null);
		session.setAttribute("min", null);
		session.setAttribute("max", null);
		String kwords = keywords.orElse(session.getAttribute("keywords"));
		if (kwords == null) {
			kwords = "";
		}
		session.setAttribute("keywords", kwords);
		Page<LoaiGhe> list = loaiGheDAO.findAllByTenLoaiGheLike("%" + kwords + "%", pageable);
		model.addAttribute("list", list);
		return "manager/loaighe/list";
	}

	@GetMapping(value = "/createloaighe")
	public String createView(Model model) {
		model.addAttribute("entity", new LoaiGhe());
		return "manager/loaighe/form";
	}

	@PostMapping(value = "/createloaighe")
	public String doCreate(@Validated @ModelAttribute(name = "entity") LoaiGhe loaiGhe, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "manager/loaighe/form";
		}
		Optional<LoaiGhe> findItem = loaiGheDAO.findByTenLoaiGhe(loaiGhe.getTenLoaiGhe());
		if (findItem.isPresent()) {
			model.addAttribute("message", "Tên loại ghế đã tồn tại");
			return "manager/loaighe/form";
		}
		loaiGheDAO.save(loaiGhe);
		return "redirect:/admin/loaighes";
	}

	@GetMapping(value = "/updateloaighe")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<LoaiGhe> loaiGhe = loaiGheDAO.findById(id.get());
		if (loaiGhe.isPresent()) {
			model.addAttribute("entity", loaiGhe.get());
			model.addAttribute("update", true);
			return "manager/loaighe/form";
		}
		return "redirect:/admin/loaighes";
	}

	@PostMapping(value = "/updateloaighe")
	public String doUpdate(@Validated @ModelAttribute(name = "entity") LoaiGhe loaiGhe, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("update", true);
			return "manager/loaighe/form";
		}
		loaiGheDAO.save(loaiGhe);
		model.addAttribute("entity", new ThanhPho());
		return "redirect:/admin/loaighes";
	}

	@GetMapping(value = "/deleteloaighe")
	public String doDelete(@RequestParam(name = "id") String id) {
		loaiGheDAO.deleteById(id);
		return "redirect:/admin/loaighes";
	}

}
