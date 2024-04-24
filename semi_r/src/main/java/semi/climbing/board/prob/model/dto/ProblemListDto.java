package semi.climbing.board.prob.model.dto;

public class ProblemListDto {
//	BOARD_PROB_NO      NOT NULL NUMBER        
//	PROB_SECTOR                 VARCHAR2(20)  
//	PROB_LEVEL                  NUMBER        
//	PROB_CONTENT                VARCHAR2(200) 
//	BOARD_PROB_DATE    NOT NULL TIMESTAMP(6)  
//	BOARD_PROB_READ_NO NOT NULL NUMBER        
//	MEMBER_ID                 NOT NULL VARCHAR2(20)  
//	PROB_SUBJECT       NOT NULL VARCHAR2(100) 
	private String probSubject;
	private String probSector;
	private Integer probLevel;
	private String boardProbDate;
	private Integer boardProbReadNo;
	private String memberId;
	private Integer boardType;
	@Override
	public String toString() {
		return "ProblemListDto [probSubject=" + probSubject + ", probSector=" + probSector + ", probLevel=" + probLevel
				+ ", boardProbDate=" + boardProbDate + ", boardProbReadNo=" + boardProbReadNo + ", memberId=" + memberId
				+ ", boardType=" + boardType + "]";
	}
	public ProblemListDto(String probSubject, String probSector, Integer probLevel, String boardProbDate,
			Integer boardProbReadNo, String memberId, Integer boardType) {
		super();
		this.probSubject = probSubject;
		this.probSector = probSector;
		this.probLevel = probLevel;
		this.boardProbDate = boardProbDate;
		this.boardProbReadNo = boardProbReadNo;
		this.memberId = memberId;
		this.boardType = boardType;
	}
	public String getProbSubject() {
		return probSubject;
	}
	public String getProbSector() {
		return probSector;
	}
	public Integer getProbLevel() {
		return probLevel;
	}
	public String getBoardProbDate() {
		return boardProbDate;
	}
	public Integer getBoardProbReadNo() {
		return boardProbReadNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public Integer getBoardType() {
		return boardType;
	}
	
	
}
