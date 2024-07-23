package model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
public class NhanVien {
	@Id
	@Column(name = "maNhanVien")
	@GenericGenerator(name = "sequence_nhanvien_id", strategy = "helper.NhanVienGeneratorID")
	@GeneratedValue(generator = "sequence_nhanvien_id")
	private String maNhanVien;

	@Column(name = "tenNhanVien")
	@Lob
	@Nationalized
	private String tenNhanVien;

	@Column(name = "email")
	private String email;

	@Column(name = "soDienThoai",length = 10)
	private String soDienThoai;

	@Column(name = "matKhau")
	private String matKhau;

	@Column(name = "hinhAnh")
	private String hinhAnh;

	@Column(name = "ngaySinh")
	@Temporal(TemporalType.DATE)
	private Date ngaySinh;

	@ManyToOne
	@JoinColumn(name = "maLoaiNhanVien")
	private LoaiNhanVien loaiNhanVien;

	@OneToMany(mappedBy = "nhanVien")
	List<HoaDon> hoaDons;

	@ManyToOne
	@JoinColumn(name = "maRapPhim")
	RapPhim rapPhim;

}
