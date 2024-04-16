package semi.climbing.member.model.dto;

//정보수정 PWD, PHOTO
public class MemberUpdateDto {
//	ID        NOT NULL VARCHAR2(20)  
//	PWD       NOT NULL VARCHAR2(20)  
//	PHOTO     NOT NULL VARCHAR2(200) - img path 
//	MEM_ADMIN NOT NULL NUMBER - default 1 : admin / set 0 : member     
//	POINT     NOT NULL NUMBER - default 0
	private String memId;
	private String memPwd;
	private String memPwdNew;
	private String memPhoto;
	private String memPhotoNew;
	private int memAdmin;
	private int memPoint;
	@Override
	public String toString() {
		return "MemberUpdateDto [memId=" + memId + ", memPwd=" + memPwd + ", memPwdNew=" + memPwdNew + ", memPhoto="
				+ memPhoto + ", memPhotoNew=" + memPhotoNew + ", memAdmin=" + memAdmin + ", memPoint=" + memPoint + "]";
	}
	public MemberUpdateDto(String memId, String memPwd, String memPwdNew, String memPhoto, String memPhotoNew,
			int memAdmin, int memPoint) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memPwdNew = memPwdNew;
		this.memPhoto = memPhoto;
		this.memPhotoNew = memPhotoNew;
		this.memAdmin = memAdmin;
		this.memPoint = memPoint;
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
	public String getMemPhoto() {
		return memPhoto;
	}
	public String getMemPhotoNew() {
		return memPhotoNew;
	}
	public int getMemAdmin() {
		return memAdmin;
	}
	public int getMemPoint() {
		return memPoint;
	}
	
	

}
