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
import semi.climbing.notice.model.dto.FileWriteDto;

public class LessonDao {
	
	//select list - 강습-레벨업 LESSON_TYPE 1
	public List<LessonListDto> selectAllList(Connection conn){
		List<LessonListDto> result = null;
		String sql = "SELECT ROWNUM, LESSON_LEVEL, LESSON_START, LESSON_DURATION, LESSON_END, TEACHER_NAME, LESSON_TIME, LESSON_DAY\r\n"
				+ "FROM( SELECT * FROM LESSON WHERE LESSON_TYPE=1 ORDER BY LESSON_START)";
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
							rs.getInt("LESSON_LEVEL"),
							rs.getString("LESSON_START"),rs.getInt("LESSON_DURATION"),
							rs.getString("LESSON_END"),rs.getString("TEACHER_NAME"),
							rs.getInt("LESSON_TIME"),rs.getString("LESSON_DAY")
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
			String sql = "SELECT ROWNUM, LESSON_LEVEL, LESSON_START, LESSON_DURATION, LESSON_END, TEACHER_NAME, LESSON_TIME, LESSON_DAY\r\n"
					+ "    FROM (SELECT * FROM LESSON WHERE LESSON_TYPE=1 AND LESSON_DAY IN ('월,수,금', '화,목'))";
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
								rs.getInt("LESSON_LEVEL"),
								rs.getString("LESSON_START"),rs.getInt("LESSON_DURATION"),
								rs.getString("LESSON_END"),rs.getString("TEACHER_NAME"),
								rs.getInt("LESSON_TIME"),rs.getString("LESSON_DAY")
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
			String sql = "SELECT ROWNUM, LESSON_LEVEL, LESSON_START, LESSON_DURATION, LESSON_END, TEACHER_NAME, LESSON_TIME, LESSON_DAY\r\n"
					+ "    FROM (SELECT * FROM LESSON WHERE LESSON_TYPE=1 AND LESSON_DAY ='토,일')";
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
								rs.getInt("LESSON_LEVEL"),
								rs.getString("LESSON_START"),rs.getInt("LESSON_DURATION"),
								rs.getString("LESSON_END"),rs.getString("TEACHER_NAME"),
								rs.getInt("LESSON_TIME"),rs.getString("LESSON_DAY")
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
			String sql = "SELECT ROWNUM, LESSON_LEVEL, LESSON_TIME, LESSON_DAY"
				    + " FROM (SELECT * FROM LESSON WHERE LESSON_TYPE = 0 ORDER BY LESSON_TIME)";
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
								rs.getInt("LESSON_LEVEL"),
								rs.getInt("LESSON_TIME"),rs.getString("LESSON_DAY")
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
		//insert - weekday
		public int insertWeekday(Connection conn, LessonInsertDto dto) {
			int result = 0;
			String sql = "INSERT INTO LESSON VALUES (SEQ_LESSON_WEEKDAY, 1, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				// ? 처리
				int i = 1;
				pstmt.setInt(1, dto.getLessonLevel());
				pstmt.setString(2, dto.getLessonStart());
				pstmt.setInt(3, dto.getLessonDuration());
				pstmt.setString(4, dto.getLessonEnd());
				pstmt.setString(5, dto.getTeacherName());
				pstmt.setInt(6, dto.getLessonTime());
				pstmt.setString(7, dto.getLessonDay());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(pstmt);
			return result;
		}
		//insert - weekend
		public int insertWeekend(Connection conn, LessonInsertDto dto) {
			int result = 0;
			String sql = "INSERT INTO LESSON VALUES (SEQ_LESSON_WEEKEND, 1, ?, ?, ?, ?, ?, ?, '토,일')";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				// ? 처리
				int i = 1;
				pstmt.setInt(1, dto.getLessonLevel());
				pstmt.setString(2, dto.getLessonStart());
				pstmt.setInt(3, dto.getLessonDuration());
				pstmt.setString(4, dto.getLessonEnd());
				pstmt.setString(5, dto.getTeacherName());
				pstmt.setInt(6, dto.getLessonTime());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(pstmt);
			return result;
		}
		//insert - oneday
		public int insertOneday(Connection conn, LessonInsertDto dto) {
			int result = 0;
			String sql = "INSERT INTO LESSON VALUES (SEQ_LESSON_ONEDAY, ?, ?, ?)";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				// ? 처리
				int i = 1;
				pstmt.setInt(1, dto.getLessonLevel());
				pstmt.setInt(2, dto.getLessonTime());
				pstmt.setString(3, dto.getLessonDay());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(pstmt);
			return result;
		}
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
