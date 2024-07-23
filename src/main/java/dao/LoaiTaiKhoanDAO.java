package dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.LoaiTaiKhoan;

@Repository
public interface LoaiTaiKhoanDAO extends JpaRepository<LoaiTaiKhoan, String> {
	@Query("select max(o.maLoaiTaiKhoan) from LoaiTaiKhoan o")
	public String getMaxID();

	Optional<LoaiTaiKhoan> findByTenLoaiTaiKhoan(String tenLoaiTaiKhoan);
}
