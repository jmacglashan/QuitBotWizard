package tests.prompts;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

public class ChangeRP extends RobotPrompt {

	String activity;
	
	public ChangeRP(){
		super(PromptScreenNameConstants.CHANGE);
	}
	
	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		this.activity = userAnswerDB.get("activity").get(0);
	}

	@Override
	public String generatePrompt() {
		return "Is there anything you'd like to change about your " + this.activity + "?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		LinkedList<UserResponseOption> options = new LinkedList<>();
		options.add(new UserResponseOption(this.screenId, "yes"));
		options.add(new UserResponseOption(this.screenId, "no"));
		return options;
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		
		String change = userAnswerDB.get(this.screenId).get(0);
		if(change.equals("no")){
			return PromptScreenNameConstants.NOCHANGE;
		}
		
		return PromptScreenNameConstants.YESCHANGE;
	}

}
