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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhongPhim {

	@Id
	@Column(name = "maPhongPhim")
	@GenericGenerator(name = "sequence_phongphim_id", strategy = "helper.PhongPhimGeneratorID")
	@GeneratedValue(generator = "sequence_phongphim_id")
	private String maPhongPhim;

	@Column(name = "tenPhongPhim")
	@Lob
	@Nationalized
	private String tenPhongPhim;

	@Column(name = "trangThai")
	private Boolean trangThai;

	@ManyToOne
	@JoinColumn(name = "maRapPhim")
	@NotNull(message = "Rạp phim không được để trống!")
	private RapPhim rapPhim;

	@OneToMany(mappedBy = "phongPhim")
	private List<SuatChieu> suatChieus;

	@OneToMany(mappedBy = "phongPhim")
	private List<Ghe> ghes;

}
