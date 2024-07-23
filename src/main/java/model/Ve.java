package model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
public class Ve {
	@Id
	@Column(name = "maVe")
	@GenericGenerator(name = "sequence_ve_id", strategy = "helper.VeGeneratorID")
	@GeneratedValue(generator = "sequence_ve_id")
	private String maVe;

	@Column(name = "tongTien")
	private Double tongTien;

	@ManyToOne
	@JoinColumn(name = "maGhe")
	private Ghe ghe;

	@ManyToOne
	@JoinColumn(name = "maSuatChieu")
	private SuatChieu suatChieu;

	@ManyToOne
	@JoinColumn(name = "maHD")
	private HoaDon hoaDon;

}
