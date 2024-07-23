package dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import model.ComboDoAn;

@Repository
@Transactional
public interface ComboDoAnDAO extends JpaRepository<ComboDoAn, String> {

	@Query("select max(o.maCombo) from ComboDoAn o")
	public String getMaxID();

	Optional<ComboDoAn> findByTenCombo(String tenCombo);
}
