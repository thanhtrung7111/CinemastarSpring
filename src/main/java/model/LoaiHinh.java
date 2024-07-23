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
public class LoaiHinh {

	
	@Id
	@Column(name = "maLoaiHinh")
	@GenericGenerator(name = "sequence_loaihinh_id",strategy = "helper.LoaiHinhGeneratorID")
	@GeneratedValue(generator = "sequence_loaihinh_id")
	private String maLoaiHinh;
	
	@Column(name = "tenLoaiHinh")
	private String tenLoaiHinh;
	
	@OneToMany(mappedBy = "loaiHinh")
	private List<HinhPhim> hinhPhims;
	
	@OneToMany(mappedBy = "loaiHinh")
	private List<HinhDienVien_DaoDien> hinhDienVien_DaoDiens;

	
	
	 
}
