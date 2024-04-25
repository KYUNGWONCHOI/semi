package semi.climbing.board.prob.model.dao;

import static semi.climbing.jdbc.common.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.climbing.board.prob.model.dto.ProblemDto;
import semi.climbing.board.prob.model.dto.ProblemInsertDto;
import semi.climbing.board.prob.model.dto.ProblemListDto;
import semi.climbing.board.prob.model.dto.VideoWriteDto;

public class ProblemDao {

	//SELECT TOTAL COUNT
	public int selectTotalCount(Connection conn) {
		int result = 0;
		String sql = "SELECT COUNT(*) CNT FROM BOARD_PROBLEM";
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
	
	public List<ProblemListDto> selectPageList(Connection conn, int start, int end) {
		List<ProblemListDto> result = null;
		String sql = "SELECT T2.*\r\n"
				+ "	FROM (SELECT T1.*, ROWNUM RN\r\n"
				+ "		FROM (SELECT BOARD_PROB_NO, PROB_SUBJECT, PROB_SECTOR, PROB_LEVEL, BOARD_PROB_DATE, MEMBER_ID, BOARD_PROB_READ_NO, BOARD_TYPE FROM BOARD_PROBLEM ORDER BY BOARD_PROB_NO DESC) T1 ) T2\r\n"
				+ "		WHERE RN BETWEEN ? and ?"
			    ;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setInt(1, start);//한페이지당글수*(현재페이지-1)+1
			pstmt.setInt(2, end);//한페이지당글수*(현재페이지)
			rs = pstmt.executeQuery();
			// ResetSet처리
			if(rs.next()) {
				result = new ArrayList<ProblemListDto>();
				do {
					ProblemListDto dto = new ProblemListDto(
							rs.getInt("BOARD_PROB_NO"),rs.getString("PROB_SUBJECT"), rs.getString("PROB_SECTOR"), rs.getInt("PROB_LEVEL"), 
							rs.getString("BOARD_PROB_DATE"), rs.getInt("BOARD_PROB_READ_NO"), rs.getString("MEMBER_ID"), rs.getInt("BOARD_TYPE")
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
	public List<ProblemListDto> selectAllList(Connection conn){
		List<ProblemListDto> result = null;
		String sql = "SELECT ROWNUM, PROB_SUBJECT, PROB_SECTOR, PROB_LEVEL, BOARD_PROB_DATE, MEMBER_ID, BOARD_PROB_READ_NO, BOARD_TYPE \r\n"
				+ "    FROM (SELECT PROB_SUBJECT, PROB_SECTOR, PROB_LEVEL, BOARD_PROB_DATE, MEMBER_ID, BOARD_PROB_READ_NO, BOARD_TYPE FROM BOARD_PROBLEM ORDER BY BOARD_PROB_DATE DESC)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			rs = pstmt.executeQuery();
			// ResetSet처리
			if(rs.next()) {
				result = new ArrayList<ProblemListDto>();
				do {
					ProblemListDto dto = new ProblemListDto(
							rs.getInt("BOARD_PROB_NO"),rs.getString("PROB_SUBJECT"), rs.getString("PROB_SECTOR"), rs.getInt("PROB_LEVEL"), 
							rs.getString("BOARD_PROB_DATE"), rs.getInt("BOARD_PROB_READ_NO"), rs.getString("MEMBER_ID"), rs.getInt("BOARD_TYPE")
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
		public ProblemDto selectOne(Connection conn){
			ProblemDto result = null;
			String sql = "SELECT BOARD_PROB_NO, PROB_SUBJECT, PROB_SECTOR, PROB_LEVEL, PROB_CONTENT, BOARD_PROB_DATE, BOARD_PROB_READ_NO, MEMBER_ID, VIDEO_ORIGIN_NAME, VIDEO_SAVE_PATH\r\n"
					+ "    , BOARD_TYPE FROM BOARD_PROBLEM";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				// ? 처리
				rs = pstmt.executeQuery();
				// ResetSet처리
				if(rs.next()) {
					result =  new ProblemDto(	
								rs.getInt("BOARD_PROB_NO"),
								rs.getString("PROB_SUBJECT"),rs.getString("PROB_SECTOR"),
								rs.getInt("PROB_LEVEL"),rs.getString("PROB_CONTENT"),
								rs.getString("BOARD_PROB_DATE"),rs.getInt("BOARD_PROB_READ_NO"),
								rs.getString("MEMBER_ID"), rs.getInt("BOARD_TYPE")
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
		public int insert(Connection conn, ProblemInsertDto dto) {
			int result = 0;
			String sql = "INSERT ALL ";
			sql+="	INTO BOARD_PROBLEM (BOARD_PROB_NO, PROB_SUBJECT, PROB_SECTOR, PROB_LEVEL, PROB_CONTENT, BOARD_PROB_DATE, BOARD_PROB_READ_NO, MEMBER_ID, BOARD_TYPE ) ";
			sql+="		VALUES (SEQ_BOARD_PROBLEM.NEXTVAL, ?, ?, ?, ?, DEFAULT, DEFAULT, ?, ?) ";
			if(dto.getFileList()!= null && dto.getFileList().size()>0) {
				for(VideoWriteDto filedto : dto.getFileList()) {
			sql+="	INTO BOARD_PROB_VIDEO (BOARD_PROB_NO, VIDEO_SAVE_PATH, VIDEO_NAME) ";
			sql+="		VALUES (SEQ_BOARD_PROBLEM.NEXTVAL, ?, ?) ";
				}
			} 
			sql+="	SELECT * FROM DUAL ";
			System.out.println("sql: "+ sql);
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				// ? 처리
				int i = 1;
				pstmt.setString(i++, dto.getProbSubject());
				pstmt.setString(i++, dto.getProbSector());
				pstmt.setInt(i++, dto.getProbLevel());
				pstmt.setString(i++, dto.getProbContent());
				pstmt.setString(i++, dto.getMemberId());
				pstmt.setInt(i++, dto.getBoardType());
				if(dto.getFileList()!= null && dto.getFileList().size()>0) {
					for(VideoWriteDto filedto :dto.getFileList()) {
						System.out.println("dto.getFileList : "+dto.getFileList());
						pstmt.setString(i++, filedto.getVideoName());
						pstmt.setString(i++, filedto.getVideSavePath());					
					}
				}
				i = 0;
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(pstmt);
			return result;
		}
		//delete
		public int deleteLesson(Connection conn, Integer boardProbNo) {
			int result = 0;
			//TODO
			return result;
		}
	
}
