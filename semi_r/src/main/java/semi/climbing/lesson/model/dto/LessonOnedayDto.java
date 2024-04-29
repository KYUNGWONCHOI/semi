package semi.climbing.lesson.model.dto;


public class LessonOnedayDto {
//	LESSON_CODE     NOT NULL NUMBER       
//	LESSON_TYPE     NOT NULL CHAR(1)      
//	LESSON_LEVEL             NUMBER       
//	LESSON_START             DATE         
//	LESSON_END               DATE         
//	TEACHER_NAME             VARCHAR2(20) 
//	LESSON_TIME              NUMBER       
//	LESSON_DAY               VARCHAR2(40) 
//	LESSON_DURATION          NUMBER       
//	LESSON_CAPACITY          NUMBER 
	
	private Integer lessonCode;
	private String lessonTime;
	private String lessonDay;
	private Integer lessonCapacity;
	@Override
	public String toString() {
		return "LessonOnedayDto [lessonCode=" + lessonCode + ", lessonTime=" + lessonTime + ", lessonDay=" + lessonDay
				+ ", lessonCapacity=" + lessonCapacity + "]";
	}
	public LessonOnedayDto(Integer lessonCode, String lessonTime, String lessonDay, Integer lessonCapacity) {
		super();
		this.lessonCode = lessonCode;
		this.lessonTime = lessonTime;
		this.lessonDay = lessonDay;
		this.lessonCapacity = lessonCapacity;
	}
	public Integer getLessonCode() {
		return lessonCode;
	}
	public String getLessonTime() {
		return lessonTime;
	}
	public String getLessonDay() {
		return lessonDay;
	}
	public Integer getLessonCapacity() {
		return lessonCapacity;
	}
	
	
}
