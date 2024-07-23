package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.DienVienDaoDien;

@Repository
public interface DienVienDAO extends JpaRepository<DienVienDaoDien, String> {

	@Query("select max(o.maDV_DD) from DienVienDaoDien o")
	public String getMaxID();

	@Query("select o from DienVienDaoDien o where o.tenDV_DD = ?1")
	Optional<DienVienDaoDien> findByTenDV_DD(String tenDV_DD);

	@Query("select o from DienVienDaoDien o where o.vaiTro.tenVaiTro = ?1")
	List<DienVienDaoDien> findAllByTenVaiTro(String tenVaiTro);

	@Query("select o from DienVienDaoDien o where o.vaiTro.tenVaiTro = ?1")
	Page<DienVienDaoDien> findAllPageByTenVaiTro(String tenVaiTro, Pageable pageable);
}
