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
public class HinhPhim {

	@Column(name = "hinhAnh")
	@Id
	private byte[] hinhAnh;

	@ManyToOne
	@JoinColumn(name = "maPhim")
	@Id
	private Phim phim;

	@ManyToOne
	@JoinColumn(name = "maLoaiHinh")
	@Id
	private LoaiHinh loaiHinh;

}
