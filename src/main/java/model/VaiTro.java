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
public class VaiTro {

	@Id
	@Column(name = "maVaiTro")
	@GenericGenerator(name = "sequence_vaitro_id", strategy = "helper.VaiTroGeneratorID")
	@GeneratedValue(generator = "sequence_vaitro_id")
	private  maVaiTro;

	@Column(name = "tenVaiTro")
	@Nationalized
	@Lob
	@NotBlank(message = "Không để trống tên vai trò!")
	private String tenVaiTro;

	
}
