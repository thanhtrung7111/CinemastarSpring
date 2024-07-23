package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.GheDAO;

public class GheGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		GheDAO gheDAO = ApplicationContextHolder.getBean(GheDAO.class);
		String id = gheDAO.getMaxID();
		String result = "";
		if (id == null || id.equals("")) {
			result = "G000000000";
		} else {
			int number = Integer.parseInt(id.substring(1));
			result = String.format("%s%09d", "G", ++number);
		}
		return result;
	}
}
