package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.VaiTroDAO;
import dao.VeDAO;

public class VeGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		VeDAO veDAO = ApplicationContextHolder.getBean(VeDAO.class);
		String id = veDAO.getMaxID();
		String result = "";
		if (id == null || id.equals("")) {
			result = "V000000000";
		} else {
			int number = Integer.parseInt(id.substring(1));
			result = String.format("%s%09d", "V", ++number);
		}
		return result;
	}
}
