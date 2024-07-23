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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheLoai {
	@Id
	@Column(name = "maTheLoai")
	@GeneratedValue(generator = "sequence_theloai_id")
	@GenericGenerator(name = "sequence_theloai_id", strategy = "helper.TheLoaiGeneratorID")
	public String maTheLoai;

	@Column(name = "tenTheLoai")
	@NotNull(message = "Tên thể loại không được để null")
	@NotBlank(message = "Không để trống tên thể loại")
	@Lob
	@Nationalized
	public String tenTheLoai;

	@OneToMany(mappedBy = "theLoai")
	public List<Phim> phims;
}
