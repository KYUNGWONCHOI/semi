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
	private Integer lessonCapacity;
	@Override
	public String toString() {
		return "LessonInsertDto [memId=" + memId + ", lessonCapacity=" + lessonCapacity + "]";
	}
	public LessonInsertDto(String memId, Integer lessonCapacity) {
		super();
		this.memId = memId;
		this.lessonCapacity = lessonCapacity;
	}
	public String getMemId() {
		return memId;
	}
	public Integer getLessonCapacity() {
		return lessonCapacity;
	}
	
	
}
