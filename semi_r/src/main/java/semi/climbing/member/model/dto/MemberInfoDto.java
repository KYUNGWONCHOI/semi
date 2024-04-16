package semi.climbing.member.model.dto;

//회원 ID, Point 정보
public class MemberInfoDto {
//	ID        NOT NULL VARCHAR2(20)   
//	POINT     NOT NULL NUMBER - default 0
	private String memId;
	private int memPoint;
	@Override
	public String toString() {
		return "MemberInfoDto [memId=" + memId + ", memPoint=" + memPoint + "]";
	}
	public MemberInfoDto(String memId, int memPoint) {
		super();
		this.memId = memId;
		this.memPoint = memPoint;
	}
	public String getMemId() {
		return memId;
	}
	public int getMemPoint() {
		return memPoint;
	}
	
}
