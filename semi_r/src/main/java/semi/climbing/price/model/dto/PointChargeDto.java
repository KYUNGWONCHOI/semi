package semi.climbing.price.model.dto;

public class PointChargeDto {
	private String id;
	private Integer point;
	@Override
	public String toString() {
		return "PointChargeDto [id=" + id + ", point=" + point + "]";
	}
	public PointChargeDto(String id, Integer point) {
		super();
		this.id = id;
		this.point = point;
	}
	public String getId() {
		return id;
	}
	public Integer getPoint() {
		return point;
	}
	
}
