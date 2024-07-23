package model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoaiTaiKhoan {

	@Id
	@Column(name = "maLoaiTaiKhoan")
	@GenericGenerator(name = "sequence_loaitaikhoan_id", strategy = "helper.LoaiTaiKhoanGeneratorID")
	@GeneratedValue(generator = "sequence_loaitaikhoan_id")
	private String maLoaiTaiKhoan;

	@Column(name = "tenLoaiTaiKhoan")
	@Lob
	@Nationalized
	@NotBlank(message = "Tên loại tài khoản không được để trống!")
	private String tenLoaiTaiKhoan;

	@Column(name = "chiTieuToiThieu")
	@Min(value = 0, message = "Chi tiêu tối thiểu không được bé hơn 0.0VNĐ")
	@Max(value = 10000000, message = "Chi tiêu tối thiểu không được lớn hơn 10.000.000VNĐ")
	private Double chiTieuToiThieu;

	@Column(name = "mota")
	@Lob
	@Nationalized
	@NotBlank(message = "Không để trống mô tả!")
	private String mota;

	@OneToMany(mappedBy = "loaiTaiKhoan")
	private List<TaiKhoan> taiKhoans;

	@OneToMany(mappedBy = "loaiTaiKhoan")
	private List<ApDungTaiKhoan> apDungTaiKhoans;

}
