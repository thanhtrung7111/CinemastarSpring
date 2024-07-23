package model;

import java.util.Date;

import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BinhLuanID.class)
public class BinhLuan {
	@Column(name = "thoiGian")
	@Temporal(TemporalType.DATE)
	private Date thoiGianBinhLuan;


//
	@ManyToOne
	@JoinColumn(name = "maPhim")
	@Id
	private Phim phim;
	
	@ManyToOne
	@JoinColumn(name = "maTaiKhoan")
	@Id
	private TaiKhoan taiKhoan;

	@Column(name = "liked")
	private Boolean liked;

	@Column(name = "noiDung")
	@Nationalized
	@Lob
	private String noiDung;
}
