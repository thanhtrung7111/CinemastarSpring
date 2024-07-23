package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.ThanhPhoDAO;
import dao.TheLoaiDAO;

public class TheLoaiGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		TheLoaiDAO theLoaiDAO = ApplicationContextHolder.getBean(TheLoaiDAO.class);
		String id = theLoaiDAO.getMaxID();

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
