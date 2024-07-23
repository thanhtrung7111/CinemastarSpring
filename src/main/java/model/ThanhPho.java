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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThanhPho {

	@Id
	@Column(name = "maThanhPho")
	@GeneratedValue(generator = "sequence_thanhpho_id")  
	@GenericGenerator(name = "sequence_thanhpho_id", strategy = "helper.ThanhPhoGeneratorID")
	public String maThanhPho;
	
	@Column(name = "tenThanhPho")
	@NotNull(message = "Tên thành phố không được để null")
	@NotBlank(message = "Không để trống tên thành phố")
	@Lob
	@Nationalized
	public String tenThanhPho;
	
	@OneToMany(mappedBy = "thanhPho")
	public List<RapPhim> rapPhims;

	
	
	
}
