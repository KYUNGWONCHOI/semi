package semi.climbing.price.model.dto;

public class RegisterInfoDto {
	private String id;
	private Integer priceType;
	private String memLocker;
	private Integer price;
	private Integer useHistory;
	private Integer duration;
	@Override
	public String toString() {
		return "RegisterInfoDto [id=" + id + ", priceType=" + priceType + ", memLocker=" + memLocker + ", price="
				+ price + ", useHistory=" + useHistory + ", duration=" + duration + "]";
	}
	public RegisterInfoDto(String id, Integer priceType, String memLocker, Integer price, Integer useHistory,
			Integer duration) {
		super();
		this.id = id;
		this.priceType = priceType;
		this.memLocker = memLocker;
		this.price = price;
		this.useHistory = useHistory;
		this.duration = duration;
	}
	public String getId() {
		return id;
	}
	public Integer getPriceType() {
		return priceType;
	}
	public String getMemLocker() {
		return memLocker;
	}
	public Integer getPrice() {
		return price;
	}
	public Integer getUseHistory() {
		return useHistory;
	}
	public Integer getDuration() {
		return duration;
	}
	
}
