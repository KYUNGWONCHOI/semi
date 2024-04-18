package semi.climbing.lesson.model.dto;

public class LessonListDto {
//	LESSON_CODE  NOT NULL NUMBER       
//	LESSON_TYPE  NOT NULL CHAR(1)      
//	LESSON_LEVEL NOT NULL NUMBER       
//	LESSON_START NOT NULL DATE         
//	LESSON_END   NOT NULL DATE         
//	TEACHER_NAME NOT NULL VARCHAR2(20) 
//	LESSON_TIME  NOT NULL NUMBER       
//	LESSON_DAY   NOT NULL VARCHAR2(20) 
	
	private Integer lessonLevel;
	private String lessonStart;
	private String lessonEnd;
	private String teacherName;
	private Integer lessonTime;
	private String lessonDay;
}
