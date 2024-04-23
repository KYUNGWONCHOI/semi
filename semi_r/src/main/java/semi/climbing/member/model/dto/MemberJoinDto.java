package semi.climbing.member.model.dto;

public class MemberJoinDto {
//	ID        NOT NULL VARCHAR2(20)  
//	PWD       NOT NULL VARCHAR2(20)  
//	PHOTO     NOT NULL VARCHAR2(200) 
//	MEM_ADMIN NOT NULL NUMBER        
//	POINT     NOT NULL NUMBER        
//	EMAIL     NOT NULL VARCHAR2(30)
	private String memId;
	private String memPwd;
	private String memEmail;
	@Override
	public String toString() {
		return "MemberJoinDto [memId=" + memId + ", memPwd=" + memPwd + ", memEmail=" + memEmail + "]";
	}
	public MemberJoinDto(String memId, String memPwd, String memEmail) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memEmail = memEmail;
	}
	public final String getMemId() {
		return memId;
	}
	public final String getMemPwd() {
		return memPwd;
	}
	public final String getMemEmail() {
		return memEmail;
	}
		
}
