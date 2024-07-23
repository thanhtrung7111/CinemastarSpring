package dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.LoaiNhanVien;

@Repository
public interface LoaiNhanVienDAO extends JpaRepository<LoaiNhanVien, String> {
	@Query("select max(o.maLoaiNhanVien) from LoaiNhanVien o")
	public String getMaxID();

	Optional<LoaiNhanVien> findByTenLoaiNhanVien(String tenLoaiNhanVien);
}
