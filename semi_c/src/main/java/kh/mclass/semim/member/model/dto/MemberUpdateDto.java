package kh.mclass.semim.member.model.dto;

//보드의 멤버DTO
public class MemberUpdateDto {
//  MEMBER
//	MEM_ID    NOT NULL VARCHAR2(20)  
//	MEM_PWD   NOT NULL VARCHAR2(20)  
//	MEM_EMAIL NOT NULL VARCHAR2(100) 
	private String memId;
	private String memPwd;
	private String memPwdNew;
	private String memEmail;
	
	public MemberUpdateDto(String memId, String memPwd, String memPwdNew, String memEmail) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memPwdNew = memPwdNew;
		this.memEmail = memEmail;
	}
	@Override
	public String toString() {
		return "MemberUpdateDto [memId=" + memId + ", memPwd=" + memPwd + ", memPwdNew=" + memPwdNew + ", memEmail="
				+ memEmail + "]";
	}
	public String getMemId() {
		return memId;
	}
	public String getMemPwd() {
		return memPwd;
	}
	public String getMemPwdNew() {
		return memPwdNew;
	}
	public String getMemEmail() {
		return memEmail;
	}
	
}
// 회원가입 창에서 ID, PWD, Email 을 한번에 입력 받아 오기때문에, 매개변수가 없는 생성자 및 개별 setter 삭제

