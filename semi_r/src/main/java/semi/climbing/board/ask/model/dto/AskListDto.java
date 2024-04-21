package semi.climbing.board.ask.model.dto;

public class AskListDto {
//	BOARD_ASK_NO      NOT NULL NUMBER         
//	ASK_SUBJECT       NOT NULL VARCHAR2(100)  
//	ASK_CONTENT       NOT NULL VARCHAR2(1000) 
//	BOARD_ASK_DATE    NOT NULL DATE           
//	ASK_ANSWER                 VARCHAR2(100)  
//	BOARD_ASK_READ_NO NOT NULL NUMBER         
//	ASK_PWN_YN        NOT NULL CHAR(1)        
//	ASK_PWD                    VARCHAR2(20)   
//	MEMBER_ID         NOT NULL VARCHAR2(20) 
	private Integer boardAskNo;
	private String askSubject;
	private String boardAskDate;
	private Integer boardAskReadNo;
	private Integer askPwnYn;
	private String memberId;
	@Override
	public String toString() {
		return "AskListDto [boardAskNo=" + boardAskNo + ", askSubject=" + askSubject + ", boardAskDate=" + boardAskDate
				+ ", boardAskReadNo=" + boardAskReadNo + ", askPwnYn=" + askPwnYn + ", memberId=" + memberId + "]";
	}
	public AskListDto(Integer boardAskNo, String askSubject, String boardAskDate, Integer boardAskReadNo,
			Integer askPwnYn, String memberId) {
		super();
		this.boardAskNo = boardAskNo;
		this.askSubject = askSubject;
		this.boardAskDate = boardAskDate;
		this.boardAskReadNo = boardAskReadNo;
		this.askPwnYn = askPwnYn;
		this.memberId = memberId;
	}
	public Integer getBoardAskNo() {
		return boardAskNo;
	}
	public String getAskSubject() {
		return askSubject;
	}
	public String getBoardAskDate() {
		return boardAskDate;
	}
	public Integer getBoardAskReadNo() {
		return boardAskReadNo;
	}
	public Integer getAskPwnYn() {
		return askPwnYn;
	}
	public String getMemberId() {
		return memberId;
	}
	
	
	
}
