package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.ThanhPhoDAO;

public class ThanhPhoGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		ThanhPhoDAO thanhPhoDAO = ApplicationContextHolder.getBean(ThanhPhoDAO.class);
		String id = thanhPhoDAO.getMaxID();

		String result = "";
		if (id == null || id.equals("")) {
			result = "TP00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "TP", ++number);
		}
		return result;
	}

}
