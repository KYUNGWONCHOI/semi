package semi.climbing.price.service;

import static semi.climbing.jdbc.common.JdbcTemplate.*;
import java.sql.Connection;

import semi.climbing.price.model.dao.PriceDao;
import semi.climbing.price.model.dto.PointChargeDto;
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
	
	public int updatePoint(PointChargeDto dto) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.updatePoint(conn, dto);
		close(conn);
		System.out.println("service result : " + result);
		return result;
	}

}
