package semi.climbing.board.any.model.dto;

public class AnyReadDto {
//	BOARD_PROB_NO      NOT NULL NUMBER        
//	PROB_SECTOR                 VARCHAR2(20)  
//	PROB_LEVEL                  NUMBER        
//	VIDEO_ORIGIN_NAME           VARCHAR2(200) 
//	VIDEO_SAVE_PATH             VARCHAR2(200) 
//	PROB_CONTENT                VARCHAR2(200) 
//	BOARD_PROB_DATE    NOT NULL TIMESTAMP(6)  
//	BOARD_PROB_READ_NO NOT NULL NUMBER        
//	MEMBER_ID                 NOT NULL VARCHAR2(20)  
//	PROB_SUBJECT       NOT NULL VARCHAR2(100) 
	private Integer boardProbNo;
	private String probSubject;
	private String probSector;
	private Integer probLevel;
	private String probContent;
	private String boardProbDate;
	private Integer boardProbReadNo;
	private String memberId;
	private String videoOriginName;
	private String videoSavePath;
	//ProblemDto 와 같아서 안 쓸 듯
}
