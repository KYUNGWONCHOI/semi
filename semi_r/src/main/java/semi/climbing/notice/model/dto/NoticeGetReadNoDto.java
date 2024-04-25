package semi.climbing.notice.model.dto;

public class NoticeGetReadNoDto {

	private Integer boardReadNo;

	@Override
	public String toString() {
		return "NoticeGetReadNoDto [boardReadNo=" + boardReadNo + "]";
	}

	public NoticeGetReadNoDto(Integer boardReadNo) {
		super();
		this.boardReadNo = boardReadNo;
	}

	public Integer getBoardReadNo() {
		return boardReadNo;
	}
	
}
