package model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon {
	@Id
	@Column(name = "maHD")
	@GenericGenerator(name = "sequence_hoadon_id", strategy = "helper.HoaDonGeneratorID")
	@GeneratedValue(generator = "sequence_hoadon_id")
	private String maHD;

	@Column(name = "tongTien")
	private Double tongTien;

	@Column(name = "trangThai")
	private Boolean trangThai = false;

	@Column(name = "code")
	private String code;

	@Column(name = "ngayLapHD")
	@Temporal(TemporalType.DATE)
	private Date ngayLapHD;
	

	@ManyToOne
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;

	@ManyToOne
	@JoinColumn(name = "maTaiKhoan")
	private TaiKhoan taiKhoan;

	@OneToMany(mappedBy = "apDungKhuyenMaiID.hoaDon", fetch = FetchType.EAGER)
	private List<ApDungKhuyenMai> apDungKhuyenMais;

	@OneToMany(mappedBy = "chiTietComboID.hoaDon", fetch = FetchType.EAGER)
	private List<ChiTietCombo> chiTietCombos;

	@OneToMany(mappedBy = "hoaDon")
	private List<Ve> ves;

}
