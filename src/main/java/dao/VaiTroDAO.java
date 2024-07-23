package dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.VaiTro;

@Repository
public interface VaiTroDAO extends JpaRepository<VaiTro, String> {
	@Query("select max(o.maVaiTro) from VaiTro o")
	public String getMaxID();

	Optional<VaiTro> findByTenVaiTro(String tenVaiTro);
}
