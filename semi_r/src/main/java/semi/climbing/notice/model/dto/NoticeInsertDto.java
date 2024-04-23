package semi.climbing.notice.model.dto;

import java.util.List;

public class NoticeInsertDto {
//	NOTICE_NO      NOT NULL NUMBER         
//	NOTICE_SUBJECT NOT NULL VARCHAR2(100)  
//	NOTICE_CONTENT          VARCHAR2(2000) 
//	BOARD_DATE     NOT NULL TIMESTAMP(6)   
//	BOARD_READ_NO  NOT NULL NUMBER         
//	NOTICE_TYPE    NOT NULL NUMBER
	private String noticeSubject;
	private String noticeContent;
	private Integer noticeType;
	
	private List<FileWriteDto> fileList;

	@Override
	public String toString() {
		return "NoticeInsertDto [noticeSubject=" + noticeSubject + ", noticeContent=" + noticeContent + ", noticeType="
				+ noticeType + ", fileList=" + fileList + "]";
	}

	public NoticeInsertDto(String noticeSubject, String noticeContent, Integer noticeType,
			List<FileWriteDto> fileList) {
		super();
		this.noticeSubject = noticeSubject;
		this.noticeContent = noticeContent;
		this.noticeType = noticeType;
		this.fileList = fileList;
	}

	public List<FileWriteDto> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileWriteDto> fileList) {
		this.fileList = fileList;
	}

	public String getNoticeSubject() {
		return noticeSubject;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public Integer getNoticeType() {
		return noticeType;
	}

}
