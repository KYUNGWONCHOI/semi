package semi.climbing.board.any.model.dto;

public class AnyListDto {
//	BOARD_ANY_NO      NOT NULL NUMBER         
//	BOARD_ANY_SUBJECT NOT NULL VARCHAR2(100)  
//	ANY_CONTENT                VARCHAR2(1000) 
//	BOARD_ANY_DATE    NOT NULL DATE           
//	BOARD_ANY_READ_NO          NUMBER         
//	MEMBER_ID         NOT NULL VARCHAR2(20)  
	private Integer boardAnyNo;
	private String boardAnySubject;
	private String boardAnyDate;
	private Integer boardAnyReadNo;
	private String memberId;
	@Override
	public String toString() {
		return "AnyListDto [boardAnyNo=" + boardAnyNo + ", boardAnySubject=" + boardAnySubject + ", boardAnyDate="
				+ boardAnyDate + ", boardAnyReadNo=" + boardAnyReadNo + ", memberId=" + memberId + "]";
	}
	public AnyListDto(Integer boardAnyNo, String boardAnySubject, String boardAnyDate, Integer boardAnyReadNo,
			String memberId) {
		super();
		this.boardAnyNo = boardAnyNo;
		this.boardAnySubject = boardAnySubject;
		this.boardAnyDate = boardAnyDate;
		this.boardAnyReadNo = boardAnyReadNo;
		this.memberId = memberId;
	}
	public Integer getBoardAnyNo() {
		return boardAnyNo;
	}
	public String getBoardAnySubject() {
		return boardAnySubject;
	}
	public String getBoardAnyDate() {
		return boardAnyDate;
	}
	public Integer getBoardAnyReadNo() {
		return boardAnyReadNo;
	}
	public String getMemberId() {
		return memberId;
	}
	
	
	
}
