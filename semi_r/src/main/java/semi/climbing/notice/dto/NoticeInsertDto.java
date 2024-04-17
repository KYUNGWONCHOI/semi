package semi.climbing.notice.dto;

import java.util.List;

public class NoticeInsertDto {
//	BOARD_NO       NOT NULL NUMBER         
//	NOTICE_TYPE    NOT NULL NUMBER(1)      
//	NOTICE_CONTENT          VARCHAR2(1000) 
//	BOARD_DATE     NOT NULL TIMESTAMP(6)   
//	BOARD_READ_NO  NOT NULL NUMBER 
//	NOTICE_SUBJECT NOT NULL VARCHAR2(100)
	private String noticeSubject;
	private String noticeContent;
	private List<FileWriteDto> fileList;
	
	@Override
	public String toString() {
		return "NoticeInsertDto [noticeSubject=" + noticeSubject + ", noticeContent=" + noticeContent + ", fileList="
				+ fileList + "]";
	}
	public NoticeInsertDto(String noticeSubject, String noticeContent, List<FileWriteDto> fileList) {
		super();
		this.noticeSubject = noticeSubject;
		this.noticeContent = noticeContent;
		this.fileList = fileList;
	}
	public String getNoticeSubject() {
		return noticeSubject;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public List<FileWriteDto> getFileList() {
		return fileList;
	}
	
	
	
	

}
