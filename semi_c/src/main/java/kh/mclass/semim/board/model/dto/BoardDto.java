package kh.mclass.semim.board.model.dto;

import java.util.List;

public class BoardDto {
//	BOARD_ID     NOT NULL NUMBER         
//	SUBJECT      NOT NULL VARCHAR2(120)  
//	CONTENT      NOT NULL VARCHAR2(4000) 
//	WRITE_TIME   NOT NULL TIMESTAMP(6)   
//	LOG_IP                VARCHAR2(15)   
//	BOARD_WRITER NOT NULL VARCHAR2(20)   
//	READ_COUNT   NOT NULL NUMBER     
	
	private Integer boardId;
	private String subject;
	private String content;
	private String writeTime; //TIMESTAMP
	private String logIp;
	private String boardWriter;
	private Integer readCount;
	
//	사용자 화면과 관리자 화면 나눠서 설계
	
	@Override
	public String toString() {
		return "BoardDto [boardId=" + boardId + ", subject=" + subject + ", content=" + content + ", writeTime="
				+ writeTime + ", logIp=" + logIp + ", boardWriter=" + boardWriter + ", readCount=" + readCount + "]";
	}
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDto(Integer boardId, String subject, String content, String writeTime, String logIp,
			String boardWriter, Integer readCount) {
		super();
		this.boardId = boardId;
		this.subject = subject;
		this.content = content;
		this.writeTime = writeTime;
		this.logIp = logIp;
		this.boardWriter = boardWriter;
		this.readCount = readCount;
	}
	public Integer getBoardId() {
		return boardId;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public String getWriteTime() {
		return writeTime;
	}
	public String getLogIp() {
		return logIp;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public Integer getReadCount() {
		return readCount;
	}
}
