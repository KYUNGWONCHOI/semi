package semi.climbing.lesson.model.dto;

public class LessonInsertDto {
//	LESSON_CODE     NOT NULL NUMBER       
//	LESSON_TYPE     NOT NULL CHAR(1)      
//	LESSON_LEVEL    NOT NULL NUMBER       
//	LESSON_START    NOT NULL DATE         
//	LESSON_END      NOT NULL DATE         
//	TEACHER_NAME    NOT NULL VARCHAR2(20) 
//	LESSON_TIME     NOT NULL NUMBER       
//	LESSON_DAY      NOT NULL VARCHAR2(20) 
//	LESSON_DURATION          NUMBER
	private Integer lessonCode;
	private String lessonType;
	private Integer lessonLevel;
	private String lessonStart;
	private Integer lessonDuration;
	private String lessonEnd;
	private String teacherName;
	private Integer lessonTime;
	private String lessonDay;
	@Override
	public String toString() {
		return "LessonInsertDto [lessonCode=" + lessonCode + ", lessonType=" + lessonType + ", lessonLevel="
				+ lessonLevel + ", lessonStart=" + lessonStart + ", lessonDuration=" + lessonDuration + ", lessonEnd="
				+ lessonEnd + ", teacherName=" + teacherName + ", lessonTime=" + lessonTime + ", lessonDay=" + lessonDay
				+ "]";
	}
	public LessonInsertDto(Integer lessonCode, String lessonType, Integer lessonLevel, String lessonStart,
			Integer lessonDuration, String lessonEnd, String teacherName, Integer lessonTime, String lessonDay) {
		super();
		this.lessonCode = lessonCode;
		this.lessonType = lessonType;
		this.lessonLevel = lessonLevel;
		this.lessonStart = lessonStart;
		this.lessonDuration = lessonDuration;
		this.lessonEnd = lessonEnd;
		this.teacherName = teacherName;
		this.lessonTime = lessonTime;
		this.lessonDay = lessonDay;
	}
	public Integer getLessonCode() {
		return lessonCode;
	}
	public String getLessonType() {
		return lessonType;
	}
	public Integer getLessonLevel() {
		return lessonLevel;
	}
	public String getLessonStart() {
		return lessonStart;
	}
	public Integer getLessonDuration() {
		return lessonDuration;
	}
	public String getLessonEnd() {
		return lessonEnd;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public Integer getLessonTime() {
		return lessonTime;
	}
	public String getLessonDay() {
		return lessonDay;
	}
		
}
