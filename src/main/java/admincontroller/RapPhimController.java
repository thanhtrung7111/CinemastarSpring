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

import dao.RapPhimDAO;
import dao.ThanhPhoDAO;
import model.RapPhim;
import model.ThanhPho;

@Controller
@RequestMapping(value = "/admin")
public class RapPhimController {

	@Autowired
	RapPhimDAO rapPhimDAO;

	@Autowired
	ThanhPhoDAO thanhPhoDAO;

	@GetMapping(value = "/rapphims")
	public String getList(Model model) {
		List<RapPhim> list = rapPhimDAO.findAll();
		model.addAttribute("list", list);
		model.addAttribute("entity", new RapPhim());
		return "manager/rapphim/list";
	}

	@GetMapping(value = "/createrapphim")
	public String createView(Model model) {
		model.addAttribute("thanhPhos", thanhPhoDAO.findAll());
		model.addAttribute("entity", new RapPhim());
		return "manager/rapphim/form";
	}

	@PostMapping(value = "/createrapphim")
	public String doCreate(@Validated @ModelAttribute(name = "entity") RapPhim rapPhim, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("thanhPhos", thanhPhoDAO.findAll());
			return "manager/rapphim/form";
		}
		Optional<RapPhim> findItem = rapPhimDAO.findByTenRapPhim(rapPhim.getTenRapPhim());
		if (findItem.isPresent()) {
			model.addAttribute("message", "Tên quốc gia đã tồn tại");
			model.addAttribute("thanhPhos", thanhPhoDAO.findAll());
			return "manager/rapphim/form";
		}
		rapPhimDAO.save(rapPhim);
		return "redirect:/admin/rapphims";
	}

	@GetMapping(value = "/updaterapphim")
	public String updateView(@RequestParam(name = "id") Optional<String> id, Model model) {
		Optional<RapPhim> rapPhim = rapPhimDAO.findById(id.get());
		System.out.println(rapPhim.get().getThanhPho().getMaThanhPho());
		if (rapPhim.isPresent()) {
			List<ThanhPho> thanhPhos = thanhPhoDAO.findAll();
			System.out.println(thanhPhos.size());
			model.addAttribute("thanhPhos", thanhPhos);
			model.addAttribute("entity", rapPhim.get());
			model.addAttribute("update", true);
			return "manager/rapphim/form";
		}
		return "redirect:/admin/rapphims";
	}

	@PostMapping(value = "/updaterapphim")
	public String doUpdate(@Validated @ModelAttribute(name = "entity") RapPhim rapPhim, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			List<ThanhPho> thanhPhos = thanhPhoDAO.findAll();
			model.addAttribute("thanhPhos", thanhPhos);
			model.addAttribute("update", true);
			return "manager/rapphim/form";
		}
		rapPhimDAO.save(rapPhim);
		model.addAttribute("entity", new ThanhPho());
		return "redirect:/admin/rapphims";
	}

	@GetMapping(value = "/deleterapphim")
	public String doDelete(@RequestParam(name = "id") String id) {
		rapPhimDAO.deleteById(id);
		return "redirect:/admin/rapphims";
	}
}
