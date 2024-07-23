package helper;


import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.ComboDoAnDAO;
import dao.DienVienDAO;



public class ComboDoAnGeneratorID implements IdentifierGenerator {


	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		ComboDoAnDAO comboDoAnDAO = ApplicationContextHolder.getBean(ComboDoAnDAO.class);
		String id = comboDoAnDAO.getMaxID();
		String result = "";
		if (id == null || id.equals("")) {
			result = "CB00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "CB", ++number);
		}
		return result;
	}
}
