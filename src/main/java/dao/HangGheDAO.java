package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.HangGhe;
import model.PhongPhim;

@Repository
public interface HangGheDAO extends JpaRepository<HangGhe, String> {
	@Query("select max(o.maHangGhe) from HangGhe o")
	public String getMaxID();

	Optional<HangGhe> findByTenHangGhe(String tenHangGhe);

	@Query("select o.hangGhe from Ghe o where o.phongPhim = ?1")
	List<HangGhe> findAllByPhongPhim(PhongPhim phongPhim);

}
