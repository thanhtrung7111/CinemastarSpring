package dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.QuocGia;

@Repository
public interface QuocGiaDAO extends JpaRepository<QuocGia, String> {
	@Query("select max(o.maQuocGia) from QuocGia o")
	public String getMaxID();

	Optional<QuocGia> findByTenQuocGia(String tenQuocGia);
}
