package semi.climbing.price.service;

import static semi.climbing.jdbc.common.JdbcTemplate.*;
import java.sql.Connection;

import semi.climbing.price.model.dao.PriceDao;
import semi.climbing.price.model.dto.RegisterInfoDto;

public class PriceService {
	private PriceDao dao = new PriceDao();
	
	public int insert(RegisterInfoDto dto) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.insert(conn, dto);
		close(conn);
		return result;
	}

}
