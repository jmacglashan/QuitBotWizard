package tests.prompts;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

public class IllHelpRP extends RobotPrompt {

	String commitment;
	
	public IllHelpRP(){
		super(PromptScreenNameConstants.ILLHELP);
	}
	
	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		this.commitment = userAnswerDB.get(PromptScreenNameConstants.YESCHANGE).get(0);
	}

	@Override
	public String generatePrompt() {
		return this.commitment + ": That's great. I will do my best to help you.";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return new LinkedList<>();
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return null; //end of screen
	}

}
