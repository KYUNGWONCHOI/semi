package semi.climbing.lesson.model.dto;

public class LessonInsertDto {
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
	private String memId;
	private Integer lessonCode;
	@Override
	public String toString() {
		return "LessonInsertDto [memId=" + memId + ", lessonCode=" + lessonCode + "]";
	}
	public LessonInsertDto(String memId, Integer lessonCode) {
		super();
		this.memId = memId;
		this.lessonCode = lessonCode;
	}
	public String getMemId() {
		return memId;
	}
	public Integer getLessonCode() {
		return lessonCode;
	}


}
