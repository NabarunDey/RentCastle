package help;

import help.projector.outputBeans.HelpProjectorOB;


public class HelpAppContext {
	
	private HelpProjectorOB helpProjectorOB;
	private boolean helpRequestSubmitSuccess;
	

	public boolean isHelpRequestSubmitSuccess() {
		return helpRequestSubmitSuccess;
	}

	public void setHelpRequestSubmitSuccess(boolean helpRequestSubmitSuccess) {
		this.helpRequestSubmitSuccess = helpRequestSubmitSuccess;
	}

	public HelpProjectorOB getHelpProjectorOB() {
		return helpProjectorOB;
	}

	public void setHelpProjectorOB(HelpProjectorOB helpProjectorOB) {
		this.helpProjectorOB = helpProjectorOB;
	}

	
	

}
