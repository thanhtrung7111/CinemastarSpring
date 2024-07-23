package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.LoaiHinh;

@Repository
public interface LoaiHinhDAO extends JpaRepository<LoaiHinh, String> {
	@Query("select max(o) from LoaiHinh o")
	public String getMaxID();
}
