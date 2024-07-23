package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.NhanVienDAO;
import dao.PhimDAO;

public class PhimGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		PhimDAO phimDAO = ApplicationContextHolder.getBean(PhimDAO.class);
		String id = phimDAO.getMaxID();
		String result = "";
		if (id == null || id.equals("")) {
			result = "PP00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "PP", ++number);
		}
		return result;
	}
}
