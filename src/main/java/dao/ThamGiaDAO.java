package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Phim;
import model.ThamGia;
import model.ThamGiaID;

@Repository
public interface ThamGiaDAO extends JpaRepository<ThamGia, ThamGiaID> {

	@Modifying
	@Transactional
	@Query("delete from ThamGia o where o.phim = ?1")
	int deleteAllByPhim(Phim phim);
}
