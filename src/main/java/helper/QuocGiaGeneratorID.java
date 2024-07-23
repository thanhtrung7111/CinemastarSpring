package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.LoaiGheDAO;
import dao.QuocGiaDAO;

public class QuocGiaGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		QuocGiaDAO quocGiaDAO = ApplicationContextHolder.getBean(QuocGiaDAO.class);
		String id = quocGiaDAO.getMaxID();
		String result = "";
		if (id == null || id.equals("")) {
			result = "QG00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "QG", ++number);
		}
		return result;
	}
}
