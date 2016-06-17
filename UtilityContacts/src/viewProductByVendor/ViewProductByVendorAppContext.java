package viewProductByVendor;

import java.util.List;

import search.projector.outputBeans.SearchProductProjectorOB;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;



public class ViewProductByVendorAppContext {
	
	private List<SearchProductProjectorOB> searchProductProjectorOBs;
	private boolean isEditable;
	private ViewProductProjectorOB viewProductProjectorOB;
	private String productIdfroEdit;

	public List<SearchProductProjectorOB> getSearchProductProjectorOBs() {
		return searchProductProjectorOBs;
	}

	public void setSearchProductProjectorOBs(
			List<SearchProductProjectorOB> searchProductProjectorOBs) {
		this.searchProductProjectorOBs = searchProductProjectorOBs;
	}

	public boolean isEditable() {
		return isEditable;
	}

	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}

	public ViewProductProjectorOB getViewProductProjectorOB() {
		return viewProductProjectorOB;
	}

	public void setViewProductProjectorOB(
			ViewProductProjectorOB viewProductProjectorOB) {
		this.viewProductProjectorOB = viewProductProjectorOB;
	}

	public String getProductIdfroEdit() {
		return productIdfroEdit;
	}

	public void setProductIdfroEdit(String productIdfroEdit) {
		this.productIdfroEdit = productIdfroEdit;
	}
}
