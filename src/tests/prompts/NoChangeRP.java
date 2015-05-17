package tests.prompts;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

public class NoChangeRP extends RobotPrompt {

	public NoChangeRP(){
		super(PromptScreenNameConstants.NOCHANGE);
	}
	
	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		//nothing to do
	}

	@Override
	public String generatePrompt() {
		return "Okay, thanks for talking with me.";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return new LinkedList<>();
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return null; //finished
	}

}
