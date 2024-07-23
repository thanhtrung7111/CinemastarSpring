package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Ghe;
import model.PhongPhim;

@Repository
public interface GheDAO extends JpaRepository<Ghe, String> {

	@Query("select max(o.maGhe) from Ghe o")
	public String getMaxID();

	@Query("select o from Ghe o where o.phongPhim = ?1")
	List<Ghe> findByAllByPhongPhim(PhongPhim phongPhim);
}
