package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.KhuyenMaiDAO;
import dao.LoaiGheDAO;

public class LoaiGheGeneratorID implements IdentifierGenerator {
	@Autowired
	LoaiGheDAO loaiGheDAO;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		LoaiGheDAO loaiGheDAO = ApplicationContextHolder.getBean(LoaiGheDAO.class);
		String id = loaiGheDAO.getMaxID();
		String result = "";
		if (id == null || id.equals("")) {
			result = "LG00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "LG", ++number);
		}
		return result;
	}
}
