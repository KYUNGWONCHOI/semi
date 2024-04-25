package semi.climbing.board.prob.model.dto;

import java.util.List;

public class ProblemReadDto {
//	BOARD_PROB_NO      NOT NULL NUMBER        
//	BOARD_TYPE         NOT NULL NUMBER        
//	PROB_SECTOR                 VARCHAR2(20)  
//	PROB_LEVEL                  NUMBER        
//	PROB_CONTENT                VARCHAR2(400) 
//	BOARD_PROB_DATE    NOT NULL TIMESTAMP(6)  
//	BOARD_PROB_READ_NO NOT NULL NUMBER        
//	PROB_SUBJECT       NOT NULL VARCHAR2(100) 
//	MEMBER_ID          NOT NULL VARCHAR2(20)  
	private Integer boardProbNo;
	private String probSubject;
	private String probSector;
	private Integer probLevel;
	private String probContent;
	private String boardProbDate;
	private Integer boardProbReadNo;
	private String memberId;
	private Integer boardType;
	private List<VideoReadDto> videoDtoList;
	@Override
	public String toString() {
		return "ProblemReadDto [boardProbNo=" + boardProbNo + ", probSubject=" + probSubject + ", probSector="
				+ probSector + ", probLevel=" + probLevel + ", probContent=" + probContent + ", boardProbDate="
				+ boardProbDate + ", boardProbReadNo=" + boardProbReadNo + ", memberId=" + memberId + ", boardType="
				+ boardType + "]";
	}
	public ProblemReadDto(Integer boardProbNo, String probSubject, String probSector, Integer probLevel,
			String probContent, String boardProbDate, Integer boardProbReadNo, String memberId, Integer boardType) {
		super();
		this.boardProbNo = boardProbNo;
		this.probSubject = probSubject;
		this.probSector = probSector;
		this.probLevel = probLevel;
		this.probContent = probContent;
		this.boardProbDate = boardProbDate;
		this.boardProbReadNo = boardProbReadNo;
		this.memberId = memberId;
		this.boardType = boardType;
	}
	public Integer getBoardProbNo() {
		return boardProbNo;
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
	public String getProbContent() {
		return probContent;
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
	public List<VideoReadDto> getVideoDtoList() {
		return videoDtoList;
	}
	public void setVideoDtoList(List<VideoReadDto> videoDtoList) {
		this.videoDtoList = videoDtoList;
	}
	
	
}
