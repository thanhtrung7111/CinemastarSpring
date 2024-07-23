package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.DienVienDAO;

public class DienVienDaoDienGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		DienVienDAO dienVienDAO = ApplicationContextHolder.getBean(DienVienDAO.class);
		String id = dienVienDAO.getMaxID();
		String result = "";
		if (id == null || id.equals("")) {
			result = "DV00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "DV", ++number);
		}
		return result;
	}
}
