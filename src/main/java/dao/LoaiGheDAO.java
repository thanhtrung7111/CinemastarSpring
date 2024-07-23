package dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import model.LoaiGhe;
import java.util.List;

@Repository
public interface LoaiGheDAO extends JpaRepository<LoaiGhe, String> {

	@Query("select max(o.maLoaiGhe) from LoaiGhe o")
	public String getMaxID();

//	@Query("select o.LoaiGhe from LoaiGhe o where o.tenLoaiGhe LIKE :keywords and chiPhi between :min :max")
//	public Page<LoaiGhe> findLoaiGhe(@RequestParam("keywords") String keywords, @RequestParam("min")Double min,@RequestParam("max")Double max);

	Optional<LoaiGhe> findByTenLoaiGhe(String tenLoaiGhe);

	Page<LoaiGhe> findAllByTenLoaiGheLike(String keywords, Pageable pageable);

	Page<LoaiGhe> findByChiPhiBetween(Double minStr, Double maxStr, Pageable pageable);

	@Query("SELECT lg FROM LoaiGhe lg WHERE (:keywords IS NULL OR lg.tenLoaiGhe LIKE %:keywords%) AND (:min IS NULL OR lg.chiPhi >= :min) AND (:max IS NULL OR lg.chiPhi <= :max)")
	Page<LoaiGhe> findByTenLoaiGheLikeAndChiPhiBetween(@Param("keywords") String keywords, @Param("min") Double min,
			@Param("max") Double max, Pageable pageable);

}