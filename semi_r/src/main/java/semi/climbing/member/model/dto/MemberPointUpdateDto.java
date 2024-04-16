package semi.climbing.member.model.dto;

public class MemberPointUpdateDto {
//	ID        NOT NULL VARCHAR2(20)  
//	PWD       NOT NULL VARCHAR2(20)  
//	PHOTO     NOT NULL VARCHAR2(200) - img path 
//	MEM_ADMIN NOT NULL NUMBER - default 1 : admin / set 0 : member     
//	POINT     NOT NULL NUMBER - default 0
	private String memId;
	private int memPoint;
	private int memPointNew;
	@Override
	public String toString() {
		return "MemberPointUpdateDto [memId=" + memId + ", memPoint=" + memPoint + ", memPointNew=" + memPointNew + "]";
	}
	public MemberPointUpdateDto(String memId, int memPoint, int memPointNew) {
		super();
		this.memId = memId;
		this.memPoint = memPoint;
		this.memPointNew = memPointNew;
	}
	public String getMemId() {
		return memId;
	}
	public int getMemPoint() {
		return memPoint;
	}
	public int getMemPointNew() {
		return memPointNew;
	}
	
}
