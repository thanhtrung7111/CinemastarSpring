package model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DienVienDaoDien {
	@Id
	@Column(name = "maDV_DD")
	@GenericGenerator(name = "sequence_dienvien_id", strategy = "helper.DienVienDaoDienGeneratorID")
	@GeneratedValue(generator = "sequence_dienvien_id")
	private String maDV_DD;

	@Column(name = "tenDV_DD")
	@Lob
	@Nationalized
	@NotBlank(message = "Không để trống tên diễn viên đạo diễn?")
	private String tenDV_DD;

	@Column(name = "ngaySinh")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Không để trống ngày sinh!")
	private Date ngaySinh;

	@Column(name = "mota")
	@Lob
	@Nationalized
	@NotBlank(message = "Không để trống mô tả!")
	private String mota;

	@Column(name = "chieuCao")
	@NotNull(message = "Không để trống chiều cao")
	@Min(value = 100, message = "Chiều cao phải trên 100cm")
	@Max(value = 200, message = "Chiều cao phải dưới 200cm")
	private Integer ChieuCao;

	@Column(name = "hinhAnh")
	private String hinhAnh;

	@Column(name = "luotXem")
	private Integer luotXem = 1;

	@JoinColumn(name = "maVaiTro")
	@ManyToOne
	@NotNull(message = "Vai trò không được để trống!")
	VaiTro vaiTro;

	@JoinColumn(name = "maQuocGia")
	@ManyToOne
	@NotNull(message = "Quốc gia không được để trống!")
	QuocGia quocGia;

	@OneToMany(mappedBy = "dienVienDaoDien")
	private List<ThamGia> thamGias;

}
