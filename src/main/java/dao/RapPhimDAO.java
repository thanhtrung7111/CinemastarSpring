package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Phim;
import model.RapPhim;
import model.ThanhPho;

@Repository
public interface RapPhimDAO extends JpaRepository<RapPhim, String> {
	@Query("select max(o.maRapPhim) from RapPhim o")
	public String getMaxID();

	Optional<RapPhim> findByTenRapPhim(String tenRapPhim);

	@Query("select o.phongPhim.rapPhim from SuatChieu o where o.phim =?1"
			+ " and o.thoiGianChieu >= current_time and o.ngayChieu >= current_date"
			+ " and o.phongPhim.rapPhim.thanhPho = ?2")
	List<RapPhim> findCurrentShow(Phim phim, ThanhPho thanhPho);

	@Query("select o.phongPhim.rapPhim from SuatChieu o where o.phim =?1"
			+ " and o.thoiGianChieu >= current_time and o.ngayChieu >= current_date")
	List<RapPhim> findCurrentShowPhim(Phim phim);
}
