package semi.climbing.member.model.dto;

//정보수정 PWD, PHOTO
public class MemberUpdateDto {
//	ID        NOT NULL VARCHAR2(20)  
//	PWD       NOT NULL VARCHAR2(20)  
//	MEM_ADMIN NOT NULL NUMBER - default 1 : admin / set 0 : member     
//	POINT     NOT NULL NUMBER - default 0
	private String memId;
	private String memPwd;
	private String memPwdNew;
	private int memAdmin;
	private int memPoint;

}
