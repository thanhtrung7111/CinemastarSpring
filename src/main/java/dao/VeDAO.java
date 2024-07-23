package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.HangGhe;
import model.SuatChieu;
import model.Ve;

@Repository
public interface VeDAO extends JpaRepository<Ve, String> {
	@Query("select max(o.maVe) from Ve o")
	public String getMaxID();

	@Query("select o from Ve o where o.suatChieu = ?1 and o.ghe.hangGhe = ?2 order by SUBSTRING(o.ghe.tenGhe,1,length(o.ghe.tenGhe)-1)")
	List<Ve> findAllBySuatChieu(SuatChieu suatChieu, HangGhe hangGhe);
}
