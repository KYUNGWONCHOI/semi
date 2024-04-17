package semi.climbing.notice.model.dao;

import static semi.climbing.jdbc.common.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.climbing.notice.model.dto.FileReadDto;
import semi.climbing.notice.model.dto.FileWriteDto;
import semi.climbing.notice.model.dto.NoticeDto;
import semi.climbing.notice.model.dto.NoticeInsertDto;
import semi.climbing.notice.model.dto.NoticeListDto;
import semi.climbing.notice.model.dto.NoticeReadDto;


public class NoticeDao {
	// 파일 읽기
	public List<FileReadDto> selectFileList(Connection conn, Integer noticeNo) {
		List<FileReadDto> result = null;
		String sql = "SELECT NOTICE_NO, FILE_ORIGIN_NAME, FILE_SAVE_PATH FROM NOTICE WHERE NOTICE_NO=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new ArrayList<FileReadDto>();
				do {
					FileReadDto dto = new FileReadDto(
							rs.getInt("NOTICE_NO"),rs.getString("FILE_ORIGIN_NAME"),
							rs.getString("FILE_SAVE_PATH")
							);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);			
		return result;
	}
	
	// select total Count - 게시물 개수
	public int selectTotalCount(Connection conn) {
		int result = 0;
		String sql = "SELECT COUNT(*) CNT FROM NOTICE";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			rs = pstmt.executeQuery();
			// ResetSet처리
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
	
	// 게시판 페이징 처리
	public List<NoticeListDto> selectPageList(Connection conn, int start, int end) {
		List<NoticeListDto> result = null;
		String sql = "SELECT T2.*"
				+ "    FROM (SELECT T1.*, ROWNUM RN"
				+ "    FROM (SELECT NOTICE_NO, NOTICE_SUBJECT, BOARD_DATE, BOARD_READ_NO, NOTICE_TYPE FROM NOTICE ORDER BY NOTICE_NO DESC) T1 ) T2"
				+ "    WHERE RN BETWEEN ? and ?"
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
				result = new ArrayList<NoticeListDto>();
				do {
					NoticeListDto dto = new NoticeListDto(
							rs.getInt("NOTICE_NO"),rs.getString("NOTICE_SUBJECT"),
							rs.getString("BOARD_DATE"), rs.getInt("BOARD_READ_NO"), rs.getInt("NOTICE_TYPE")
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
	
	// select list - all
	public List<NoticeListDto> selectAllList(Connection conn) {
		List<NoticeListDto> result = null;
		String sql = "SELECT NOTICE_NO, NOTICE_SUBJECT, BOARD_DATE, BOARD_READ_NO, NOTICE_TYPE FROM NOTICE";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			rs = pstmt.executeQuery();
			// ResetSet처리
			if(rs.next()) {
				result = new ArrayList<NoticeListDto>();
				do {
					NoticeListDto dto = new NoticeListDto(	
							rs.getInt("NOTICE_NO"),rs.getString("NOTICE_SUBJECT"),
							rs.getString("BOARD_DATE"),rs.getInt("BOARD_READ_NO"),
							rs.getInt("NOTICE_TYPE")
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
	
	// select one
	public NoticeReadDto selectOne(Connection conn, Integer noticeNo) {
		NoticeReadDto result = null;
		String sql = "SELECT NOTICE_NO, NOTICE_SUBJECT, NOTICE_CONTENT, BOARD_DATE, BOARD_READ_NO, NOTICE_TYPE FROM NOTICE WHERE NOTICE_NO=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setInt(1, noticeNo);
			rs = pstmt.executeQuery();
			// ResetSet처리
			if(rs.next()) {
				result = new NoticeReadDto(	
						rs.getInt("NOTICE_NO"),rs.getString("NOTICE_SUBJECT"),rs.getString("NOTICE_CONTENT"),
						rs.getString("BOARD_DATE"),rs.getInt("BOARD_READ_NO"),rs.getInt("NOTICE_TYPE")
						);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	// getSequenceNum
	public int getSequenceNum(Connection conn) {
		int result = 0;
		String sql = "SELECT SEQ_NOTICE_NO.nextval FROM DUAL";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			rs = pstmt.executeQuery();
			// ResetSet처리
			if(rs.next()) {
				result = rs.getInt(1);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	// insert
	public int insert(Connection conn, NoticeInsertDto dto) {
		int result = 0;
		String sql = "INSERT ALL ";
		sql+="	INTO NOTICE (NOTICE_NO, NOTICE_SUBJECT, NOTICE_CONTENT, BOARD_DATE, BOARD_READ_NO) ";
		sql+="		VALUES (SEQ_BOARD_ID.nextval, ?, ?, default, default) ";
		if(dto.getFileList()!= null && dto.getFileList().size()>0) {
			for(FileWriteDto filedto :dto.getFileList()) {
		sql+="	INTO BOARD_FILE (NOTICE_NO, FILE_ORIGIN_NAME, FILE_SAVE_PATH) ";
		sql+="		VALUES (SEQ_BOARD_ID.nextval, ?, ?) ";
			}
		} 
		sql+="	SELECT * FROM DUAL ";
		System.out.println("sql: "+ sql);
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			int i = 1;
			pstmt.setString(i++, dto.getNoticeSubject());
			pstmt.setString(i++, dto.getNoticeContent());
			if(dto.getFileList()!= null && dto.getFileList().size()>0) {
				int fileId = 1;
				for(FileWriteDto filedto :dto.getFileList()) {
					pstmt.setString(i++, filedto.getOrginalFileName());
					pstmt.setString(i++, filedto.getFilePath());					
				}
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	// update - readCount
	public int updateReadCount(Connection conn, Integer noticeNo) {
		int result = 0;
		String sql = "UPDATE NOTICE SET BOARD_READ_NO=BOARD_READ_NO+1 WHERE NOTICE_NO=?";  //TODO
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	// update
	public int update(Connection conn, NoticeDto dto) {
		int result = 0;
		String sql = "";  //TODO
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	// delete
	public int delete(Connection conn, Integer noticeNo) {
		int result = 0;
		String sql = "DELETE FROM BOARD WHERE BOARD_ID=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
		
}
