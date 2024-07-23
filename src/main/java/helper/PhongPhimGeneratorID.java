package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.KhuyenMaiDAO;
import dao.PhongPhimDAO;

public class PhongPhimGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		PhongPhimDAO phongPhimDAO = ApplicationContextHolder.getBean(PhongPhimDAO.class);
		String id = phongPhimDAO.getMaxID();
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
