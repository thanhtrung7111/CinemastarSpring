package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.LoaiGheDAO;
import dao.LoaiHinhDAO;

public class LoaiHinhGeneratorID implements IdentifierGenerator {
	

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		LoaiHinhDAO loaiHinhDAO = ApplicationContextHolder.getBean(LoaiHinhDAO.class);
		String id = loaiHinhDAO.getMaxID();
		String result = "";
		if (id == null || id.equals("")) {
			result = "LH00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "LH", ++number);
		}
		return result;
	}
}
