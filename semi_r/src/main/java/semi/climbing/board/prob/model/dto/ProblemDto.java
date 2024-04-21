package semi.climbing.board.prob.model.dto;

public class ProblemDto {
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
	@Override
	public String toString() {
		return "ProblemDto [boardProbNo=" + boardProbNo + ", probSubject=" + probSubject + ", probSector=" + probSector
				+ ", probLevel=" + probLevel + ", probContent=" + probContent + ", boardProbDate=" + boardProbDate
				+ ", boardProbReadNo=" + boardProbReadNo + ", memberId=" + memberId + ", videoOriginName="
				+ videoOriginName + ", videoSavePath=" + videoSavePath + "]";
	}
	public ProblemDto(Integer boardProbNo, String probSubject, String probSector, Integer probLevel, String probContent,
			String boardProbDate, Integer boardProbReadNo, String memberId, String videoOriginName,
			String videoSavePath) {
		super();
		this.boardProbNo = boardProbNo;
		this.probSubject = probSubject;
		this.probSector = probSector;
		this.probLevel = probLevel;
		this.probContent = probContent;
		this.boardProbDate = boardProbDate;
		this.boardProbReadNo = boardProbReadNo;
		this.memberId = memberId;
		this.videoOriginName = videoOriginName;
		this.videoSavePath = videoSavePath;
	}
	public final Integer getBoardProbNo() {
		return boardProbNo;
	}
	public final String getProbSubject() {
		return probSubject;
	}
	public final String getProbSector() {
		return probSector;
	}
	public final Integer getProbLevel() {
		return probLevel;
	}
	public final String getProbContent() {
		return probContent;
	}
	public final String getBoardProbDate() {
		return boardProbDate;
	}
	public final Integer getBoardProbReadNo() {
		return boardProbReadNo;
	}
	public final String getMemberId() {
		return memberId;
	}
	public final String getVideoOriginName() {
		return videoOriginName;
	}
	public final String getVideoSavePath() {
		return videoSavePath;
	}
	
	
}
