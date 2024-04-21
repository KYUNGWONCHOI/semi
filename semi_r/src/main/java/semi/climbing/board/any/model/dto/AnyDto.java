package semi.climbing.board.any.model.dto;

public class AnyDto {
//	BOARD_ANY_NO      NOT NULL NUMBER         
//	BOARD_ANY_SUBJECT NOT NULL VARCHAR2(100)  
//	ANY_CONTENT                VARCHAR2(1000) 
//	BOARD_ANY_DATE    NOT NULL DATE           
//	BOARD_ANY_READ_NO          NUMBER         
//	MEMBER_ID         NOT NULL VARCHAR2(20)  
	private Integer boardAnyNo;
	private String boardAnySubject;
	private String anyContent;
	private String boardAnyDate;
	private Integer boardAnyReadNo;
	private String memberId;
	@Override
	public String toString() {
		return "AnyDto [boardAnyNo=" + boardAnyNo + ", boardAnySubject=" + boardAnySubject + ", anyContent="
				+ anyContent + ", boardAnyDate=" + boardAnyDate + ", boardAnyReadNo=" + boardAnyReadNo + ", memberId="
				+ memberId + "]";
	}
	public AnyDto(Integer boardAnyNo, String boardAnySubject, String anyContent, String boardAnyDate,
			Integer boardAnyReadNo, String memberId) {
		super();
		this.boardAnyNo = boardAnyNo;
		this.boardAnySubject = boardAnySubject;
		this.anyContent = anyContent;
		this.boardAnyDate = boardAnyDate;
		this.boardAnyReadNo = boardAnyReadNo;
		this.memberId = memberId;
	}
	public final Integer getBoardAnyNo() {
		return boardAnyNo;
	}
	public final String getBoardAnySubject() {
		return boardAnySubject;
	}
	public final String getAnyContent() {
		return anyContent;
	}
	public final String getBoardAnyDate() {
		return boardAnyDate;
	}
	public final Integer getBoardAnyReadNo() {
		return boardAnyReadNo;
	}
	public final String getMemberId() {
		return memberId;
	}
	
	
}
