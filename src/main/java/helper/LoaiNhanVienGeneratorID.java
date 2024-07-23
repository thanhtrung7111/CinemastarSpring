package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.LoaiNhanVienDAO;

public class LoaiNhanVienGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		LoaiNhanVienDAO loaiNhanVienDAO = ApplicationContextHolder.getBean(LoaiNhanVienDAO.class);
		String id = loaiNhanVienDAO.getMaxID();
		String result = "";
		if (id == null || id.equals("")) {
			result = "LNV0000000";
		} else {
			int number = Integer.parseInt(id.substring(3));
			result = String.format("%s%07d", "LNV", ++number);
		}
		return result;
	}
}
