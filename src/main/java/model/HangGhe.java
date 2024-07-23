package model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HangGhe {
	
	@Id
	@Column(name = "maHangGhe")
	@GenericGenerator(name = "sequence_hangghe_id",strategy = "helper.HangGheGeneratorID")
	@GeneratedValue(generator = "sequence_hangghe_id")
	private String maHangGhe;
	
	@Column(name="tenHangGhe")
	private String tenHangGhe;
	
	@OneToMany(mappedBy = "hangGhe")
	private List<Ghe> ghes;

	
	
	
}
