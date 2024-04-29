package semi.climbing.membership.model.dto;

public class MembershipDto {
//	MEM_HISTORY            DATE    
//	MEM_LOCKER_NO          NUMBER  
//	MEM_LOCKER    NOT NULL CHAR(1) 
//	PAY_DATE      NOT NULL DATE 
	private String memHistory;
	private Integer memLockerNo;
	private String memLocker;
	private String payDate;
	@Override
	public String toString() {
		return "MembershipDto [memHistory=" + memHistory + ", memLockerNo=" + memLockerNo + ", memLocker=" + memLocker
				+ ", payDate=" + payDate + "]";
	}
	public MembershipDto(String memHistory, Integer memLockerNo, String memLocker, String payDate) {
		super();
		this.memHistory = memHistory;
		this.memLockerNo = memLockerNo;
		this.memLocker = memLocker;
		this.payDate = payDate;
	}
	public String getMemHistory() {
		return memHistory;
	}
	public Integer getMemLockerNo() {
		return memLockerNo;
	}
	public String getMemLocker() {
		return memLocker;
	}
	public String getPayDate() {
		return payDate;
	}
	
	
}
