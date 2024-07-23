package model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class SuatChieu {
	@Id
	@Column(name = "maSuatChieu")
	@GenericGenerator(name = "sequence_suatchieu_id", strategy = "helper.SuatChieuGeneratorID")
	@GeneratedValue(generator = "sequence_suatchieu_id")
	private String maSuatChieu;

	@Column(name = "thoiGianChieu")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date thoiGianChieu;

	@Column(name = "thoiGianKetThuc")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date thoiGianKetThuc;

	@Column(name = "ngayChieu")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayChieu;

	@ManyToOne
	@JoinColumn(name = "maPhongPhim")
	private PhongPhim phongPhim;

	@ManyToOne
	@JoinColumn(name = "maPhim")
	private Phim phim;

	@OneToMany(mappedBy = "suatChieu")
	private List<Ve> ves;

}
