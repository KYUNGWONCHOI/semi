package semi.climbing.lesson.service;

import static semi.climbing.jdbc.common.JdbcTemplate.*;
import java.sql.Connection;
import java.util.List;

import semi.climbing.lesson.model.dao.LessonDao;
import semi.climbing.lesson.model.dto.LessonInsertDto;
import semi.climbing.lesson.model.dto.LessonListDto;
import semi.climbing.lesson.model.dto.LessonOnedayDto;

public class LessonService {
	private LessonDao dao = new LessonDao();
	
	//select all
	public List<LessonListDto> selectAllList(){
		List<LessonListDto> result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectAllList(conn);
		close(conn);
		return result;	
	}
	//select weekday
	public List<LessonListDto> selectDayAllList(){
		List<LessonListDto> result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectDayAllList(conn);
		close(conn);
		return result;	
	}
	//select weekend
	public List<LessonListDto> selectEndAllList(){
		List<LessonListDto> result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectEndAllList(conn);
		close(conn);
		return result;	
	}
	//select oneday
	public List<LessonOnedayDto> selectOnedayList(){
		List<LessonOnedayDto> result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectOnedayList(conn);
		close(conn);
		return result;
	}
	//insert weekday
	public int insert(LessonInsertDto dto) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.insert(conn, dto);
		close(conn);
		return result;		
	}
	//insert weekend
//	public int insertWeekend(LessonInsertDto dto) {
//		int result = 0;
//		Connection conn = getSemiConnection(true);
//		result = dao.insertWeekend(conn, dto);
//		close(conn);
//		return result;
//	}
	//insert oneday
//	public int insertOneday(LessonInsertDto dto) {
//		int result = 0;
//		Connection conn = getSemiConnection(true);
//		result = dao.insertOneday(conn, dto);
//		close(conn);
//		return result;
//	}
	// update oneday
//	public int insertOneday(String memId, int lessonCode) {
//		int result = 0;
//		Connection conn = getSemiConnection(true);
//		result = dao.insertOneday(conn, memId, lessonCode);
//		close(conn);
//		return result;
//	}
	// update
//	public int update(String dto) {
//		int result = 0;
//		Connection conn = getSemiConnection(true);
//		result = dao.update(conn, dto);
//		close(conn);
//		return result;
//	}
	//delete
	public int deleteLesson(Integer lessonCode) {
		int result = 0;
		Connection conn = null;
		result = dao.deleteLesson(conn, lessonCode);
		close(conn);
		return result;		
	}
}
