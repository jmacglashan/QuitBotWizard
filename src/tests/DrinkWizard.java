package tests;

import humanwizard.Wizard;
import humanwizard.WizardGUI;
import keepon.KeepOnNetworkClient;
import tests.drinkinprompts.*;

/**
 * @author James MacGlashan.
 */
public class DrinkWizard {

	public static void main(String [] args){

		Wizard wizard = new Wizard();
		wizard.addRobotPrompt(new DRootRP());
		wizard.addRobotPrompt(new DWelcome());
		wizard.addRobotPrompt(new DPattern());
		wizard.addRobotPrompt(new DGood());
		wizard.addRobotPrompt(new DBad());
		wizard.addRobotPrompt(new DConfirm());
		wizard.addRobotPrompt(new DChange());
		wizard.addRobotPrompt(new DImportance());
		wizard.addRobotPrompt(new DImportanceB());
		wizard.addRobotPrompt(new DImportanceC());
		wizard.addRobotPrompt(new DConfidence());
		wizard.addRobotPrompt(new DSummary());
		wizard.addRobotPrompt(new DLimits());
		wizard.addRobotPrompt(new DGoals());
		wizard.addRobotPrompt(new DGoalYes());
		wizard.addRobotPrompt(new DGoalConfirm());
		wizard.addRobotPrompt(new DGoalCNo());
		wizard.addRobotPrompt(new DGoalYesRepeat());
		wizard.addRobotPrompt(new DGoalSteps());
		wizard.addRobotPrompt(new DInformation());
		wizard.addRobotPrompt(new DInformationResponse());


		WizardGUI gui = new WizardGUI(wizard);
		gui.nextScreen();




//		KeepOnNetworkClient keepon = new KeepOnNetworkClient(12345);
//		boolean succeed = keepon.connectToKeepOnServer();
//		if(succeed){
//			gui.setKeepon(keepon);
//		}


		gui.startGUI();

	}

}
