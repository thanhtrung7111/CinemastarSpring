package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ThamGiaID.class)
public class ThamGia {

	@Id
	@ManyToOne
	@JoinColumn(name="maDV_DD")
	private DienVienDaoDien dienVienDaoDien;
	
	@Id
	@ManyToOne
	@JoinColumn(name="maPhim")
	private Phim phim;

	
	
	
	
}
