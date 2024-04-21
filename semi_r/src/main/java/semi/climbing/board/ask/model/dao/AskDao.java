package semi.climbing.board.ask.model.dao;

import static semi.climbing.jdbc.common.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.climbing.board.any.model.dto.AnyDto;
import semi.climbing.board.any.model.dto.AnyListDto;
import semi.climbing.board.ask.model.dto.AskDto;
import semi.climbing.board.ask.model.dto.AskListDto;
import semi.climbing.board.prob.model.dto.ProblemDto;
import semi.climbing.board.prob.model.dto.ProblemListDto;
import semi.climbing.board.prob.model.dto.ProblemReadDto;
import semi.climbing.notice.model.dto.NoticeListDto;

public class AskDao {

	//SELECT TOTAL COUNT
	public int selectTotalCount(Connection conn) {
		int result = 0;
		String sql = "SELECT COUNT(*) CNT FROM BOARD_ASK";
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
	public List<AskListDto> selectPageList(Connection conn, int start, int end) {
		List<AskListDto> result = null;
		String sql = "SELECT T2.*\r\n"
				+ "	FROM (SELECT T1.*, ROWNUM RN\r\n"
				+ "	FROM (SELECT BOARD_ASK_NO, ASK_SUBJECT, BOARD_ASK_DATE, BOARD_ASK_READ_NO, ASK_PWN_YN, MEMBER_ID FROM BOARD_ASK ORDER BY BOARD_ASK_NO DESC) T1 ) T2\r\n"
				+ "	WHERE RN BETWEEN ? and ?"
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
				result = new ArrayList<AskListDto>();
				do {
					AskListDto dto = new AskListDto(
							rs.getInt("BOARD_ASK_NO"), rs.getString("ASK_SUBJECT"), rs.getString("BOARD_ASK_DATE"), 
							rs.getInt("BOARD_ASK_READ_NO"), rs.getInt("ASK_PWN_YN"), rs.getString("MEMBER_ID")
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
	public List<AskListDto> selectAllList(Connection conn){
		List<AskListDto> result = null;
		String sql = "SELECT ROWNUM, BOARD_ASK_NO, ASK_SUBJECT, BOARD_ASK_DATE, BOARD_ASK_READ_NO, ASK_PWN_YN, MEMBER_ID\r\n"
				+ "    FROM (SELECT BOARD_ASK_NO, ASK_SUBJECT, BOARD_ASK_DATE, BOARD_ASK_READ_NO, ASK_PWN_YN, MEMBER_ID FROM BOARD_ASK ORDER BY BOARD_ASK_NO DESC)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			rs = pstmt.executeQuery();
			// ResetSet처리
			if(rs.next()) {
				result = new ArrayList<AskListDto>();
				do {
					AskListDto dto = new AskListDto(
							rs.getInt("BOARD_ASK_NO"), rs.getString("ASK_SUBJECT"), rs.getString("BOARD_ASK_DATE"), 
							rs.getInt("BOARD_ASK_READ_NO"), rs.getInt("ASK_PWN_YN"), rs.getString("MEMBER_ID")
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
		public AskDto selectOne(Connection conn){
			AskDto result = null;
			String sql = "SELECT BOARD_ASK_NO, ASK_SUBJECT, ASK_CONTENT, BOARD_ASK_DATE, ASK_ANSWER, BOARD_ASK_READ_NO, ASK_PWN_YN, ASK_PWD, MEMBER_ID FROM BOARD_ASK";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				// ? 처리
				rs = pstmt.executeQuery();
				// ResetSet처리
				if(rs.next()) {
					AskDto dto =  new AskDto(	
								rs.getInt("BOARD_ASK_NO"),
								rs.getString("ASK_SUBJECT"),rs.getString("ASK_CONTENT"),
								rs.getString("BOARD_ASK_DATE"),rs.getString("ASK_ANSWER"),
								rs.getInt("BOARD_ASK_READ_NO"),rs.getInt("ASK_PWN_YN"),
								rs.getString("ASK_PWD"), rs.getString("MEMBER_ID")
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
		public int insert(Connection conn, AskDto dto) {
			int result = 0;
			//TODO
			return result;
		}
		//delete
		public int deleteLesson(Connection conn, Integer boardAskNo) {
			int result = 0;
			//TODO
			return result;
		}
	
}
