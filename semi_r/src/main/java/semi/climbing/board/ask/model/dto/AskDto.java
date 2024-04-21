package semi.climbing.board.ask.model.dto;

public class AskDto {
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
	private String askContent;
	private String boardAskDate;
	private String askAnswer;
	private Integer boardAskReadNo;
	private Integer askPwnYn;
	private String askPwd;
	private String memberId;
	@Override
	public String toString() {
		return "AskDto [boardAskNo=" + boardAskNo + ", askSubject=" + askSubject + ", askContent=" + askContent
				+ ", boardAskDate=" + boardAskDate + ", askAnswer=" + askAnswer + ", boardAskReadNo=" + boardAskReadNo
				+ ", askPwnYn=" + askPwnYn + ", askPwd=" + askPwd + ", memberId=" + memberId + "]";
	}
	public AskDto(Integer boardAskNo, String askSubject, String askContent, String boardAskDate, String askAnswer,
			Integer boardAskReadNo, Integer askPwnYn, String askPwd, String memberId) {
		super();
		this.boardAskNo = boardAskNo;
		this.askSubject = askSubject;
		this.askContent = askContent;
		this.boardAskDate = boardAskDate;
		this.askAnswer = askAnswer;
		this.boardAskReadNo = boardAskReadNo;
		this.askPwnYn = askPwnYn;
		this.askPwd = askPwd;
		this.memberId = memberId;
	}
	public final Integer getBoardAskNo() {
		return boardAskNo;
	}
	public final String getAskSubject() {
		return askSubject;
	}
	public final String getAskContent() {
		return askContent;
	}
	public final String getBoardAskDate() {
		return boardAskDate;
	}
	public final String getAskAnswer() {
		return askAnswer;
	}
	public final Integer getBoardAskReadNo() {
		return boardAskReadNo;
	}
	public final Integer getAskPwnYn() {
		return askPwnYn;
	}
	public final String getAskPwd() {
		return askPwd;
	}
	public final String getMemberId() {
		return memberId;
	}
	
	
}
