package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.ApDungTaiKhoan;
import model.ApDungTaiKhoanID;

@Repository
@Transactional
public interface ApDungTaiKhoanDAO extends JpaRepository<ApDungTaiKhoan, ApDungTaiKhoanID>{

}
