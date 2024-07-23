package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ApDungTaiKhoanID.class)
public class ApDungTaiKhoan {
	@Column(name = "trangThaiApDung")
	private Boolean trangThaiApDung;

	@ManyToOne
	@JoinColumn(name = "maKhuyenMai")
	@Id
	private KhuyenMai khuyenMai;

	@ManyToOne
	@JoinColumn(name = "maLoaiTaiKhoan")
	@Id
	private LoaiTaiKhoan loaiTaiKhoan;

}
