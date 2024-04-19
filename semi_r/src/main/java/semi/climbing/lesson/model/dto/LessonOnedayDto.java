package semi.climbing.lesson.model.dto;


public class LessonOnedayDto {
//	LESSON_CODE  NOT NULL NUMBER       
//	LESSON_TYPE  NOT NULL CHAR(1)      
//	LESSON_LEVEL NOT NULL NUMBER       
//	LESSON_START NOT NULL DATE         
//	LESSON_END   NOT NULL DATE         
//	TEACHER_NAME NOT NULL VARCHAR2(20) 
//	LESSON_TIME  NOT NULL NUMBER       
//	LESSON_DAY   NOT NULL VARCHAR2(20) 
	
	private Integer lessonLevel;	
	private Integer lessonTime;
	private String lessonDay;
	@Override
	public String toString() {
		return "LessonOnedayDto [lessonLevel=" + lessonLevel + ", lessonTime=" + lessonTime + ", lessonDay=" + lessonDay
				+ "]";
	}
	public LessonOnedayDto(Integer lessonLevel, Integer lessonTime, String lessonDay) {
		super();
		this.lessonLevel = lessonLevel;
		this.lessonTime = lessonTime;
		this.lessonDay = lessonDay;
	}
	public Integer getLessonLevel() {
		return lessonLevel;
	}
	public Integer getLessonTime() {
		return lessonTime;
	}
	public String getLessonDay() {
		return lessonDay;
	}
	
	
	
}
