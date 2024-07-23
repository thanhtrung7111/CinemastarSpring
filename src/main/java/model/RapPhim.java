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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RapPhim {
	@Id
	@Column(name = "maRapPhim")
	@GenericGenerator(name = "sequence_rapphim_id", strategy = "helper.RapPhimGeneratorID")
	@GeneratedValue(generator = "sequence_rapphim_id")
	private String maRapPhim;

	@Column(name = "tenRapPhim")
	@Lob
	@Nationalized
	@NotBlank(message = "Không để trống tên rạp phim")
	private String tenRapPhim;

	@Column(name = "diaChi")
	@Lob
	@Nationalized
	@NotBlank(message = "Không để trống địa chỉ")
	private String diaChi;

	@Column(name = "soDienThoai")
	@NotBlank(message = "Không để trống số điện thoại")
	@Size( message = "Không để trống số điện thoại")
	private String soDienThoai;

	@ManyToOne
	@JoinColumn(name = "maThanhPho")
	private ThanhPho thanhPho;

	@OneToMany(mappedBy = "rapPhim")
	List<PhongPhim> phongPhims;

	@OneToMany(mappedBy = "rapPhim")
	List<NhanVien> nhanViens;

}
