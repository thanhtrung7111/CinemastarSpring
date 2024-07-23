package dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.PhongPhim;
import model.RapPhim;

public interface PhongPhimDAO extends JpaRepository<PhongPhim, String> {

	@Query("select max(o.maPhongPhim) from PhongPhim o")
	public String getMaxID();

	Optional<PhongPhim> findByTenPhongPhim(String tenPhongPhim);

	@Query("select p from PhongPhim p where p.tenPhongPhim = ?1 and  p.rapPhim = ?2")
	Optional<PhongPhim> findByTenPhongPhimAndRapPhim(String tenPhongPhim, RapPhim rapPhim);
}
