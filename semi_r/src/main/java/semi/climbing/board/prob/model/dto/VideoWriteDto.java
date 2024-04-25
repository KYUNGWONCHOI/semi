package semi.climbing.board.prob.model.dto;

public class VideoWriteDto {
//	BOARD_PROB_NO   NOT NULL NUMBER        
//	VIDEO_NAME               VARCHAR2(100) 
//	VIDEO_SAVE_PATH          VARCHAR2(200) 
	private String videoName;
	private String videSavePath;
	@Override
	public String toString() {
		return "VideoWriteDto [videoName=" + videoName + ", videSavePath=" + videSavePath + "]";
	}
	public VideoWriteDto(String videoName, String videSavePath) {
		super();
		this.videoName = videoName;
		this.videSavePath = videSavePath;
	}
	public String getVideoName() {
		return videoName;
	}
	public String getVideSavePath() {
		return videSavePath;
	}
	
	
}