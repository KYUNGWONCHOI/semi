package semi.climbing.price.model.dto;

public class OnedayPassDto {
	private String id;
	private Integer priceType;
	private Integer price;
	private Integer useHistory;
	private Integer rentItem;
	private Integer shoeSize;
	private Integer shoeCount;
	private Integer chalkCount;
	@Override
	public String toString() {
		return "OnedayPassDto [id=" + id + ", priceType=" + priceType + ", price=" + price + ", useHistory="
				+ useHistory + ", rentItem=" + rentItem + ", shoeSize=" + shoeSize + ", shoeCount=" + shoeCount
				+ ", chalkCount=" + chalkCount + "]";
	}
	public OnedayPassDto(String id, Integer priceType, Integer price, Integer useHistory, Integer rentItem,
			Integer shoeSize, Integer shoeCount, Integer chalkCount) {
		super();
		this.id = id;
		this.priceType = priceType;
		this.price = price;
		this.useHistory = useHistory;
		this.rentItem = rentItem;
		this.shoeSize = shoeSize;
		this.shoeCount = shoeCount;
		this.chalkCount = chalkCount;
	}
	public String getId() {
		return id;
	}
	public Integer getPriceType() {
		return priceType;
	}
	public Integer getPrice() {
		return price;
	}
	public Integer getUseHistory() {
		return useHistory;
	}
	public Integer getRentItem() {
		return rentItem;
	}
	public Integer getShoeSize() {
		return shoeSize;
	}
	public Integer getShoeCount() {
		return shoeCount;
	}
	public Integer getChalkCount() {
		return chalkCount;
	}
	
	
	
}
