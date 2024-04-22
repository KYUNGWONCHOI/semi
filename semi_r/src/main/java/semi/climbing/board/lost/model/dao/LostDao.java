package semi.climbing.board.lost.model.dao;

import static semi.climbing.jdbc.common.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.climbing.board.lost.model.dto.LostDto;
import semi.climbing.board.lost.model.dto.LostListDto;


public class LostDao {
	
	//SELECT TOTAL COUNT
		public int selectTotalCount(Connection conn) {
			int result = 0;
			String sql = "SELECT COUNT(*) CNT FROM LOST";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = rs.getInt("cnt");
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(rs);
			close(pstmt);
			return result;
		}
		//페이징처리
		public List<LostListDto> selectPageList(Connection conn, int start, int end) {
			List<LostListDto> result = null;
			String sql = "SELECT T2.*\r\n"
					+ "		FROM (SELECT T1.*, ROWNUM RN\r\n"
					+ "			FROM (SELECT BOARD_NO, LOST_SUBJECT, BOARD_DATE, FILE_SAVE_PATH FROM LOST ORDER BY BOARD_NO DESC) T1 ) T2\r\n"
					+ "			WHERE RN BETWEEN ? and ?"
				    ;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);//한페이지당글수*(현재페이지-1)+1
				pstmt.setInt(2, end);//한페이지당글수*(현재페이지)
				rs = pstmt.executeQuery();
				// ResetSet처리
				if(rs.next()) {
					result = new ArrayList<LostListDto>();
					do {
						LostListDto dto = new LostListDto(
								rs.getInt("BOARD_NO"), rs.getString("LOST_SUBJECT"), rs.getString("BOARD_DATE"), 
								rs.getString("FILE_SAVE_PATH")
								);
						result.add(dto);
					}while (rs.next());
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(rs);
			close(pstmt);
			return result;
		}
		
		
		//SELECT ALL LIST
		public List<LostListDto> selectAllList(Connection conn){
			List<LostListDto> result = null;
			String sql = "SELECT ROWNUM, BOARD_NO, LOST_SUBJECT, BOARD_DATE, FILE_SAVE_PATH\r\n"
					+ "	FROM (SELECT BOARD_NO, LOST_SUBJECT, BOARD_DATE, FILE_SAVE_PATH FROM LOST ORDER BY BOARD_NO DESC)";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				// ? 처리
				rs = pstmt.executeQuery();
				// ResetSet처리
				if(rs.next()) {
					result = new ArrayList<LostListDto>();
					do {
						LostListDto dto = new LostListDto(
								rs.getInt("BOARD_NO"), rs.getString("LOST_SUBJECT"), rs.getString("BOARD_DATE"), 
								rs.getString("FILE_SAVE_PATH")
								);
						result.add(dto);
					}while (rs.next());
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(rs);
			close(pstmt);
			return result;	
		}
		
		//SELECT ONE
			public LostDto selectOne(Connection conn){
				LostDto result = null;
				String sql = "SELECT BOARD_NO, LOST_TYPE, LOST_PLACE, LOST_TIME, BOARD_DATE, LOST_SUBJECT, LOST_CONTENT, FILE_ORIGIN_NAME, FILE_SAVE_PATH FROM BOARD_ANY";
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					pstmt = conn.prepareStatement(sql);
					// ? 처리
					rs = pstmt.executeQuery();
					// ResetSet처리
					if(rs.next()) {
						result =  new LostDto(	
									rs.getInt("BOARD_NO"),
									rs.getString("LOST_TYPE"),rs.getString("LOST_PLACE"),
									rs.getString("LOST_TIME"),rs.getString("BOARD_DATE"),
									rs.getString("LOST_SUBJECT"),rs.getString("LOST_CONTENT"),
									rs.getString("FILE_ORIGIN_NAME"),rs.getString("FILE_SAVE_PATH")
									);
					}	
				} catch (SQLException e) {
					e.printStackTrace();
				}
				close(rs);
				close(pstmt);
				return result;	
			}
			
			//insert
			public int insert(Connection conn, LostDto dto) {
				int result = 0;
				//TODO
				return result;
			}
			//delete
			public int deleteLesson(Connection conn, Integer boardNo) {
				int result = 0;
				//TODO
				return result;
			}

}
