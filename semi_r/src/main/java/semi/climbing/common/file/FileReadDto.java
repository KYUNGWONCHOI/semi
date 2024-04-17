package semi.climbing.common.file;

public class FileReadDto {
//	FILE_ORIGIN_NAME NOT NULL VARCHAR2(255) 
//	FILE_SAVE_PATH   NOT NULL VARCHAR2(255) 
//	BOARD_PROB_NO             NUMBER        
//	BOARD_ASK_NO              NUMBER        
//	BOARD_ANY_NO              NUMBER        
//	NOTICE_NO                 NUMBER  
	private String fileOriginName;
	private String fileSavePath;
	private Integer boardProbNo;
	private Integer boardAskNo;
	private Integer boardAnyNo;
	private Integer noticeNo;
	@Override
	public String toString() {
		return "FileReadDto [fileOriginName=" + fileOriginName + ", fileSavePath=" + fileSavePath + ", boardProbNo="
				+ boardProbNo + ", boardAskNo=" + boardAskNo + ", boardAnyNo=" + boardAnyNo + ", noticeNo=" + noticeNo
				+ "]";
	}
	public FileReadDto(String fileOriginName, String fileSavePath, Integer boardProbNo, Integer boardAskNo,
			Integer boardAnyNo, Integer noticeNo) {
		super();
		this.fileOriginName = fileOriginName;
		this.fileSavePath = fileSavePath;
		this.boardProbNo = boardProbNo;
		this.boardAskNo = boardAskNo;
		this.boardAnyNo = boardAnyNo;
		this.noticeNo = noticeNo;
	}
	public String getFileOriginName() {
		return fileOriginName;
	}
	public String getFileSavePath() {
		return fileSavePath;
	}
	public Integer getBoardProbNo() {
		return boardProbNo;
	}
	public Integer getBoardAskNo() {
		return boardAskNo;
	}
	public Integer getBoardAnyNo() {
		return boardAnyNo;
	}
	public Integer getNoticeNo() {
		return noticeNo;
	}
	
	
	
	
	
	
	
}
