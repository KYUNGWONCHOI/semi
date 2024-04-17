package semi.climbing.notice.model.dto;

public class NoticeListDto {
//	NOTICE_NO      NOT NULL NUMBER         
//	NOTICE_TYPE    NOT NULL NUMBER(1)      
//	NOTICE_CONTENT          VARCHAR2(1000) 
//	BOARD_DATE     NOT NULL TIMESTAMP(6)   
//	BOARD_READ_NO  NOT NULL NUMBER 
//	NOTICE_SUBJECT NOT NULL VARCHAR2(100)
	private Integer noticeNo;
	private String noticeSubject;
	private String boardDate;
	private Integer baordReadNo;
	private Integer noticeType;
	
	
	@Override
	public String toString() {
		return "NoticeListDto [noticeNo=" + noticeNo + ", noticeSubject=" + noticeSubject + ", boardDate=" + boardDate
				+ ", baordReadNo=" + baordReadNo + ", noticeType=" + noticeType + "]";
	}


	public NoticeListDto(Integer noticeNo, String noticeSubject, String boardDate, Integer baordReadNo,
			Integer noticeType) {
		super();
		this.noticeNo = noticeNo;
		this.noticeSubject = noticeSubject;
		this.boardDate = boardDate;
		this.baordReadNo = baordReadNo;
		this.noticeType = noticeType;
	}


	public Integer getNoticeNo() {
		return noticeNo;
	}


	public String getNoticeSubject() {
		return noticeSubject;
	}


	public String getBoardDate() {
		return boardDate;
	}


	public Integer getBaordReadNo() {
		return baordReadNo;
	}


	public Integer getNoticeType() {
		return noticeType;
	}
	
	
	

}
