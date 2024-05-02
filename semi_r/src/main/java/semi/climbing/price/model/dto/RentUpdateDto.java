package semi.climbing.price.model.dto;

public class RentUpdateDto {
	private Integer rentItem;
	private Integer shoeSize;
	private Integer shoeCount;
	private Integer chalkCount;
	private String payDate;
	@Override
	public String toString() {
		return "RentUpdateDto [rentItem=" + rentItem + ", shoeSize=" + shoeSize + ", shoeCount=" + shoeCount
				+ ", chalkCount=" + chalkCount + ", payDate=" + payDate + "]";
	}
	public RentUpdateDto(Integer rentItem, Integer shoeSize, Integer shoeCount, Integer chalkCount, String payDate) {
		super();
		this.rentItem = rentItem;
		this.shoeSize = shoeSize;
		this.shoeCount = shoeCount;
		this.chalkCount = chalkCount;
		this.payDate = payDate;
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
	public String getPayDate() {
		return payDate;
	}
	

}
