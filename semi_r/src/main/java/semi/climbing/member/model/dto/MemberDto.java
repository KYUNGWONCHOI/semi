package semi.climbing.member.model.dto;

//회원 모든 정보
public class MemberDto {
//	ID        NOT NULL VARCHAR2(20)  
//	PWD       NOT NULL VARCHAR2(20)  
//	PHOTO     NOT NULL VARCHAR2(200) - img path 
//	MEM_ADMIN NOT NULL NUMBER - default 1 : admin / set 0 : member     
//	POINT     NOT NULL NUMBER - default 0
	private String memId;
	private String memPwd;
	private String memPhoto;
	private int memAdmin;
	private int memPoint;
	@Override
	public String toString() {
		return "MemberDto [memId=" + memId + ", memPwd=" + memPwd + ", memPhoto=" + memPhoto + ", memAdmin=" + memAdmin
				+ ", memPoint=" + memPoint + "]";
	}
	//모든 정보
	public MemberDto(String memId, String memPwd, String memPhoto, int memAdmin, int memPoint) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memPhoto = memPhoto;
		this.memAdmin = memAdmin;
		this.memPoint = memPoint;
	}
	//admin 정보 제외 모든정보
	public MemberDto(String memId, String memPwd, String memPhoto, int memPoint) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memPhoto = memPhoto;
		this.memPoint = memPoint;
	}
	public String getMemId() {
		return memId;
	}
	public String getMemPwd() {
		return memPwd;
	}
	public String getMemPhoto() {
		return memPhoto;
	}
	public int getMemAdmin() {
		return memAdmin;
	}
	public int getMemPoint() {
		return memPoint;
	} 
	
	
}
