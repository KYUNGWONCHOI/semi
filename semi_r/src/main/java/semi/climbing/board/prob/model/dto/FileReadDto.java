package semi.climbing.board.prob.model.dto;

public class FileReadDto {
//	NOTICE_NO        NOT NULL NUMBER        
//	FILE_SAVE_PATH            VARCHAR2(100) 
//	FILE_ORIGIN_NAME          VARCHAR2(200) 
	private Integer noticeNo;
	private String fileSavePath;
	private String fileOriginName;
	@Override
	public String toString() {
		return "FileReadDto [noticeNo=" + noticeNo + ", fileSavePath=" + fileSavePath + ", fileOriginName="
				+ fileOriginName + "]";
	}
	public FileReadDto(Integer noticeNo, String fileSavePath, String fileOriginName) {
		super();
		this.noticeNo = noticeNo;
		this.fileSavePath = fileSavePath;
		this.fileOriginName = fileOriginName;
	}
	public final Integer getNoticeNo() {
		return noticeNo;
	}
	public final String getFileSavePath() {
		return fileSavePath;
	}
	public final String getFileOriginName() {
		return fileOriginName;
	}
	
	
	
}
