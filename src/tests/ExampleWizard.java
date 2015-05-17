package tests;

import keepon.KeepOnNetworkClient;
import tests.prompts.ChangeRP;
import tests.prompts.ConfirmLDRP;
import tests.prompts.DislikesRP;
import tests.prompts.IllHelpRP;
import tests.prompts.LikesRP;
import tests.prompts.NoChangeRP;
import tests.prompts.RootRP;
import tests.prompts.YesChangeRP;
import humanwizard.Wizard;
import humanwizard.WizardGUI;

public class ExampleWizard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Wizard wizard = new Wizard();
		wizard.addRobotPrompt(new RootRP());
		wizard.addRobotPrompt(new LikesRP());
		wizard.addRobotPrompt(new DislikesRP());
		wizard.addRobotPrompt(new ConfirmLDRP());
		wizard.addRobotPrompt(new ChangeRP());
		wizard.addRobotPrompt(new NoChangeRP());
		wizard.addRobotPrompt(new YesChangeRP());
		wizard.addRobotPrompt(new IllHelpRP());
		
		WizardGUI gui = new WizardGUI(wizard);
		
		/*
		KeepOnNetworkClient keepon = new KeepOnNetworkClient(12345);
		boolean succeed = keepon.connectToKeepOnServer();
		if(succeed){
			gui.setKeepon(keepon);
		}
		*/
		
		gui.startGUI();

	}

}
