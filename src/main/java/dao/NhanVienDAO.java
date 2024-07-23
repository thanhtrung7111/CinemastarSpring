package dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.LoaiGhe;
import model.NhanVien;
import java.util.List;

@Repository
public interface NhanVienDAO extends JpaRepository<NhanVien, String> {
	@Query("select max(o.maNhanVien) from NhanVien o")
	public String getMaxID();

	Optional<NhanVien> findByEmail(String email);
	
	Page<NhanVien> findAllByMaNhanVienLike(String maNhanVien,Pageable pageable);
	
	Page<NhanVien> findAllByTenNhanVienLike(String tenNhanVien,Pageable pageable);
	
	Page<NhanVien> findAllByEmailLike(String email,Pageable pageable);
	
	Optional<NhanVien> findByTenNhanVien(String tenNhanVien);
	

}
