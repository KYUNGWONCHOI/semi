package semi.climbing.membership.model.dao;

import java.sql.Connection;

import semi.climbing.membership.model.dto.MembershipInfoDto;

public class MembershipDao {
	public MembershipInfoDto loginGetInfo(Connection conn, String memId) {
		MembershipInfoDto result = null;
		String sql = "SELECT PAY_DATE, USE_HISTORY, \r\n"
				+ "    CASE WHEN PRICE_TYPE IN (1,2) THEN ADD_MONTHS(TO_DATE('24/04/01', 'YY/MM/DD'), 12)\r\n"
				+ "        WHEN PRICE_TYPE = 3 THEN ADD_MONTHS(TO_DATE('24/04/01', 'YY/MM/DD'), 1)\r\n"
				+ "        WHEN PRICE_TYPE = 4 THEN ADD_MONTHS(TO_DATE('24/04/01', 'YY/MM/DD'), 3)\r\n"
				+ "        ELSE NULL END AS END_DATE, ID, PRICE_TYPE\r\n"
				+ "        FROM PAY_HISTORY JOIN MEMBER USING (ID) JOIN PRICE USING (PRICE_TYPE)\r\n"
				+ "        WHERE PAY_DATE=TO_DATE('24/04/01', 'YY/MM/DD')";
		return result;
	}

}
