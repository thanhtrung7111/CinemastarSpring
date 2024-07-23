package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.ChiTietCombo;
import model.ChiTietComboID;

@Repository
public interface ChiTietComboDAO extends JpaRepository<ChiTietCombo, ChiTietComboID>{

}
