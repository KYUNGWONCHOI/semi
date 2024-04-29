package semi.climbing.membership.model.dto;

public class MembershipInfoDto {
	private String id;
	private Integer priceType;
	private String payDate;
	private Integer useHistory;
	private String endDate;
	@Override
	public String toString() {
		return "MembershipIntoDto [id=" + id + ", priceType=" + priceType + ", payDate=" + payDate + ", useHistory="
				+ useHistory + ", endDate=" + endDate + "]";
	}
	public MembershipInfoDto(String id, Integer priceType, String payDate, Integer useHistory, String endDate) {
		super();
		this.id = id;
		this.priceType = priceType;
		this.payDate = payDate;
		this.useHistory = useHistory;
		this.endDate = endDate;
	}
	public String getId() {
		return id;
	}
	public Integer getPriceType() {
		return priceType;
	}
	public String getPayDate() {
		return payDate;
	}
	public Integer getUseHistory() {
		return useHistory;
	}
	public String getEndDate() {
		return endDate;
	}
	
}
