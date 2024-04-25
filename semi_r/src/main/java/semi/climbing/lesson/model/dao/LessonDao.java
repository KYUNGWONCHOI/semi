package semi.climbing.lesson.model.dao;

import static semi.climbing.jdbc.common.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.climbing.lesson.model.dto.LessonInsertDto;
import semi.climbing.lesson.model.dto.LessonListDto;
import semi.climbing.lesson.model.dto.LessonOnedayDto;

public class LessonDao {
	
	//select list
	public List<LessonListDto> selectAllList(Connection conn){
		List<LessonListDto> result = null;
		String sql = "SELECT LESSON_CODE, LESSON_TYPE, LESSON_LEVEL, LESSON_START, LESSON_END, TEACHER_NAME, LESSON_TIME, LESSON_DAY, LESSON_DURATION, LESSON_CAPACITY FROM LESSON";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			rs = pstmt.executeQuery();
			// ResetSet처리
			if(rs.next()) {
				result = new ArrayList<LessonListDto>();
				do {
					LessonListDto dto = new LessonListDto(	
							rs.getInt("LESSON_CODE"),
							rs.getString("LESSON_TYPE"),rs.getInt("LESSON_LEVEL"),
							rs.getString("LESSON_START"),rs.getInt("LESSON_DURATION"),rs.getString("LESSON_END"),
							rs.getString("TEACHER_NAME"),rs.getInt("LESSON_TIME"),
							rs.getString("LESSON_DAY"),	rs.getInt("LESSON_CAPACITY")
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
	
	//select list - 강습-레벨업 LESSON_TYPE 1 평일반
		public List<LessonListDto> selectDayAllList(Connection conn){
			List<LessonListDto> result = null;
//			LESSON_CODE     NOT NULL NUMBER       
//			LESSON_TYPE     NOT NULL CHAR(1)      
//			LESSON_LEVEL             NUMBER       
//			LESSON_START             DATE         
//			LESSON_END               DATE         
//			TEACHER_NAME             VARCHAR2(20) 
//			LESSON_TIME              NUMBER       
//			LESSON_DAY               VARCHAR2(40) 
//			LESSON_DURATION          NUMBER       
//			LESSON_CAPACITY          NUMBER  
			String sql = " SELECT LESSON_CODE, LESSON_TYPE, LESSON_LEVEL, LESSON_START, LESSON_END, TEACHER_NAME, LESSON_TIME, "
					+ " LESSON_DAY, LESSON_DURATION, LESSON_CAPACITY "
					+ " FROM LESSON WHERE LESSON_TYPE=1 AND LESSON_DAY IN ('월,수,금', '화,목') ORDER BY LESSON_CODE";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				// ? 처리
				rs = pstmt.executeQuery();
				// ResetSet처리
				if(rs.next()) {
					result = new ArrayList<LessonListDto>();
					do {
						LessonListDto dto = new LessonListDto(	
								rs.getInt("LESSON_CODE"),rs.getString("LESSON_TYPE"),rs.getInt("LESSON_LEVEL"),
								rs.getString("LESSON_START"),rs.getInt("LESSON_DURATION"),rs.getString("LESSON_END"),
								rs.getString("TEACHER_NAME"),rs.getInt("LESSON_TIME"),
								rs.getString("LESSON_DAY"),	rs.getInt("LESSON_CAPACITY")
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
		//select list - 강습-레벨업 LESSON_TYPE 1 주말반
		public List<LessonListDto> selectEndAllList(Connection conn){
			List<LessonListDto> result = null;
			String sql = " SELECT LESSON_CODE, LESSON_TYPE, LESSON_LEVEL, LESSON_START, LESSON_END, TEACHER_NAME, LESSON_TIME, "
					+ " LESSON_DAY, LESSON_DURATION, LESSON_CAPACITY "
					+ " FROM LESSON WHERE LESSON_TYPE=1 AND LESSON_DAY = '토,일' ORDER BY LESSON_CODE";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				// ? 처리
				rs = pstmt.executeQuery();
				// ResetSet처리
				if(rs.next()) {
					result = new ArrayList<LessonListDto>();
					do {
						LessonListDto dto = new LessonListDto(	
								rs.getInt("LESSON_CODE"),
								rs.getString("LESSON_TYPE"),rs.getInt("LESSON_LEVEL"),
								rs.getString("LESSON_START"),rs.getInt("LESSON_DURATION"),rs.getString("LESSON_END"),
								rs.getString("TEACHER_NAME"),rs.getInt("LESSON_TIME"),
								rs.getString("LESSON_DAY"),	rs.getInt("LESSON_CAPACITY")
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
		//select list - 강습-일일클래스 LESSON_TYPE 0
		public List<LessonOnedayDto> selectOnedayList(Connection conn){
			List<LessonOnedayDto> result = null;
			String sql = " SELECT LESSON_CODE, LESSON_TIME, LESSON_DAY, LESSON_CAPACITY "
				    + " FROM (SELECT * FROM LESSON WHERE LESSON_TYPE = 0 ORDER BY LESSON_TIME) ";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				// ? 처리
				rs = pstmt.executeQuery();
				// ResetSet처리
				if(rs.next()) {
					result = new ArrayList<LessonOnedayDto>();
					do {
						LessonOnedayDto dto = new LessonOnedayDto(	
								rs.getInt("LESSON_CODE"),rs.getInt("LESSON_TIME"),
								rs.getString("LESSON_DAY"),rs.getInt("LESSON_CAPACITY")
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
		//insert
		public int insert(Connection conn, LessonInsertDto dto) {
			int result = 0;
			String sql = "INSERT INTO MEM_LESSON (ID, LESSON_CODE)\r\n"
					+ "    VALUES (?, ?);";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				// ? 처리
				int i = 1;
				pstmt.setString(1, dto.getMemId());
				pstmt.setInt(2, dto.getLessonCode());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(pstmt);
			return result;
		}
		//insert - weekend
//		public int insertWeekend(Connection conn, LessonInsertDto dto) {
//			int result = 0;
//			String sql = "INSERT INTO LESSON VALUES (SEQ_LESSON_WEEKEND, 1, ?, ?, ?, ?, ?, ?, '토,일')";
//			PreparedStatement pstmt = null;
//			try {
//				pstmt = conn.prepareStatement(sql);
//				// ? 처리
//				int i = 1;
//				pstmt.setInt(1, dto.getLessonLevel());
//				pstmt.setString(2, dto.getLessonStart());
//				pstmt.setInt(3, dto.getLessonDuration());
//				pstmt.setString(4, dto.getLessonEnd());
//				pstmt.setString(5, dto.getTeacherName());
//				pstmt.setInt(6, dto.getLessonTime());
//				result = pstmt.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			close(pstmt);
//			return result;
//		}
		//insert - oneday
//		public int insertOneday(Connection conn, LessonInsertDto dto) {
//			int result = 0;
//			String sql = "INSERT INTO LESSON VALUES (SEQ_LESSON_ONEDAY, ?, ?, ?)";
//			PreparedStatement pstmt = null;
//			try {
//				pstmt = conn.prepareStatement(sql);
//				// ? 처리
//				int i = 1;
//				pstmt.setInt(1, dto.getLessonLevel());
//				pstmt.setInt(2, dto.getLessonTime());
//				pstmt.setString(3, dto.getLessonDay());
//				result = pstmt.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			close(pstmt);
//			return result;
//		}
		// insert oneday
//		public int insertOneday(Connection conn, String memId, int lessonCode) {
//			int result = 0;
//			String sql = "INSERT INTO MEM_LESSON (ID, LESSON_CODE)\r\n"
//					+ "    VALUES (?, ?)";
//			PreparedStatement pstmt = null;
//			try {
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, memId);
//				pstmt.setInt(2, lessonCode+1);
//				result = pstmt.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			close(pstmt);
//			return result;
//		}
		// update
//		public int update(Connection conn, String memId) {
//			int result = 0;
//			String sql = "";  //TODO
//			PreparedStatement pstmt = null;
//			try {
//				pstmt = conn.prepareStatement(sql);
//				// ? 처리
//				result = pstmt.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			close(pstmt);
//			return result;
//		}
		//delete
		public int deleteLesson(Connection conn, Integer lessonCode) {
			int result = 0;
			String sql = "DELETE FROM LESSON WHERE LESSON_CODE = ?";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				// ? 처리
				pstmt.setInt(1, lessonCode);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(pstmt);
			return result;
		}
	
}
