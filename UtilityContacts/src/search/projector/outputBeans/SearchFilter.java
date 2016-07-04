package search.projector.outputBeans;
import java.util.List;


public class  SearchFilter {

	private List<String> productType;
	private List<String> productSubType;
	private List<String> state;
	private List<String> city;
	private List<String> location;
	public List<String> getProductType() {
		return productType;
	}
	public void setProductType(List<String> productType) {
		this.productType = productType;
	}
	public List<String> getProductSubType() {
		return productSubType;
	}
	public void setProductSubType(List<String> productSubType) {
		this.productSubType = productSubType;
	}
	public List<String> getState() {
		return state;
	}
	public void setState(List<String> state) {
		this.state = state;
	}
	public List<String> getCity() {
		return city;
	}
	public void setCity(List<String> city) {
		this.city = city;
	}
	public List<String> getLocation() {
		return location;
	}
	public void setLocation(List<String> location) {
		this.location = location;
	}
}
