package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Phim;
import model.ThanhPho;

@Repository
public interface PhimDAO extends JpaRepository<Phim, String> {
	@Query("select max(o.maPhim) from Phim o")
	public String getMaxID();

	Optional<Phim> findByTenPhim(String tenPhim);

	@Query("select distinct(o.phim) from SuatChieu o where o.ngayChieu >= current_date and o.thoiGianChieu >= current_time and o.phongPhim.rapPhim.thanhPho = ?1 ")
	List<Phim> findAllCurrentShow(ThanhPho thanhPho);

	@Query("select distinct(o.phim) from SuatChieu o where o.ngayChieu >= current_date and o.thoiGianChieu >= current_time")
	Page<Phim> findAllCurrentShowToDay(Pageable pageable);

	@Query("select o from Phim o")
	Page<Phim> findAllPage(Pageable pageable);
}
