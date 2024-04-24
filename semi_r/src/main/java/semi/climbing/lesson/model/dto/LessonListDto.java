package semi.climbing.lesson.model.dto;

public class LessonListDto {
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
	private String lessonType;
	private Integer lessonLevel;
	private String lessonStart;
	private Integer lessonDuration; 
	private String lessonEnd;
	private String teacherName;
	private Integer lessonTime;
	private String lessonDay;
	private Integer lessonCapacity;
	@Override
	public String toString() {
		return "LessonListDto [lessonCode=" + lessonCode + ", lessonType=" + lessonType + ", lessonLevel=" + lessonLevel
				+ ", lessonStart=" + lessonStart + ", lessonDuration=" + lessonDuration + ", lessonEnd=" + lessonEnd
				+ ", teacherName=" + teacherName + ", lessonTime=" + lessonTime + ", lessonDay=" + lessonDay
				+ ", lessonCapacity=" + lessonCapacity + "]";
	}
	public LessonListDto(Integer lessonCode, String lessonType, Integer lessonLevel, String lessonStart,
			Integer lessonDuration, String lessonEnd, String teacherName, Integer lessonTime, String lessonDay,
			Integer lessonCapacity) {
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
		this.lessonCapacity = lessonCapacity;
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
	public Integer getLessonCapacity() {
		return lessonCapacity;
	}
	
		
}
