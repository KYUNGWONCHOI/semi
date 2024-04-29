package semi.climbing.membership.model.dto;

public class PriceDto {
//	PRICE_TYPE NOT NULL NUMBER        
//	PRICE      NOT NULL NUMBER        
//	PRICE_DESC          VARCHAR2(200) 
//	SERVICE_ON NOT NULL CHAR(1)
	private Integer priceType;
	private Integer price;
	private String priceDesc;
	@Override
	public String toString() {
		return "PriceDto [priceType=" + priceType + ", price=" + price + ", priceDesc=" + priceDesc + "]";
	}
	public PriceDto(Integer priceType, Integer price, String priceDesc) {
		super();
		this.priceType = priceType;
		this.price = price;
		this.priceDesc = priceDesc;
	}
	public Integer getPriceType() {
		return priceType;
	}
	public Integer getPrice() {
		return price;
	}
	public String getPriceDesc() {
		return priceDesc;
	}

}
