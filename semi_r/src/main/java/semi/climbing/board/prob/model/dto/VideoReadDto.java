package semi.climbing.board.prob.model.dto;

public class VideoReadDto {
//	BOARD_PROB_NO   NOT NULL NUMBER        
//	VIDEO_NAME               VARCHAR2(100) 
//	VIDEO_SAVE_PATH          VARCHAR2(200) 
	private Integer boardProbNo;
	private String videoName;
	private String videoSaveName;
	@Override
	public String toString() {
		return "VideoReadDto [boardProbNo=" + boardProbNo + ", videoName=" + videoName + ", videoSaveName="
				+ videoSaveName + "]";
	}
	public VideoReadDto(Integer boardProbNo, String videoName, String videoSaveName) {
		super();
		this.boardProbNo = boardProbNo;
		this.videoName = videoName;
		this.videoSaveName = videoSaveName;
	}
	public Integer getBoardProbNo() {
		return boardProbNo;
	}
	public String getVideoName() {
		return videoName;
	}
	public String getVideoSaveName() {
		return videoSaveName;
	}
	
	
}
