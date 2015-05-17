package tests.prompts;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

public class DislikesRP extends RobotPrompt {

	String activity;
	
	public DislikesRP(){
		super(PromptScreenNameConstants.DISLIKES);
	}
	
	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		this.activity = userAnswerDB.get("activity").get(0);
	}

	@Override
	public String generatePrompt() {
		return "What are some of the not-so-good things about your " + this.activity +"?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		LinkedList<UserResponseOption> options = new LinkedList<>();
		
		options.add(new UserResponseOption(this.screenId, "makes you feel bad afterward"));
		options.add(new UserResponseOption(this.screenId, "interferes with your work"));
		options.add(new UserResponseOption(this.screenId, "interferes with other social interactions"));
		options.add(new UserResponseOption(this.screenId, "takes a lot of time away from other activities"));
		options.add(new UserResponseOption(this.screenId, "people judge you negatively"));
		options.add(new UserResponseOption(this.screenId, "creates health problems"));
		options.add(new UserResponseOption(this.screenId, "costs you money"));
		options.add(new UserResponseOption(this.screenId, "can be distracting"));
		options.add(new UserResponseOption(this.screenId, "can be hard to stop once you start"));
		options.add(new UserResponseOption(this.screenId, "is getting kind of old"));
		
		
		return options;
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return PromptScreenNameConstants.CONFIRMLD;
	}

}
