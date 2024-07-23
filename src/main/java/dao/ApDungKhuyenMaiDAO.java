package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.ApDungKhuyenMai;
import model.ApDungKhuyenMaiID;
import model.HoaDon;

@Repository
public interface ApDungKhuyenMaiDAO extends JpaRepository<ApDungKhuyenMai, ApDungKhuyenMaiID> {

}
