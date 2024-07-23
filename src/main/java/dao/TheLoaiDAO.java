package dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.TheLoai;
import model.VaiTro;

@Repository
public interface TheLoaiDAO extends JpaRepository<TheLoai, String> {
	@Query("select max(o.maTheLoai) from TheLoai o")
	public String getMaxID();

	Optional<TheLoai> findByTenTheLoai(String tenTheLoai);
}
