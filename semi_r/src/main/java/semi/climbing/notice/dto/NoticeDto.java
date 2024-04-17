package semi.climbing.notice.dto;

public class NoticeDto {
//	NOTICE_NO      NOT NULL NUMBER         
//	NOTICE_TYPE    NOT NULL NUMBER(1)      
//	NOTICE_CONTENT          VARCHAR2(1000) 
//	BOARD_DATE     NOT NULL TIMESTAMP(6)   
//	BOARD_READ_NO  NOT NULL NUMBER 
//	NOTICE_SUBJECT NOT NULL VARCHAR2(100)
	
	private Integer noticeNo;
	private Integer noticeType;
	private String noticeSubject;
	private String noticeContent;
	private String boardDate;
	private Integer baordReadNo;
	@Override
	public String toString() {
		return "NoticeDto [noticeNo=" + noticeNo + ", noticeType=" + noticeType + ", noticeSubject=" + noticeSubject
				+ ", noticeContent=" + noticeContent + ", boardDate=" + boardDate + ", baordReadNo=" + baordReadNo
				+ "]";
	}
	public NoticeDto(Integer noticeNo, Integer noticeType, String noticeSubject, String noticeContent, String boardDate,
			Integer baordReadNo) {
		super();
		this.noticeNo = noticeNo;
		this.noticeType = noticeType;
		this.noticeSubject = noticeSubject;
		this.noticeContent = noticeContent;
		this.boardDate = boardDate;
		this.baordReadNo = baordReadNo;
	}
	public Integer getNoticeNo() {
		return noticeNo;
	}
	public Integer getNoticeType() {
		return noticeType;
	}
	public String getNoticeSubject() {
		return noticeSubject;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public Integer getBaordReadNo() {
		return baordReadNo;
	}
	
	
	
}
