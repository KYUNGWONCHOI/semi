package semi.climbing.board.any.model.dao;

import static semi.climbing.jdbc.common.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.climbing.board.any.model.dto.AnyDto;
import semi.climbing.board.any.model.dto.AnyListDto;
import semi.climbing.board.prob.model.dto.ProblemDto;
import semi.climbing.board.prob.model.dto.ProblemListDto;
import semi.climbing.board.prob.model.dto.ProblemReadDto;
import semi.climbing.notice.model.dto.NoticeListDto;

public class AnyDao {

	//SELECT TOTAL COUNT
	public int selectTotalCount(Connection conn) {
		int result = 0;
		String sql = "SELECT COUNT(*) CNT FROM BOARD_ANY";
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
	public List<AnyListDto> selectPageList(Connection conn, int start, int end) {
		List<AnyListDto> result = null;
		String sql = "SELECT T2.*\r\n"
				+ "	FROM (SELECT T1.*, ROWNUM RN\r\n"
				+ "		FROM (SELECT BOARD_ANY_NO, BOARD_ANY_SUBJECT, BOARD_ANY_DATE, BOARD_ANY_READ_NO, MEMBER_ID FROM BOARD_ANY ORDER BY BOARD_ANY_NO DESC) T1 ) T2\r\n"
				+ "		WHERE RN BETWEEN ? and ?"
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
				result = new ArrayList<AnyListDto>();
				do {
					AnyListDto dto = new AnyListDto(
							rs.getInt("BOARD_ANY_NO"), rs.getString("BOARD_ANY_SUBJECT"), rs.getString("BOARD_ANY_DATE"), 
							rs.getInt("BOARD_ANY_READ_NO"), rs.getString("MEMBER_ID")
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
	public List<AnyListDto> selectAllList(Connection conn){
		List<AnyListDto> result = null;
		String sql = "SELECT ROWNUM, BOARD_ANY_NO, BOARD_ANY_SUBJECT, BOARD_ANY_DATE, BOARD_ANY_READ_NO, MEMBER_ID\r\n"
				+ "	FROM (SELECT BOARD_ANY_NO, BOARD_ANY_SUBJECT, BOARD_ANY_DATE, BOARD_ANY_READ_NO, MEMBER_ID FROM BOARD_ANY ORDER BY BOARD_ANY_NO DESC)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			rs = pstmt.executeQuery();
			// ResetSet처리
			if(rs.next()) {
				result = new ArrayList<AnyListDto>();
				do {
					AnyListDto dto = new AnyListDto(
							rs.getInt("BOARD_ANY_NO"), rs.getString("BOARD_ANY_SUBJECT"), rs.getString("BOARD_ANY_DATE"), 
							rs.getInt("BOARD_ANY_READ_NO"), rs.getString("MEMBER_ID")
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
		public AnyDto selectOne(Connection conn){
			AnyDto result = null;
			String sql = "SELECT BOARD_ANY_NO, BOARD_ANY_SUBJECT, ANY_CONTENT, BOARD_ANY_DATE, BOARD_ANY_READ_NO, MEMBER_ID FROM BOARD_ANY";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				// ? 처리
				rs = pstmt.executeQuery();
				// ResetSet처리
				if(rs.next()) {
					result =  new AnyDto(	
								rs.getInt("BOARD_ANY_NO"),
								rs.getString("BOARD_ANY_SUBJECT"),rs.getString("ANY_CONTENT"),
								rs.getString("BOARD_ANY_DATE"),rs.getInt("BOARD_ANY_READ_NO"),
								rs.getString("MEMBER_ID")
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
		public int insert(Connection conn, AnyDto dto) {
			int result = 0;
			//TODO
			return result;
		}
		//delete
		public int deleteLesson(Connection conn, Integer boardAnyNo) {
			int result = 0;
			//TODO
			return result;
		}
	
}
