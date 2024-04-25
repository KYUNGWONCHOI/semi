package semi.climbing.notice.model.dto;

public class FileWriteDto {
	private String fileSavePath;
	private String fileName;
	@Override
	public String toString() {
		return "FileWriteDto [fileSavePath=" + fileSavePath + ", fileName=" + fileName + "]";
	}
	public FileWriteDto(String fileSavePath, String fileName) {
		super();
		this.fileSavePath = fileSavePath;
		this.fileName = fileName;
	}
	public String getFileSavePath() {
		return fileSavePath;
	}
	public String getFileName() {
		return fileName;
	}
	
}