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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoaiGhe {
	@Id
	@Column(name = "maLoaiGhe")
	@GenericGenerator(name = "sequence_loaighe_id", strategy = "helper.LoaiGheGeneratorID")
	@GeneratedValue(generator = "sequence_loaighe_id")
	private String maLoaiGhe;

	@Column(name = "tenLoaiGhe")
	@Lob
	@Nationalized
	@NotBlank(message = "Không được để trống tên loại ghế!")
	private String tenLoaiGhe;

	@Column(name = "chiPhi")
	@Min(value = 50000,message = "Giá không được vượt quá 50.000 VNĐ")
	@Max(value = 1000000,message = "Giá không được nhỏ hơn 1.000.000 VNĐ")
	private Double chiPhi;

	@OneToMany(mappedBy = "loaiGhe")
	private List<Ghe> ghes;

}
