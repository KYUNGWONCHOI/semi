package semi.climbing.board.prob.model.dto;

public class ProblemDto {
//	BOARD_PROB_NO      NOT NULL NUMBER
//	PROB_SECTOR                 VARCHAR2(20)  
//	PROB_LEVEL                  NUMBER        
//	VIDEO_ORIGIN_NAME           VARCHAR2(200) 
//	VIDEO_SAVE_PATH             VARCHAR2(200) 
//	PROB_CONTENT                VARCHAR2(200) 
//	BOARD_PROB_DATE    NOT NULL DATE          
//	BOARD_PROB_READ_NO NOT NULL NUMBER        
//	ID                 NOT NULL VARCHAR2(20)
	private Integer boardProbNo;
	private String probSector;
	private Integer probLevel;
	private String videoOriginName;
	private String videoSavePath;
	private String probContent;
	private String boardProbDate;
	private Integer boardProbReadNo;
	private String id;
	@Override
	public String toString() {
		return "ProblemDto [boardProbNo=" + boardProbNo + ", probSector=" + probSector + ", probLevel=" + probLevel
				+ ", videoOriginName=" + videoOriginName + ", videoSavePath=" + videoSavePath + ", probContent="
				+ probContent + ", boardProbDate=" + boardProbDate + ", boardProbReadNo=" + boardProbReadNo + ", id="
				+ id + "]";
	}
	public ProblemDto(Integer boardProbNo, String probSector, Integer probLevel, String videoOriginName,
			String videoSavePath, String probContent, String boardProbDate, Integer boardProbReadNo, String id) {
		super();
		this.boardProbNo = boardProbNo;
		this.probSector = probSector;
		this.probLevel = probLevel;
		this.videoOriginName = videoOriginName;
		this.videoSavePath = videoSavePath;
		this.probContent = probContent;
		this.boardProbDate = boardProbDate;
		this.boardProbReadNo = boardProbReadNo;
		this.id = id;
	}
	public Integer getBoardProbNo() {
		return boardProbNo;
	}
	public String getProbSector() {
		return probSector;
	}
	public Integer getProbLevel() {
		return probLevel;
	}
	public String getVideoOriginName() {
		return videoOriginName;
	}
	public String getVideoSavePath() {
		return videoSavePath;
	}
	public String getProbContent() {
		return probContent;
	}
	public String getBoardProbDate() {
		return boardProbDate;
	}
	public Integer getBoardProbReadNo() {
		return boardProbReadNo;
	}
	public String getId() {
		return id;
	}
	
}
