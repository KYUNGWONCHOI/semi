package semi.climbing.board.prob.model.dto;

public class NoticeReplyDto {
//	BOARD_REPLY_ID    NOT NULL NUMBER       
//	BOARD_REPLY_LEVEL NOT NULL NUMBER(2)    
//	BOARD_REPLY_REF   NOT NULL NUMBER       
//	BOARD_REPLY_STEP  NOT NULL NUMBER(3)    
//	ID                NOT NULL VARCHAR2(20) 
//	BOARD_ANY_NO               NUMBER       
//	BOARD_ASK_NO               NUMBER       
//	BOARD_PROB_NO              NUMBER 
	private Integer boardReplyId;
	private Integer boardReplyLevel;
	private Integer boardReplyRef;
	private Integer boardReplyStep;
	private String id;
	private Integer boardAnyNo;
	private Integer boardAskNo;
	private Integer boardProbNo;
	@Override
	public String toString() {
		return "NoticeReplyDto [boardReplyId=" + boardReplyId + ", boardReplyLevel=" + boardReplyLevel
				+ ", boardReplyRef=" + boardReplyRef + ", boardReplyStep=" + boardReplyStep + ", id=" + id
				+ ", boardAnyNo=" + boardAnyNo + ", boardAskNo=" + boardAskNo + ", boardProbNo=" + boardProbNo + "]";
	}
	public NoticeReplyDto(Integer boardReplyId, Integer boardReplyLevel, Integer boardReplyRef, Integer boardReplyStep,
			String id, Integer boardAnyNo, Integer boardAskNo, Integer boardProbNo) {
		super();
		this.boardReplyId = boardReplyId;
		this.boardReplyLevel = boardReplyLevel;
		this.boardReplyRef = boardReplyRef;
		this.boardReplyStep = boardReplyStep;
		this.id = id;
		this.boardAnyNo = boardAnyNo;
		this.boardAskNo = boardAskNo;
		this.boardProbNo = boardProbNo;
	}
	public final Integer getBoardReplyId() {
		return boardReplyId;
	}
	public final Integer getBoardReplyLevel() {
		return boardReplyLevel;
	}
	public final Integer getBoardReplyRef() {
		return boardReplyRef;
	}
	public final Integer getBoardReplyStep() {
		return boardReplyStep;
	}
	public final String getId() {
		return id;
	}
	public final Integer getBoardAnyNo() {
		return boardAnyNo;
	}
	public final Integer getBoardAskNo() {
		return boardAskNo;
	}
	public final Integer getBoardProbNo() {
		return boardProbNo;
	}
	
	
}
