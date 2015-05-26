package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DInformation extends RobotPrompt {
	public DInformation(){
		super(DrinkPromptNames.INFORMATION);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "We have an information sheet that provides some tips for people who want to cut down on their drinking. " +
				"Would you like that information?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return this.usersResponsesToList(DrinkPromptNames.INFORMATION, DrinkPromptNames.INFORMATION, "yes", "no");
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return DrinkPromptNames.INFORMATIONRESPONSE;
	}

	@Override
	public List<String> getRequiredAnswers() {
		return this.toLinkedList(DrinkPromptNames.INFORMATION);
	}
}
