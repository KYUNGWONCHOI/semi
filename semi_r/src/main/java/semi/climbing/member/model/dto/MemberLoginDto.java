package semi.climbing.member.model.dto;

//회원 로그인 Dto
public class MemberLoginDto {
//	ID        NOT NULL VARCHAR2(20)  
//	PWD       NOT NULL VARCHAR2(20)
	private String memId;
	private String memPwd;
	@Override
	public String toString() {
		return "MemberLoginDto [memId=" + memId + ", memPwd=" + memPwd + "]";
	}
	public MemberLoginDto(String memId, String memPwd) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
	}
	public String getMemId() {
		return memId;
	}
	public String getMemPwd() {
		return memPwd;
	}
	

}
