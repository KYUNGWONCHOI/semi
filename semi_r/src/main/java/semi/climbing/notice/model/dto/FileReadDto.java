package semi.climbing.notice.model.dto;

public class FileReadDto {
//	FILE_ORIGIN_NAME NOT NULL VARCHAR2(255) 
//	FILE_SAVE_PATH   NOT NULL VARCHAR2(255) 
//	BOARD_PROB_NO             NUMBER        
//	BOARD_ASK_NO              NUMBER        
//	BOARD_ANY_NO              NUMBER        
//	NOTICE_NO                 NUMBER  
	private Integer noticeNo;
	private String fileOriginName;
	private String fileSavePath;
	@Override
	public String toString() {
		return "FileReadDto [noticeNo=" + noticeNo + ", fileOriginName=" + fileOriginName + ", fileSavePath="
				+ fileSavePath + "]";
	}
	public FileReadDto(Integer noticeNo, String fileOriginName, String fileSavePath) {
		super();
		this.noticeNo = noticeNo;
		this.fileOriginName = fileOriginName;
		this.fileSavePath = fileSavePath;
	}
	public Integer getNoticeNo() {
		return noticeNo;
	}
	public String getFileOriginName() {
		return fileOriginName;
	}
	public String getFileSavePath() {
		return fileSavePath;
	}
	
	
	
}
