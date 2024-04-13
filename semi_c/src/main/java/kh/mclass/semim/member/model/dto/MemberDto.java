package kh.mclass.semim.member.model.dto;

//보드의 멤버DTO
public class MemberDto {
//  MEMBER
//	MEM_ID    NOT NULL VARCHAR2(20)  
//	MEM_PWD   NOT NULL VARCHAR2(20)  
//	MEM_EMAIL NOT NULL VARCHAR2(100) 
	private String memId;
	private String memPwd;
	private String memEmail;
	
	@Override
	public String toString() {
		return "MemberDto [memId=" + memId + ", memPwd=" + memPwd + ", memEmail=" + memEmail + "]";
	}
	public MemberDto(String memId, String memPwd, String memEmail) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memEmail = memEmail;
	}
	public String getMemId() {
		return memId;
	}
	public String getMemPwd() {
		return memPwd;
	}
	public String getMemEmail() {
		return memEmail;
	}
}
// 회원가입 창에서 ID, PWD, Email 을 한번에 입력 받아 오기때문에, 매개변수가 없는 생성자 및 개별 setter 삭제

