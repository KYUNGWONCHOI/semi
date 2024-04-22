package semi.climbing.board.lost.model.dto;

public class LostDto {
//	BOARD_NO         NOT NULL NUMBER         
//	LOST_TYPE        NOT NULL VARCHAR2(20)   
//	LOST_PLACE                VARCHAR2(20)   
//	LOST_TIME                 TIMESTAMP(6)   
//	BOARD_DATE       NOT NULL DATE           
//	LOST_SUBJECT     NOT NULL VARCHAR2(100)  
//	LOST_CONTENT     NOT NULL VARCHAR2(1000) 
//	FILE_ORIGIN_NAME          VARCHAR2(100)  
//	FILE_SAVE_PATH            VARCHAR2(100)  
	private Integer boardNo;
	private String lostType;
	private String lostPlace;
	private String lostTime;
	private String boardDate;
	private String lostSubject;
	private String lostContent;
	private String fileOriginName;
	private String fileSavePath;
	@Override
	public String toString() {
		return "LostDto [boardNo=" + boardNo + ", lostType=" + lostType + ", lostPlace=" + lostPlace + ", lostTime="
				+ lostTime + ", boardDate=" + boardDate + ", lostSubject=" + lostSubject + ", lostContent="
				+ lostContent + ", fileOriginName=" + fileOriginName + ", fileSavePath=" + fileSavePath + "]";
	}
	public LostDto(Integer boardNo, String lostType, String lostPlace, String lostTime, String boardDate,
			String lostSubject, String lostContent, String fileOriginName, String fileSavePath) {
		super();
		this.boardNo = boardNo;
		this.lostType = lostType;
		this.lostPlace = lostPlace;
		this.lostTime = lostTime;
		this.boardDate = boardDate;
		this.lostSubject = lostSubject;
		this.lostContent = lostContent;
		this.fileOriginName = fileOriginName;
		this.fileSavePath = fileSavePath;
	}
	public Integer getBoardNo() {
		return boardNo;
	}
	public String getLostType() {
		return lostType;
	}
	public String getLostPlace() {
		return lostPlace;
	}
	public String getLostTime() {
		return lostTime;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public String getLostSubject() {
		return lostSubject;
	}
	public String getLostContent() {
		return lostContent;
	}
	public String getFileOriginName() {
		return fileOriginName;
	}
	public String getFileSavePath() {
		return fileSavePath;
	}
	
	
	
	
	
}
