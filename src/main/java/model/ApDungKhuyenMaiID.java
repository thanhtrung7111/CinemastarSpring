package model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ApDungKhuyenMaiID implements Serializable {
	
	@ManyToOne
	@JoinColumn(name = "maKhuyenMai")
	private KhuyenMai khuyenMai;

	@ManyToOne
	@JoinColumn(name = "maHD")
	private HoaDon hoaDon;
}
