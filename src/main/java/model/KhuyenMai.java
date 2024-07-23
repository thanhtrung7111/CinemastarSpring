package model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class KhuyenMai {

	@Id
	@GenericGenerator(name = "sequence_khuyenmai_id", strategy = "helper.KhuyenMaiGeneratorID")
	@GeneratedValue(generator = "sequence_khuyenmai_id")
	@Column(name = "maKhuyenMai")
	private String maKhuyenMai;

	@Column(name = "tenKhuyenMai")
	@Lob
	@Nationalized
	@NotBlank(message = "Không để trống tên khuyến mãi!")
	private String tenKhuyenMai;

	@Column(name = "phanTramGiam")
	@Min(value = 0, message = "Phần trăm không được dưới 0")
	@Max(value = 100, message = "Phần trăm không được hơn 100")
	private Integer phanTramGiam;

	@Column(name = "soTienGiamTrucTiep")
	private Double soTienGiamTrucTiep;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngayApDung")
	@NotNull(message = "Ngày áp dụng không để trống!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayApDung;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngayKetThuc")
	@NotNull(message = "Ngày kết thúc không được để trống!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayKetThuc;

	@Column(name = "hinhAnh")
	private String hinhAnh;

	@OneToMany(mappedBy = "khuyenMai")
	private List<ApDungTaiKhoan> apDungTaiKhoans;

	@OneToMany(mappedBy = "apDungKhuyenMaiID.khuyenMai", fetch = FetchType.EAGER)
	private List<ApDungKhuyenMai> apDungKhuyenMais;

}
