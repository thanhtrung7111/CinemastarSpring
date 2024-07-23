package dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Phim;
import model.PhongPhim;
import model.RapPhim;
import model.SuatChieu;

@Repository
public interface SuatChieuDAO extends JpaRepository<SuatChieu, String> {
	@Query("select max(o.maSuatChieu) from SuatChieu o")
	public String getMaxID();

	@Query("select o from SuatChieu o where o.phongPhim = ?1 and o.ngayChieu = ?2 and o.thoiGianKetThuc >=  CAST( ?3 AS time ) and o.thoiGianChieu <= CAST( ?4 AS time )")
	List<SuatChieu> findPhongPhimExist(PhongPhim phongPhim, Date ngayChieu, Date thoiGianChieu, Date thoiGianKetThuc);

	@Query("select o from SuatChieu o where o.phim = ?1 and o.thoiGianChieu >= current_time and o.ngayChieu >= current_date")
	List<SuatChieu> findAllCurrentShow(Phim phim);

	@Query("select o from SuatChieu o where o.phongPhim.rapPhim = ?1 and o.phim = ?2 and o.thoiGianChieu >= current_time and o.ngayChieu >= current_date")
	List<SuatChieu> findAllCurrentShowByPhimAndRapPhim(RapPhim rapPhim, Phim phim);
}
