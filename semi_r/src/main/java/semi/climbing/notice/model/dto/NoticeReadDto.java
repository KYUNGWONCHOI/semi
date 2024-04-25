package semi.climbing.notice.model.dto;

import java.util.List;

public class NoticeReadDto {
//	NOTICE_NO        NOT NULL NUMBER         
//	NOTICE_SUBJECT   NOT NULL VARCHAR2(100)  
//	NOTICE_CONTENT            VARCHAR2(1000) 
//	BOARD_DATE       NOT NULL TIMESTAMP(6)   
//	BOARD_READ_NO    NOT NULL NUMBER         
//	NOTICE_TYPE      NOT NULL NUMBER
	private Integer noticeNo;
	private String noticeSubject;
	private String noticeContent;
	private String boardDate;
	private Integer boardReadNo;
	private Integer noticeType;
	private List<FileReadDto> fileDtoList;
	@Override
	public String toString() {
		return "NoticeReadDto [noticeNo=" + noticeNo + ", noticeSubject=" + noticeSubject + ", noticeContent="
				+ noticeContent + ", boardDate=" + boardDate + ", boardReadNo=" + boardReadNo + ", noticeType="
				+ noticeType + ", fileDtoList=" + fileDtoList + "]";
	}
	public NoticeReadDto(Integer noticeNo, String noticeSubject, String noticeContent, String boardDate,
			Integer boardReadNo, Integer noticeType) {
		super();
		this.noticeNo = noticeNo;
		this.noticeSubject = noticeSubject;
//		noticeContent = noticeContent.replaceAll("\\r?\\n", "<br>");
//		noticeContent = noticeContent.replaceAll(" ", "&nbsp;");
		this.noticeContent = noticeContent;
		this.boardDate = boardDate;
		this.boardReadNo = boardReadNo;
		this.noticeType = noticeType;
	}
	public Integer getNoticeNo() {
		return noticeNo;
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
	public Integer getBoardReadNo() {
		return boardReadNo;
	}
	public Integer getNoticeType() {
		return noticeType;
	}
	public List<FileReadDto> getFileDtoList() {
		return fileDtoList;
	}
	public void setFileDtoList(List<FileReadDto> fileDtoList) {
		this.fileDtoList = fileDtoList;
	}
	
	
	

}
