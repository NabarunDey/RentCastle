package currentHoldings;

import java.util.List;

import currentHoldings.projector.outputBeans.CurrentHoldingsProjectorOB;





public class CurrentHoldingsAppContext {

	private List<CurrentHoldingsProjectorOB> currentHoldingsProjectorOBs;

	public List<CurrentHoldingsProjectorOB> getCurrentHoldingsProjectorOBs() {
		return currentHoldingsProjectorOBs;
	}

	public void setCurrentHoldingsProjectorOBs(
			List<CurrentHoldingsProjectorOB> currentHoldingsProjectorOBs) {
		this.currentHoldingsProjectorOBs = currentHoldingsProjectorOBs;
	}


}
