package semi.climbing.member.model.dto;

import java.util.List;

import semi.climbing.common.file.FileWriteDto;

//회원 모든 정보
public class MemberDto {
//	ID        NOT NULL VARCHAR2(20)  
//	PWD       NOT NULL VARCHAR2(20)  
//	MEM_ADMIN NOT NULL NUMBER - default 1 : admin / set 0 : member     
//	POINT     NOT NULL NUMBER - default 0
//	EMAIL     NOT NULL VARCHAR2(30)  
	private String memId;
	private String memPwd;
	private int memAdmin;
	private int memPoint;
	private String memEmail;
	@Override
	public String toString() {
		return "MemberDto [memId=" + memId + ", memPwd=" + memPwd + ", memAdmin=" + memAdmin + ", memPoint=" + memPoint
				+ ", memEmail=" + memEmail + "]";
	}
	public MemberDto(String memId, String memPwd, int memAdmin, int memPoint, String memEmail) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memAdmin = memAdmin;
		this.memPoint = memPoint;
		this.memEmail = memEmail;
	}
	public final String getMemId() {
		return memId;
	}
	public final String getMemPwd() {
		return memPwd;
	}
	public final int getMemAdmin() {
		return memAdmin;
	}
	public final int getMemPoint() {
		return memPoint;
	}
	public final String getMemEmail() {
		return memEmail;
	}
	
	

	
}
