package dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.TaiKhoan;

public interface TaiKhoanDAO extends JpaRepository<TaiKhoan, String> {

	@Query("select o from TaiKhoan o where o.soDienThoai = ?1 or o.email=?2 or o.maTaiKhoan = ?3")
	Optional<TaiKhoan> findByEmailOrSoDienThoai(String tenDangNhap, String email, String maTaiKhoan);

	Optional<TaiKhoan> findByToken(String token);

	Page<TaiKhoan> findAllByMaTaiKhoanLike(String maTaiKhoan, Pageable pageable);

	Page<TaiKhoan> findAllByTenTaiKhoanLike(String tenTaiKhoan, Pageable pageable);

	Page<TaiKhoan> findAllByEmailLike(String email, Pageable pageable);
}
