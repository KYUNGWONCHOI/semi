package semi.climbing.member.model.dto;

import java.util.List;

import semi.climbing.common.file.FileWriteDto;

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
	private String memPhoto;
	@Override
	public String toString() {
		return "MemberJoinDto [memId=" + memId + ", memPwd=" + memPwd + ", memEmail=" + memEmail + ", memPhoto="
				+ memPhoto + "]";
	}
	public MemberJoinDto(String memId, String memPwd, String memEmail, String memPhoto) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memEmail = memEmail;
		this.memPhoto = memPhoto;
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
	public final String getMemPhoto() {
		return memPhoto;
	}
	
	
}
