package dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.ThanhPho;

@Repository
public interface ThanhPhoDAO extends JpaRepository<ThanhPho, String> {
	@Query("select max(o.maThanhPho) from ThanhPho o")
	public String getMaxID();

	Optional<ThanhPho> findByTenThanhPho(String maThanhPho);
}
