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
public class LoaiNhanVien {

	@Id
	@Column(name = "maLoaiNhanVien")
	@GenericGenerator(name = "sequence_loainhanvien_id", strategy = "helper.LoaiNhanVienGeneratorID")
	@GeneratedValue(generator = "sequence_loainhanvien_id")
	private String maLoaiNhanVien;

	@Column(name = "tenLoaiNhanVien")
	@Lob
	@Nationalized
	@NotBlank(message = "Không được để trống tên loại nhân viên!")
	private String tenLoaiNhanVien;

	@OneToMany(mappedBy = "loaiNhanVien")
	List<NhanVien> nhanViens;

}
