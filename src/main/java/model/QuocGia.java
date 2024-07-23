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
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuocGia {

	@Column(name = "maquocgia")
	@Id
	@GenericGenerator(name = "sequence_quocgia_id", strategy = "helper.QuocGiaGeneratorID")
	@GeneratedValue(generator = "sequence_quocgia_id")
	private String maQuocGia;

	@Column(name = "tenquocgia")
	@Lob
	@Nationalized
	@NotBlank(message = "Không được để trống tên quốc gia!")
	private String tenQuocGia;
	@OneToMany(mappedBy = "quocGia")
	private List<DienVienDaoDien> dienVienDaoDiens;

	@OneToMany(mappedBy = "quocGia")
	private List<Phim> phims;

}
