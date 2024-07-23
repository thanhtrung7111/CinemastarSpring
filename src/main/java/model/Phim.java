package model;

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
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phim {

	@Id
	@Column(name = "maPhim")
	@GenericGenerator(name = "sequence_phim_id", strategy = "helper.PhimGeneratorID")
	@GeneratedValue(generator = "sequence_phim_id")
	private String maPhim;

	@Column(name = "tenPhim")
	@Lob
	@Nationalized
	@NotBlank(message = "Không để trống tên phim!")
	private String tenPhim;

	@Column(name = "thoiLuong")
	@NotNull(message = "Không để trống thời lượng!")
	@Min(value = 100, message = "Thời lượng phim phải trên 100 phút")
	@Max(value = 200, message = "Thời lượng phim phải dưới 200 phút")
	private Integer thoiLuong;

	@Column(name = "mota")
	@Lob
	@Nationalized
	@NotBlank(message = "Không để trống mô tả!")
	private String moTa;

	@Column(name = "noiDung")
	@Lob
	@Nationalized
	@NotBlank(message = "Không để trống nội dung!")
	private String noiDung;

	@Column(name = "namSanXuat")
	@NotNull(message = "Không để trống năm sản xuất")
	@Min(value = 1950, message = "Năm sản xuất phải lớn hơn 1950")
	@Max(value = 2024, message = "Năm sản xuất phải bé hơn 2024")
	private Integer namSanXuat;

	@Column(name = "hinhAnh")
	private String hinhAnh;

	@Column(name = "banner")
	@NotBlank(message = "Không để trống banner của phim!")
	private String banner;

	@Column(name = "trailer")
	@Lob
	@Nationalized
	private String trailer;

	@Column(name = "luotXem")
	private Integer luotXem = 0;

	@ManyToOne
	@JoinColumn(name = "maQuocGia")
	@NotNull(message = "Quốc gia không được để trống!")
	private QuocGia quocGia;

	@ManyToOne
	@JoinColumn(name = "maTheLoai")
	@NotNull(message = "Thể loại không được để trống!")
	private TheLoai theLoai;

	@OneToMany(mappedBy = "phim")
	private List<SuatChieu> suatChieus;
//
	@OneToMany(mappedBy = "phim")
	private List<BinhLuan> binhLuans;

	@OneToMany(mappedBy = "phim")
	private List<HinhPhim> hinhPhims;

	@OneToMany(mappedBy = "phim")
	private List<ThamGia> thamGias;

}
