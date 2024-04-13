package kh.mclass.semim.board.model.dto;

import java.util.List;

public class BoardInsertDto {
	private String subject;
	private String content;
	private String boardWriter;
	@Override
	public String toString() {
		return "BoardInsertDto [subject=" + subject + ", content=" + content + ", boardWriter=" + boardWriter + "]";
	}
	public BoardInsertDto(String subject, String content, String boardWriter) {
		super();
		this.subject = subject;
		this.content = content;
		this.boardWriter = boardWriter;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public String getBoardWriter() {
		return boardWriter;
	}

}