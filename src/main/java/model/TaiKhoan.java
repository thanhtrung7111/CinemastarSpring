package model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoan {
	@Id
	@Column(name = "maTaiKhoan")
	@NotBlank(message = "Không để trống mã tài khoản!")
	private String maTaiKhoan;

	@Column(name = "tenTaiKhoan")
	@NotBlank(message = "Không để trống tên tài khoản!")
	private String tenTaiKhoan;

	@Column(name = "email")
	@Email(message = "Emai không đúng định dạng!")
	@NotBlank(message = "Không để trống email!")
	private String email;

	@Column(name = "gioiTinh")
	@NotNull(message = "Không để trống giới tính")
	private Boolean gioiTinh;

	@Column(name = "soDienThoai")
	@NotBlank(message = "Không để trống số điện thoại!")
	private String soDienThoai;

	@Column(name = "matKhau")
	@NotBlank(message = "Không để trống mật khẩu!")
	private String matKhau;

	@Column(name = "ngaySinh")
	@Temporal(TemporalType.DATE)
	@NotNull(message = "Không để trống ngày sinh!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaySinh;

	@Column(name = "hinhAnh")
	@Lob
	private String hinhAnh;

	@Column(name = "trangThai")
	private Boolean trangThai = false;

	@Column(name = "token")
	private String token;

	@ManyToOne
	@JoinColumn(name = "maLoaiTaiKhoan")
	private LoaiTaiKhoan loaiTaiKhoan;

	@OneToMany(mappedBy = "taiKhoan")
	private List<HoaDon> hoaDons;

	@OneToMany(mappedBy = "taiKhoan")
	private List<BinhLuan> binhLuans;

}
