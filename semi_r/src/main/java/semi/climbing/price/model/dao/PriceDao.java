package semi.climbing.price.model.dao;

import static semi.climbing.jdbc.common.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import semi.climbing.price.model.dto.PointChargeDto;
import semi.climbing.price.model.dto.RegisterInfoDto;


public class PriceDao {

	public int insert(Connection conn, RegisterInfoDto dto) {
		int result = 0;
		String sql = "INSERT ALL\r\n"
				+ "    INTO PAY_HISTORY (PAY_DATE, ID, PRICE_TYPE, USE_HISTORY, END_DATE) VALUES (SYSTIMESTAMP, ?, ?, ?, ADD_MONTHS(SYSTIMESTAMP, ?))\r\n"
				+ "    INTO MEMBERSHIP (PAY_DATE, MEM_LOCKER) VALUES(SYSTIMESTAMP, ?)\r\n"
				+ "    SELECT * FROM DUAL";
		System.out.println("sql: "+ sql);
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setInt(2, dto.getPriceType());
			pstmt.setInt(3, dto.getUseHistory());
			pstmt.setInt(4, dto.getDuration());
			pstmt.setString(5, dto.getMemLocker());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}	
	public int insertOnedayPass(Connection conn, RegisterInfoDto dto) {
		int result = 0;
		String sql = "INSERT ALL\r\n"
				+ "    INTO PAY_HISTORY () VALUES ()\r\n"
				+ "    INTO RENT () VALUES()\r\n"
				+ "    SELECT * FROM DUAL";
		System.out.println("sql: "+ sql);
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setInt(2, dto.getPriceType());
			pstmt.setInt(3, dto.getUseHistory());
			pstmt.setInt(4, dto.getDuration());
			pstmt.setString(5, dto.getMemLocker());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	public int updatePoint(Connection conn, PointChargeDto dto) {
		int result = 0;
		String sql = " UPDATE MEMBER SET POINT = POINT + ? WHERE ID=? ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getPoint());
			pstmt.setString(2, dto.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		System.out.println("dao result : " + result);
		return result;
	}
}
