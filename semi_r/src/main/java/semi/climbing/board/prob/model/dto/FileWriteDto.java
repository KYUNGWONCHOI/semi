package semi.climbing.board.prob.model.dto;

public class FileWriteDto {
	private String fileSavePath;
	private String fileOriginName;
	@Override
	public String toString() {
		return "FileWriteDto [fileSavePath=" + fileSavePath + ", fileOriginName=" + fileOriginName + "]";
	}
	public FileWriteDto(String fileSavePath, String fileOriginName) {
		super();
		this.fileSavePath = fileSavePath;
		this.fileOriginName = fileOriginName;
	}
	public String getFileSavePath() {
		return fileSavePath;
	}
	public String getFileOriginName() {
		return fileOriginName;
	}
	
	
}