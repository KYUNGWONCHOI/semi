package semi.climbing.lesson.model.dto;

public class LessonUpdateCapaDto {
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
	private Integer lessonCapacity;
	@Override
	public String toString() {
		return "LessonUpdateCapaDto [lessonCode=" + lessonCode + ", lessonCapacity=" + lessonCapacity + "]";
	}
	public LessonUpdateCapaDto(Integer lessonCode, Integer lessonCapacity) {
		super();
		this.lessonCode = lessonCode;
		this.lessonCapacity = lessonCapacity;
	}
	public Integer getLessonCode() {
		return lessonCode;
	}
	public Integer getLessonCapacity() {
		return lessonCapacity;
	}
	
	
}
