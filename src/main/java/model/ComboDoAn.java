package model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "tenCombo", "hinhAnh", "moTa", "giaCombo", "chiTietCombos" })
public class ComboDoAn {

	@Id
	@Column(name = "maCombo")
	@GenericGenerator(name = "sequence_combo_id", strategy = "helper.ComboDoAnGeneratorID")
	@GeneratedValue(generator = "sequence_combo_id")
	private String maCombo;

	@Column(name = "tenCombo")
	@Nationalized
	@Lob
	@NotBlank(message = "Không để trống tên combo!")
	private String tenCombo;

	@Column(name = "hinhAnh")
	private String hinhAnh;

	@Column(name = "mota")
	@Lob
	@Nationalized
	@NotBlank(message = "Không để trống tên combo!")
	private String moTa;

	@Column(name = "giaCombo")
	@Min(value = 50000, message = "Giá combo không được nhở hơn 50.000 VNĐ")
	@Max(value = 2000000, message = "Giá combo không được lớn hơn 2.000.000 VNĐ")
	@NotNull(message = "Không để trống giá combo")
	private Double giaCombo;

	@OneToMany(mappedBy = "chiTietComboID.comboDoAn", fetch = FetchType.EAGER)
	private List<ChiTietCombo> chiTietCombos;

}
