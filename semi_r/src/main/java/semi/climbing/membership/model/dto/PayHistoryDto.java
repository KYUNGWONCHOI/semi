package semi.climbing.membership.model.dto;

public class PayHistoryDto {
//	PAY_DATE    NOT NULL DATE         
//	USE_HISTORY          NUMBER       
//	END_DATE             DATE         
//	ID          NOT NULL VARCHAR2(20) 
//	PRICE_TYPE  NOT NULL NUMBER  
	private String payDate;
	private Integer useHistory;
	private String endDate;
	private String id;
	private Integer priceType;
	@Override
	public String toString() {
		return "PayHistoryDto [payDate=" + payDate + ", useHistory=" + useHistory + ", endDate=" + endDate + ", id="
				+ id + ", priceType=" + priceType + "]";
	}
	public PayHistoryDto(String payDate, Integer useHistory, String endDate, String id, Integer priceType) {
		super();
		this.payDate = payDate;
		this.useHistory = useHistory;
		this.endDate = endDate;
		this.id = id;
		this.priceType = priceType;
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
	public String getId() {
		return id;
	}
	public Integer getPriceType() {
		return priceType;
	}
	
	
}
