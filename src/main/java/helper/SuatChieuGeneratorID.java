package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.QuocGiaDAO;
import dao.SuatChieuDAO;

public class SuatChieuGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		SuatChieuDAO suatChieuDAO = ApplicationContextHolder.getBean(SuatChieuDAO.class);
		String id = suatChieuDAO.getMaxID();
		String result = "";
		if (id == null || id.equals("")) {
			result = "SC00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "SC", ++number);
		}
		return result;
	}
}
