package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.KhuyenMai;

@Repository
public interface KhuyenMaiDAO extends JpaRepository<KhuyenMai, String> {
	@Query("select max(o.maKhuyenMai) from KhuyenMai o")
	public String getMaxID();

	Optional<KhuyenMai> findByTenKhuyenMai(String tenKhuyenMai);

	@Query("select o from KhuyenMai o where o.ngayApDung <= current_date and o.ngayKetThuc >= current_date")
	Page<KhuyenMai> findAllByPageCurrentDate(Pageable pageable);

	@Query("select o from KhuyenMai o where o.ngayApDung <= current_date and o.ngayKetThuc >= current_date")
	List<KhuyenMai> findAllByCurrentDate();
}
