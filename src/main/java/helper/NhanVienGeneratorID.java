package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.LoaiNhanVienDAO;
import dao.LoaiTaiKhoanDAO;
import dao.NhanVienDAO;

public class NhanVienGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		NhanVienDAO nhanVienDAO = ApplicationContextHolder.getBean(NhanVienDAO.class);
		String id = nhanVienDAO.getMaxID();
		String result = "";
		if (id == null || id.equals("")) {
			result = "NV00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "NV", ++number);
		}
		return result;
	}
}
