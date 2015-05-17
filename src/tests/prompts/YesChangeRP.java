package tests.prompts;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

public class YesChangeRP extends RobotPrompt {

	public YesChangeRP(){
		super(PromptScreenNameConstants.YESCHANGE);
	}
	
	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		//do nothing
	}

	@Override
	public String generatePrompt() {
		return "How commited are you to making a change?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		LinkedList<UserResponseOption> options = new LinkedList<>();
		options.add(new UserResponseOption(this.screenId, "a little"));
		options.add(new UserResponseOption(this.screenId, "a moderate amount"));
		options.add(new UserResponseOption(this.screenId, "a lot"));
		return options;
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return PromptScreenNameConstants.ILLHELP;
	}

}
