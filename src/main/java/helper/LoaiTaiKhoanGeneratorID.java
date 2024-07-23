package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.LoaiTaiKhoanDAO;

public class LoaiTaiKhoanGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		LoaiTaiKhoanDAO loaiTaiKhoanDAO = ApplicationContextHolder.getBean(LoaiTaiKhoanDAO.class);
		String id = loaiTaiKhoanDAO.getMaxID();
		String result = "";
		if (id == null || id.equals("")) {
			result = "LTK0000000";
		} else {
			int number = Integer.parseInt(id.substring(3));
			result = String.format("%s%07d", "LTK", ++number);
		}
		return result;
	}
}
