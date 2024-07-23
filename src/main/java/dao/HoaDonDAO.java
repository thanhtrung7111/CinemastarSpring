package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.HoaDon;

@Repository
public interface HoaDonDAO extends JpaRepository<HoaDon, String> {

	@Query("select max(o.maHD) from HoaDon o")
	public String getMaxID();

	Optional<HoaDon> findByCode(String code);

	@Query("select o from HoaDon o where o.taiKhoan.maTaiKhoan = ?1")
	List<HoaDon> findALlHoaDonByUser(String maTaiKhoan);
}
