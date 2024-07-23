package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import dao.KhuyenMaiDAO;

public class KhuyenMaiGeneratorID implements IdentifierGenerator {
	@Autowired
	KhuyenMaiDAO khuyenMaiDAO;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		KhuyenMaiDAO khuyenMaiDAO = ApplicationContextHolder.getBean(KhuyenMaiDAO.class);
		String id = khuyenMaiDAO.getMaxID();
		String result = "";
		if (id == null || id.equals("")) {
			result = "KK00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "KK", ++number);
		}
		return result;
	}
}
