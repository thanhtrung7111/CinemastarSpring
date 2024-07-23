package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.BinhLuan;
import model.BinhLuanID;

@Repository
public interface BinhLuanDAO extends JpaRepository<BinhLuan, BinhLuanID>{

}
