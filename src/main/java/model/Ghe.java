package model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ghe {
	@Column(name = "maGhe")
	@Id
	@GenericGenerator(name = "sequence_ghe_id", strategy = "helper.GheGeneratorID")
	@GeneratedValue(generator = "sequence_ghe_id")
	private String maGhe;

	@Column(name = "tenGhe")
	private String tenGhe;

	@ManyToOne
	@JoinColumn(name = "maLoaiGhe")
	private LoaiGhe loaiGhe;

	@ManyToOne
	@JoinColumn(name = "maPhongPhim")
	private PhongPhim phongPhim;

	@ManyToOne
	@JoinColumn(name = "maHangGhe")
	private HangGhe hangGhe;

	@OneToMany(mappedBy = "ghe")
	private List<Ve> ves;



}
