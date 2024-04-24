package semi.climbing.board.prob.model.dto;

import java.util.List;

public class ProblemInsertDto {
//	BOARD_PROB_NO      NOT NULL NUMBER        
//	PROB_SECTOR                 VARCHAR2(20)  
//	PROB_LEVEL                  NUMBER        
//	PROB_CONTENT                VARCHAR2(200) 
//	BOARD_PROB_DATE    NOT NULL DATE          
//	BOARD_PROB_READ_NO NOT NULL NUMBER        
//	PROB_SUBJECT       NOT NULL VARCHAR2(100) 
//	MEMBER_ID          NOT NULL VARCHAR2(20)  
//	BOARD_TYPE         NOT NULL NUMBER    
	private String probSubject;
	private String probSector;
	private Integer probLevel;
	private String probContent;
	private String memberId;
	private Integer boardType;
	
	private List<FileWriteDto> fileList;

	@Override
	public String toString() {
		return "ProblemInsertDto [probSubject=" + probSubject + ", probSector=" + probSector + ", probLevel="
				+ probLevel + ", probContent=" + probContent + ", memberId=" + memberId + ", boardType=" + boardType
				+ ", fileList=" + fileList + "]";
	}

	public ProblemInsertDto(String probSubject, String probSector, Integer probLevel, String probContent,
			String memberId, Integer boardType, List<FileWriteDto> fileList) {
		super();
		this.probSubject = probSubject;
		this.probSector = probSector;
		this.probLevel = probLevel;
		this.probContent = probContent;
		this.memberId = memberId;
		this.boardType = boardType;
		this.fileList = fileList;
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

	public String getMemberId() {
		return memberId;
	}

	public Integer getBoardType() {
		return boardType;
	}

	public List<FileWriteDto> getFileList() {
		return fileList;
	}
	
	
	
}
