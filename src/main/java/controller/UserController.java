package controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import dao.ApDungKhuyenMaiDAO;
import dao.ChiTietComboDAO;
import dao.ComboDoAnDAO;
import dao.DienVienDAO;
import dao.HangGheDAO;
import dao.HoaDonDAO;
import dao.KhuyenMaiDAO;
import dao.PhimDAO;
import dao.RapPhimDAO;
import dao.SuatChieuDAO;
import dao.TaiKhoanDAO;
import dao.ThanhPhoDAO;
import dao.VeDAO;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import model.ApDungKhuyenMai;
import model.ApDungKhuyenMaiID;
import model.ChiTietCombo;
import model.ChiTietComboID;
import model.ComboDoAn;
import model.DienVienDaoDien;
import model.HangGhe;
import model.HoaDon;
import model.KhuyenMai;
import model.Phim;
import model.RapPhim;
import model.SuatChieu;
import model.TaiKhoan;
import model.ThanhPho;
import model.Ve;
import service.MailService;
import service.SessionService;
import vnpay.vnpayQuery;

@Controller
public class UserController {

	@Autowired
	PhimDAO phimDAO;

	@Autowired
	KhuyenMaiDAO khuyenMaiDAO;

	@Autowired
	DienVienDAO dienVienDAO;

	@Autowired
	ThanhPhoDAO thanhPhoDAO;

	@Autowired
	SuatChieuDAO suatChieuDAO;

	@Autowired
	RapPhimDAO rapPhimDAO;

	@Autowired
	HttpServletRequest httpServletRequest;

	@Autowired
	VeDAO veDAO;

	@Autowired
	HangGheDAO hangGheDAO;

	@Autowired
	ComboDoAnDAO comboDoAnDAO;

	@Autowired
	ChiTietComboDAO chiTietComboDAO;

	@Autowired
	HoaDonDAO hoaDonDAO;

	@Autowired
	ApDungKhuyenMaiDAO apDungKhuyenMaiDAO;

	@Autowired
	TaiKhoanDAO taiKhoanDAO;

	@Autowired
	SessionService sessionService;

	@Autowired
	MailService mailService;

	@GetMapping(value = "/home")
	public String login(Model model) {
		Pageable paging1 = PageRequest.of(0, 4);
		Page<Phim> pageResult = phimDAO.findAllCurrentShowToDay(paging1);
		model.addAttribute("banner", pageResult.getContent());
		model.addAttribute("khuyenMais", khuyenMaiDAO.findAllByPageCurrentDate(paging1).getContent());
		return "user/index";
	}

	@GetMapping(value = "/phims")
	public String phims(@RequestParam(name = "p") Optional<Integer> p, Model model) {
		Pageable paging = PageRequest.of(0, 4);
		System.out.println(p);
		Page<Phim> list = phimDAO.findAllCurrentShowToDay(PageRequest.of(p.orElse(0), 4));
		model.addAttribute("phims", list);
		model.addAttribute("khuyenMais", khuyenMaiDAO.findAllByPageCurrentDate(paging).getContent());
		return "user/phims";
	}

	@PostMapping(value = "/phims")
	public String phimsPost(@RequestParam(name = "p") Optional<Integer> p, Model model) {
		Pageable paging = PageRequest.of(0, 4);
		System.out.println(p);
		Page<Phim> list = phimDAO.findAllCurrentShowToDay(PageRequest.of(p.orElse(0), 4));
		model.addAttribute("phims", list);
		model.addAttribute("khuyenMais", khuyenMaiDAO.findAllByPageCurrentDate(paging).getContent());
		return "user/phims";
	}

	@GetMapping(value = "/user/muave")
	public String muaVes(@RequestParam(name = "id") Optional<String> maPhim, Model model) {
		sessionService.removeAttribute("suatChieu");
		if (maPhim.isEmpty()) {
			return "redirect:/phims";

		}
		Optional<Phim> phim = phimDAO.findById(maPhim.get());
		if (phim.isEmpty()) {
			return "redirect:/phims";
		}
		List<RapPhim> listRap = rapPhimDAO.findCurrentShowPhim(phim.get());
		HashMap<RapPhim, List<SuatChieu>> mapRapPhim = new HashMap<RapPhim, List<SuatChieu>>();
		for (RapPhim rapPhim : listRap) {
			mapRapPhim.put(rapPhim, suatChieuDAO.findAllCurrentShowByPhimAndRapPhim(rapPhim, phim.get()));
		}
		model.addAttribute("mapRapPhim", mapRapPhim);
		sessionService.setAttribute("phim", phim);
		return "user/chonmuave";
	}

	@GetMapping(value = "/user/chonphimchieu")
	public String chonPhimChieu(@RequestParam(name = "maPhim") Optional<String> maPhim,
			@RequestParam(name = "maSuatChieu") Optional<String> maSuatChieu,
			@RequestParam("maThanhPho") Optional<String> maThanhPho) {
		if (maPhim.isEmpty() || maSuatChieu.isEmpty() || maThanhPho.isEmpty()) {

			return "redirect:/phims";
		}
		sessionService.setAttribute("thanhPho", thanhPhoDAO.findById(maThanhPho.get()));
		sessionService.setAttribute("suatChieu", suatChieuDAO.findById(maSuatChieu.get()));
		sessionService.setAttribute("phim", phimDAO.findById(maPhim.get()));
		return "redirect:/user/chonghe";
	}

	@GetMapping(value = "/phimchieu")
	public String phimChieu(@RequestParam(name = "id") String id, Model model) {
		Optional<Phim> phim = phimDAO.findById(id);
		Pageable paging = PageRequest.of(0, 4);
		if (phim.isEmpty()) {
			return "redirect:/phims";
		}
		List<RapPhim> listRap = rapPhimDAO.findCurrentShowPhim(phim.get());
		HashMap<RapPhim, List<SuatChieu>> mapRapPhim = new HashMap<RapPhim, List<SuatChieu>>();

		for (RapPhim rapPhim : listRap) {
			mapRapPhim.put(rapPhim, suatChieuDAO.findAllCurrentShowByPhimAndRapPhim(rapPhim, phim.get()));
		}
		model.addAttribute("mapRapPhim", mapRapPhim);
		model.addAttribute("phimCurrentShows", phimDAO.findAllCurrentShowToDay(paging).getContent());
		model.addAttribute("phim", phim.get());
		return "user/phimchieu";
	}

	@GetMapping(value = "/dienviens")
	public String dienViens(Model model) {
		Pageable paging = PageRequest.of(0, 4);
		Page<DienVienDaoDien> list = dienVienDAO.findAllPageByTenVaiTro("Diễn Viên", PageRequest.of(0, 4));
		model.addAttribute("list", list);
		model.addAttribute("list", list);
		model.addAttribute("type", "Diễn Viên");
		model.addAttribute("khuyenMais", khuyenMaiDAO.findAllByPageCurrentDate(paging).getContent());
		model.addAttribute("phimCurrentShows", phimDAO.findAllCurrentShowToDay(paging).getContent());
		return "user/dienviens";
	}

	@PostMapping(value = "/dienviens")
	public String dienViens(Model model, @RequestParam(name = "p") Optional<Integer> p) {
		Pageable paging = PageRequest.of(0, 4);
		Page<DienVienDaoDien> list = dienVienDAO.findAllPageByTenVaiTro("Diễn Viên", PageRequest.of(p.orElse(0), 4));
		model.addAttribute("list", list);
		model.addAttribute("type", "Diễn Viên");
		model.addAttribute("khuyenMais", khuyenMaiDAO.findAllByPageCurrentDate(paging).getContent());
		model.addAttribute("phimCurrentShows", phimDAO.findAllCurrentShowToDay(paging).getContent());
		return "user/dienviens";
	}

	@GetMapping(value = "/daodiens")
	public String daoDiens(Model model) {
		Pageable paging = PageRequest.of(0, 4);
		Page<DienVienDaoDien> list = dienVienDAO.findAllPageByTenVaiTro("Đạo Diễn", PageRequest.of(0, 4));
		model.addAttribute("list", list);
		model.addAttribute("type", "Đạo diễn");
		model.addAttribute("khuyenMais", khuyenMaiDAO.findAllByPageCurrentDate(paging).getContent());
		model.addAttribute("phimCurrentShows", phimDAO.findAllCurrentShowToDay(paging).getContent());
		return "user/dienviens";
	}

	@PostMapping(value = "/daodiens")
	public String daoDiens(Model model, @RequestParam(name = "p") Optional<Integer> p) {
		Pageable paging = PageRequest.of(0, 4);
		Page<DienVienDaoDien> list = dienVienDAO.findAllPageByTenVaiTro("Đạo Diễn", PageRequest.of(p.orElse(0), 4));
		model.addAttribute("list", list);
		model.addAttribute("type", "Đạo diễn");
		model.addAttribute("khuyenMais", khuyenMaiDAO.findAllByPageCurrentDate(paging).getContent());
		model.addAttribute("phimCurrentShows", phimDAO.findAllCurrentShowToDay(paging).getContent());
		return "user/dienviens";
	}

	@GetMapping(value = "/dienvien")
	public String dienVien(@RequestParam(name = "id") String id, Model model) {
		Optional<DienVienDaoDien> entity = dienVienDAO.findById(id);
		if (entity.isPresent()) {
			Pageable paging = PageRequest.of(0, 4);
			DienVienDaoDien dv = entity.get();
			dv.setLuotXem(entity.get().getLuotXem() + 1);
			dienVienDAO.save(dv);
			model.addAttribute("entity", dv);
			model.addAttribute("phimCurrentShows", phimDAO.findAllCurrentShowToDay(paging).getContent());
			return "user/dienvien";
		}
		return "redirect:/dienviens";
	}

	@GetMapping(value = "/user/chonthanhpho")
	public String chonThanhPho(Model model) {
		sessionService.removeAttribute("thanhPho");
		sessionService.removeAttribute("phim");
		sessionService.removeAttribute("suatChieu");
		model.addAttribute("thanhPhos", thanhPhoDAO.findAll());
		return "user/muave";
	}

	@PostMapping(value = "/user/chonthanhpho")
	public String doChonThanhPho(@RequestParam(name = "id") String maThanhPho) {
		System.out.println(maThanhPho);
		Optional<ThanhPho> thanhPho = thanhPhoDAO.findById(maThanhPho);
		if (thanhPho.isEmpty() || maThanhPho == null) {
			return "redirect:/chonthanhpho";
		}
		sessionService.setAttribute("thanhPho", thanhPho);
		return "redirect:/user/chonphim";
	}

	@GetMapping(value = "/user/chonphim")
	public String chonPhim(Model model, @SessionAttribute("thanhPho") Optional<ThanhPho> thanhPho) {
		if (thanhPho.isEmpty()) {
			return "redirect:/user/chonthanhpho";
		}
		sessionService.removeAttribute("phim");
		model.addAttribute("phims", phimDAO.findAllCurrentShow(thanhPho.get()));
		model.addAttribute("thanhPhos", thanhPhoDAO.findAll());
		return "user/chonphim";
	}

	@PostMapping(value = "/user/chonphim")
	public String doChonPhim(Model model, @RequestParam("maPhim") Optional<String> maPhim) {
		if (maPhim.isEmpty()) {
			return "redirect:/user/chonsuat";
		}
		Optional<Phim> phim = phimDAO.findById(maPhim.get());
		if (phim.isPresent()) {
			sessionService.setAttribute("phim", phim);
			return "redirect:/user/chonsuat";
		}
		return "redirect:/user/chonphim";
	}

	@GetMapping(value = "/user/chonsuat")
	public String chonSuat(Model model, @SessionAttribute(name = "thanhPho") Optional<ThanhPho> thanhPho,
			@SessionAttribute(name = "phim") Optional<Phim> phim) {
		if (thanhPho.isEmpty()) {
			return "redirect:/user/chonthanhpho";
		}

		if (phim.isEmpty()) {
			return "redirect:/user/chonphim";
		}
		List<RapPhim> listRapPhim = rapPhimDAO.findCurrentShow(phim.get(), thanhPho.get());
		HashMap<RapPhim, List<SuatChieu>> rapPhims = new HashMap<RapPhim, List<SuatChieu>>();
		for (RapPhim rapPhim : listRapPhim) {
			rapPhims.put(rapPhim, suatChieuDAO.findAllCurrentShowByPhimAndRapPhim(rapPhim, phim.get()));
		}
		sessionService.removeAttribute("suatChieu");
		model.addAttribute("phims", phimDAO.findAllCurrentShow(thanhPho.get()));
		model.addAttribute("rapPhims", rapPhims);
		model.addAttribute("thanhPhos", thanhPhoDAO.findAll());
		return "user/chonsuat";
	}

	@PostMapping(value = "/user/chonsuat")
	public String chonSuat(Model model, @RequestParam(name = "id") Optional<String> id) {
		if (id.isEmpty()) {
			return "redirect:/user/chonsuat";
		}
		Optional<SuatChieu> suatChieu = suatChieuDAO.findById(id.get());
		if (suatChieu.isEmpty()) {
			return "redirect:/user/chonsuat";
		}
		sessionService.setAttribute("suatChieu", suatChieu);
		return "redirect:/user/chonghe";
	}

	@GetMapping(value = "/user/chonghe")
	public String chonGhe(Model model, @SessionAttribute(name = "suatChieu") Optional<SuatChieu> suatChieu,
			@SessionAttribute(name = "phim") Optional<Phim> phim) {
		sessionService.removeAttribute("tongTien");
		if (suatChieu.isEmpty()) {
			return "redirect:/user/chonsuat";
		}
		List<HangGhe> listHangGhe = hangGheDAO.findAll(Sort.by(Sort.Direction.ASC, "tenHangGhe"));
		System.out.println(listHangGhe.get(listHangGhe.size() - 1).getTenHangGhe());
		HashMap<HangGhe, List<Ve>> mapHangGhe = new HashMap<HangGhe, List<Ve>>();
		for (HangGhe hanGhe : listHangGhe) {
			mapHangGhe.put(hanGhe, veDAO.findAllBySuatChieu(suatChieu.get(), hanGhe));
		}

		List<Entry<HangGhe, List<Ve>>> list1 = new ArrayList<Map.Entry<HangGhe, List<Ve>>>(mapHangGhe.entrySet());

		Comparator<Entry<HangGhe, List<Ve>>> keyComparator = new Comparator<Map.Entry<HangGhe, List<Ve>>>() {

			@Override
			public int compare(Entry<HangGhe, List<Ve>> o1, Entry<HangGhe, List<Ve>> o2) {

				return o1.getKey().getTenHangGhe().compareTo(o2.getKey().getTenHangGhe());
			}
		};

		Collections.sort(list1, keyComparator);

		Map<HangGhe, List<Ve>> sortedMap = new LinkedHashMap<HangGhe, List<Ve>>();

		for (Map.Entry<HangGhe, List<Ve>> entry : list1) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		model.addAttribute("suatChieus", suatChieuDAO
				.findAllCurrentShowByPhimAndRapPhim(suatChieu.get().getPhongPhim().getRapPhim(), phim.get()));
		model.addAttribute("hangGhes", sortedMap);
		return "user/chonghe";
	}

	@PostMapping(value = "/user/chonghe")
	public String chonGhe(Model model, @RequestParam("ves") Optional<List<String>> ves) {
		if (ves.isEmpty()) {
			return "redirect:/user/chonghe";
		}
		List<Ve> listVe = new ArrayList<Ve>();
		Double tongTien = 0.0;
		for (String item : ves.get()) {
			Optional<Ve> ve = veDAO.findById(item);
			listVe.add(ve.get());
		}
		sessionService.setAttribute("ves", listVe);
		setTongTien();
		return "redirect:/user/combo";
	}

	@GetMapping(value = "/user/combo")
	public String combo(Model model) {
		@SuppressWarnings("unchecked")
		HashMap<ComboDoAn, Integer> mapCombo = (HashMap<ComboDoAn, Integer>) sessionService.getAttribute("mapCombo");
		if (mapCombo == null) {
			System.out.println("true");
			mapCombo = new HashMap<ComboDoAn, Integer>();
		} else {
			System.out.println("false");
		}
		sessionService.setAttribute("mapCombo", mapCombo);
		model.addAttribute("combos", comboDoAnDAO.findAll());
		return "user/combo";
	}

	@PostMapping(value = "/user/increment")
	public String incrementCombo(@RequestParam(name = "id") Optional<String> id) {
		@SuppressWarnings("unchecked")
		HashMap<ComboDoAn, Integer> mapCombo = (HashMap<ComboDoAn, Integer>) sessionService.getAttribute("mapCombo");
		Optional<ComboDoAn> combo = comboDoAnDAO.findById(id.get());

		mapCombo.computeIfPresent(combo.get(), (k, v) -> v + 1);
		mapCombo.putIfAbsent(combo.get(), 1);
		sessionService.setAttribute("mapCombo", mapCombo);
		setTongTien();
		return "redirect:/user/combo";

	}

	@PostMapping(value = "/user/decrement")
	public String decrementCombo(@RequestParam(name = "id") Optional<String> id) {
		@SuppressWarnings("unchecked")
		HashMap<ComboDoAn, Integer> mapCombo = (HashMap<ComboDoAn, Integer>) sessionService.getAttribute("mapCombo");
		Optional<ComboDoAn> combo = comboDoAnDAO.findById(id.get());
		if (mapCombo.get(combo.get()) > 0 && mapCombo.get(combo.get()) != 1) {
			mapCombo.computeIfPresent(combo.get(), (k, v) -> v - 1);
		} else {
			if (mapCombo.containsKey(combo.get())) {
				mapCombo.remove(combo.get());
			}
		}
		sessionService.setAttribute("mapCombo", mapCombo);
		setTongTien();
		return "redirect:/user/combo";

	}

	@PostMapping(value = "/user/changeamout")
	public String changeAmount(@RequestParam(name = "id") Optional<String> id,
			@RequestParam(name = "soluong") Integer soLuong) {
		@SuppressWarnings("unchecked")
		HashMap<ComboDoAn, Integer> mapCombo = (HashMap<ComboDoAn, Integer>) sessionService.getAttribute("mapCombo");
		Optional<ComboDoAn> combo = comboDoAnDAO.findById(id.get());
		if (mapCombo.containsKey(combo.get())) {
			mapCombo.computeIfPresent(combo.get(), (k, v) -> soLuong);
		} else {
			mapCombo.put(combo.get(), soLuong);
		}

		System.out.println(mapCombo.get(combo.get()));
		sessionService.setAttribute("mapCombo", mapCombo);
		return "redirect:/user/combo";

	}

	@GetMapping(value = "/user/thanhtoan")
	public String thanhToan(Model model) {
		model.addAttribute("khuyenMais", khuyenMaiDAO.findAllByCurrentDate());
		return "user/thanhtoan";
	}

	@PostMapping(value = "/user/thanhtoan")
	public String doThanhToan(Model model, @RequestParam(name = "thanhToan", defaultValue = "") String thanhToan) {
		if (thanhToan == null || thanhToan.isEmpty()) {
			model.addAttribute("khuyenMais", khuyenMaiDAO.findAllByCurrentDate());
			model.addAttribute("message", "Chọn phương thức thanh toán!");
			return "user/thanhtoan";
		}
		HoaDon hoaDon = new HoaDon();
		@SuppressWarnings("unchecked")
		HashMap<ComboDoAn, Integer> mapCombo = (HashMap<ComboDoAn, Integer>) sessionService.getAttribute("mapCombo");

		@SuppressWarnings("unchecked")
		List<Ve> ves = (List<Ve>) sessionService.getAttribute("ves");

		@SuppressWarnings("unchecked")
		Optional<KhuyenMai> khuyenMai = (Optional<KhuyenMai>) sessionService.getAttribute("khuyenMai");

		String url = "";
		try {
			url = vnpayQuery.getURL(httpServletRequest);
			System.out.println(url);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		Double tongTien = (Double) sessionService.getAttribute("tongTien");
		hoaDon.setTongTien(tongTien);
		hoaDon.setNgayLapHD(new Date());
		hoaDon.setTaiKhoan((TaiKhoan) sessionService.getAttribute("taiKhoan"));
		hoaDon.setNhanVien(null);
		hoaDon.setTrangThai(false);
		hoaDon.setVes(ves);
		hoaDon.setCode(vnpayQuery.keyvnp_TxnRef);
		HoaDon saveHoaDon = hoaDonDAO.save(hoaDon);
		if (saveHoaDon != null) {
			for (Ve ve : ves) {
				ve.setHoaDon(saveHoaDon);
				veDAO.save(ve);
			}

			if (khuyenMai != null) {
				apDungKhuyenMaiDAO.save(new ApDungKhuyenMai(true, new ApDungKhuyenMaiID(khuyenMai.get(), saveHoaDon)));
			}

			for (Map.Entry<ComboDoAn, Integer> set : mapCombo.entrySet()) {
				chiTietComboDAO.save(new ChiTietCombo(set.getValue(), set.getValue() * set.getKey().getGiaCombo(),
						new ChiTietComboID(hoaDon, set.getKey())));
			}
		}

		sessionService.removeAttribute("ves");
		sessionService.removeAttribute("khuyenMai");
		sessionService.removeAttribute("mapCombo");
		sessionService.removeAttribute("tongTien");
		sessionService.setAttribute("url", url);
		return "redirect:" + url;
	}

	@GetMapping(value = "/user/confirmhd")
	public String confirm(@RequestParam(name = "vnp_ResponseCode") Optional<String> responseCode,
			@RequestParam(name = "vnp_TxnRef") Optional<String> ref, Model model) throws MessagingException {
		if (sessionService.getAttribute("url") != null) {
			if (!responseCode.isEmpty() && !ref.isEmpty()) {
				if (responseCode.get().equals("00")) {
					HoaDon hd = hoaDonDAO.findByCode(ref.get()).get();
					hd.setTrangThai(true);
					hoaDonDAO.save(hd);
					sessionService.removeAttribute("url");
					mailService.sendMail(hd.getTaiKhoan().getEmail(), "Mã hóa đơn mua vé rạp phim Cinemastar",
							"Mã hóa đơn của bạn:" + hd.getCode());
					model.addAttribute("status", true);
				} else {
					model.addAttribute("status", false);
				}
			} else {
				model.addAttribute("status", false);
			}
			return "user/confirm";
		}
		return "redirect:/user/thanhtoan";
	}

	@PostMapping(value = "/user/apdungkhuyenmai")
	public String apDungKhuyenMai(Model model, @RequestParam(name = "khuyenMai") String khuyenMai) {
		Optional<KhuyenMai> km = khuyenMaiDAO.findById(khuyenMai);
		sessionService.setAttribute("khuyenMai", km);
		setTongTien();
		return "redirect:/user/thanhtoan";
	}

	@GetMapping(value = "/theloaiphims")
	public String theLoaiPhims(Model model) {
		Page<Phim> phims = phimDAO.findAllPage(PageRequest.of(0, 4));
		model.addAttribute("phims", phims);
		Pageable paging = PageRequest.of(0, 4);

//		System.out.println(phimDAO.findAllCurrentShow().size());
		model.addAttribute("phimCurrentShows", phimDAO.findAllCurrentShowToDay(paging).getContent());
		model.addAttribute("khuyenMais", khuyenMaiDAO.findAllByPageCurrentDate(paging).getContent());
		return "user/theloaiphims";
	}

	@PostMapping(value = "/theloaiphims")
	public String theLoaiPhims(@RequestParam(name = "p") Optional<Integer> p, Model model) {
		Page<Phim> phims = phimDAO.findAllPage(PageRequest.of(p.orElse(0), 4));
		model.addAttribute("phims", phims);
		Pageable paging = PageRequest.of(0, 4);

//		System.out.println(phimDAO.findAllCurrentShow().size());
		model.addAttribute("phimCurrentShows", phimDAO.findAllCurrentShowToDay(paging).getContent());
		model.addAttribute("khuyenMais", khuyenMaiDAO.findAllByPageCurrentDate(paging).getContent());
		return "user/theloaiphims";
	}

	@GetMapping(value = "/theloaiphim")
	public String theLoaiPhim(@RequestParam(name = "id") String id, Model model) {
		Optional<Phim> phim = phimDAO.findById(id);
		if (phim.isPresent()) {
			Phim savePhim = phim.get();
			savePhim.setLuotXem(phim.get().getLuotXem() + 1);
			phimDAO.save(savePhim);
			Pageable paging = PageRequest.of(0, 4);
			model.addAttribute("phim", savePhim);
			model.addAttribute("khuyenMais", khuyenMaiDAO.findAllByPageCurrentDate(paging).getContent());
			model.addAttribute("phimCurrentShows", phimDAO.findAllCurrentShowToDay(paging).getContent());
			return "user/theloaiphim";
		} else {
			return "redirect:/theloaiphims";
		}
	}

	public void setTongTien() {
		@SuppressWarnings("unchecked")
		HashMap<ComboDoAn, Integer> mapCombo = (HashMap<ComboDoAn, Integer>) sessionService.getAttribute("mapCombo");

		@SuppressWarnings("unchecked")
		List<Ve> ves = (List<Ve>) sessionService.getAttribute("ves");

		@SuppressWarnings("unchecked")
		Optional<KhuyenMai> khuyenMai = (Optional<KhuyenMai>) sessionService.getAttribute("khuyenMai");

		double tongTien = 0.0;

		if (ves != null) {
			for (Ve ve : ves) {
				tongTien += ve.getTongTien();
			}
		}

		if (mapCombo != null) {

			for (Map.Entry<ComboDoAn, Integer> item : mapCombo.entrySet()) {
				tongTien += item.getKey().getGiaCombo() * item.getValue();
			}
		}

		if (khuyenMai != null) {
			tongTien = tongTien - tongTien * khuyenMai.get().getPhanTramGiam() / 100;
		}

		sessionService.setAttribute("tongTien", tongTien);
	}

	@PostMapping(value = "/login")
	public String doLogin(@RequestParam(value = "email") Optional<String> email,
			@RequestParam(name = "matKhau") Optional<String> matKhau, Model model) {
		if (email.isEmpty() || matKhau.isEmpty()) {
			sessionService.setAttribute("errorLogin", "Email hoặc password không được để trống");
			return "redirect:/home";
		}
		Optional<TaiKhoan> taiKhoan = taiKhoanDAO.findByEmailOrSoDienThoai(email.get(), email.get(), email.get());
		if (taiKhoan.isEmpty() || !taiKhoan.get().getMatKhau().equals(matKhau.get())) {
			sessionService.removeAttribute("errorRegister");
			sessionService.setAttribute("errorLogin", "Email hoặc password không đúng!");
		} else {
			sessionService.setAttribute("taiKhoan", taiKhoan.get());
			sessionService.removeAttribute("errorLogin");
		}

		return "redirect:/home";
	}

	@GetMapping(value = "/logout")
	public String doLogout(@SessionAttribute(value = "taiKhoan") TaiKhoan taiKhoan) {
		if (taiKhoan != null) {
			sessionService.removeAttribute("taiKhoan");
		}
		return "redirect:/home";
	}

	@PostMapping(value = "/register")
	public String doLogin(TaiKhoan taiKhoan) throws MessagingException {
		Optional<TaiKhoan> findTaiKhoan = taiKhoanDAO.findByEmailOrSoDienThoai(taiKhoan.getSoDienThoai(),
				taiKhoan.getEmail(), taiKhoan.getMaTaiKhoan());
		System.out.println(findTaiKhoan.isEmpty());
		if (findTaiKhoan.isPresent()) {
			sessionService.removeAttribute("errorLogin");
			sessionService.setAttribute("errorRegister", "Email hoặc số điện thoại đã tồn tại!");
			sessionService.setAttribute("taiKhoanRegister", taiKhoan);
		} else {
			taiKhoan.setToken(taiKhoan.getMaTaiKhoan() + UUID.randomUUID().toString());
			TaiKhoan saveTaiKhoan = taiKhoanDAO.save(taiKhoan);
			sessionService.removeAttribute("errorRegister");
			sessionService.removeAttribute("taiKhoanRegister");
			sessionService.setAttribute("errorLogin", "");
			mailService.sendMail(saveTaiKhoan.getEmail(), "Xác thực tài khoản Cinemastar",
					"Xác thực tài khoản của bạn!\n" + "<a href='" + "http://localhost:8080/confirmregister?token="
							+ saveTaiKhoan.getToken() + "'>Confirm Account Register!</a>");
		}

		return "redirect:/home";
	}

	@GetMapping(value = "/confirmregister")
	public String confirmRegister(@RequestParam(name = "token") String token) {
		if (token == null) {
			return "redirect:/home";
		}
		Optional<TaiKhoan> taiKhoan = taiKhoanDAO.findByToken(token);
		if (taiKhoan.isEmpty()) {
			return "redirect:/home";
		}
		TaiKhoan taiKhoanFind = taiKhoan.get();
		taiKhoanFind.setToken(null);
		taiKhoanFind.setTrangThai(true);
		taiKhoanDAO.save(taiKhoanFind);
		return "user/confirmregister";
	}

	@GetMapping(value = "/user/personal")
	public String personal(Model model) {
		TaiKhoan taiKhoan = (TaiKhoan) sessionService.getAttribute("taiKhoan");
		if (taiKhoan == null) {
			return "redirect:/home";
		}
		model.addAttribute("taiKhoan", taiKhoan);
		return "user/personal";
	}

	@PostMapping(value = "/user/personal")
	public String personal(@Validated @ModelAttribute(name = "taiKhoan") TaiKhoan taiKhoan, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "user/personal";
		}
		TaiKhoan taiKhoanSave = taiKhoanDAO.save(taiKhoan);
		model.addAttribute("taiKhoan", taiKhoanSave);
		sessionService.setAttribute("taiKhoan", taiKhoanSave);
		return "user/personal";
	}

	@GetMapping(value = "/user/giaodichs")
	public String giaoDich(Model model, @SessionAttribute(name = "taiKhoan") TaiKhoan taiKhoan) {
		List<HoaDon> listHoaDon = hoaDonDAO.findALlHoaDonByUser(taiKhoan.getMaTaiKhoan());
		model.addAttribute("hoaDons", listHoaDon);
		return "user/giaodich";
	}

	@GetMapping(value = "/user/chitietgiaodich")
	public String chiTietGiaoDich(@RequestParam(name = "id") String maHD, Model model) {
		if (maHD == null) {
			return "redirect:/user/giaodichs";
		}
		Optional<HoaDon> hoaDon = hoaDonDAO.findById(maHD);
		if (hoaDon.isEmpty()) {
			return "redirect:/user/giaodichs";
		}
		model.addAttribute("hoaDon", hoaDon.get());
		return "user/chitietgiaodich";
	}

	@GetMapping(value = "/uudais")
	public String uuDais(Model model) {
		Pageable paging = PageRequest.of(0, 4);
		List<KhuyenMai> khuyenMais = khuyenMaiDAO.findAllByCurrentDate();
		model.addAttribute("khuyenMais", khuyenMais);
		model.addAttribute("phimCurrentShows", phimDAO.findAllCurrentShowToDay(paging).getContent());
		return "user/uudais";
	}

	@GetMapping(value = "/user/changepassword")
	public String changePassword() {
		return "user/changepassword";
	}

	@PostMapping(value = "/user/changepassword")
	public String doChangePassword(@RequestParam(name = "matKhauHienTai") String matKhauHienTai,
			@RequestParam(name = "matKhauMoi") String matKhauMoi,
			@RequestParam(name = "xacNhanMatKhau") String xacNhanMatKhau,
			@SessionAttribute("taiKhoan") TaiKhoan taiKhoan, Model model) {
		if (matKhauHienTai.isBlank() || matKhauMoi.isBlank() || xacNhanMatKhau.isBlank()) {
			model.addAttribute("message", "Trường dữ liệu không để trống");
			return "user/changepassword";
		}
		if (!matKhauHienTai.equals(taiKhoan.getMatKhau())) {
			model.addAttribute("message", "Mật khẩu hiện tại không đúng!");
			return "user/changepassword";
		}
		if (!matKhauMoi.matches("[\\w]{7,}")) {
			model.addAttribute("message", "Mật khẩu mới phải có từ 7 kí tự trở lên!");
			return "user/changepassword";
		}
		if (matKhauMoi.equals(taiKhoan.getMatKhau())) {
			model.addAttribute("message", "Mật khẩu mới không trùng với mật khẩu hiện tại!");
			return "user/changepassword";
		}
		if (!matKhauMoi.equals(xacNhanMatKhau)) {
			model.addAttribute("message", "Xác nhận mật khẩu không đúng!");
			return "user/changepassword";
		}
		taiKhoan.setMatKhau(matKhauMoi);
		TaiKhoan saveTaiKhoan = taiKhoanDAO.save(taiKhoan);
		sessionService.setAttribute("taiKhoan", saveTaiKhoan);
		model.addAttribute("message", "Thay đổi mật khẩu thành công!");
		return "user/changepassword";
	}
}
