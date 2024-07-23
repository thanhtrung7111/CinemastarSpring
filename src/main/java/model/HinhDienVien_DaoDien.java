package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class HinhDienVien_DaoDien {

	@Column(name = "hinhAnh")
	@Id
	private byte[] hinhAnh;

	@ManyToOne
	@JoinColumn(name = "maLoaiHinh")
	@Id
	private LoaiHinh loaiHinh;

	@ManyToOne
	@JoinColumn(name = "maDV_DD")
	@Id
	private DienVienDaoDien dienVienDaoDien;

}
