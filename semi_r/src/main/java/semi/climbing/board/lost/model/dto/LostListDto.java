package semi.climbing.board.lost.model.dto;

public class LostListDto {
//	BOARD_NO     NOT NULL NUMBER         
//	LOST_TYPE    NOT NULL VARCHAR2(20)   
//	LOST_PLACE            VARCHAR2(20)   
//	LOST_TIME             TIMESTAMP(6)   
//	BOARD_DATE   NOT NULL DATE           
//	LOST_SUBJECT NOT NULL VARCHAR2(100)  
//	LOST_CONTENT NOT NULL VARCHAR2(1000)	 
//	FILE_ORIGIN_NAME          VARCHAR2(100)  
//	FILE_SAVE_PATH            VARCHAR2(100)  
	
	private Integer baordNo;
	private String lostSubject;
	private String boardDate;
	private String fileSavePath;
	@Override
	public String toString() {
		return "LostListDto [baordNo=" + baordNo + ", lostSubject=" + lostSubject + ", boardDate=" + boardDate
				+ ", fileSavePath=" + fileSavePath + "]";
	}
	public LostListDto(Integer baordNo, String lostSubject, String boardDate, String fileSavePath) {
		super();
		this.baordNo = baordNo;
		this.lostSubject = lostSubject;
		this.boardDate = boardDate;
		this.fileSavePath = fileSavePath;
	}
	public Integer getBaordNo() {
		return baordNo;
	}
	public String getLostSubject() {
		return lostSubject;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public String getFileSavePath() {
		return fileSavePath;
	}
	
	

}
