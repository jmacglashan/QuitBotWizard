package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DConfidence extends RobotPrompt{

	public DConfidence(){
		super(DrinkPromptNames.CONFIDENCE);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "If we were to try to cut down on drinking, how confident are you on a 0 to 10 " +
				"scale that you could be successful in doing so?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return this.usersResponsesToList(DrinkPromptNames.CONFIDENCE, DrinkPromptNames.CONFIDENCE,
				"0","1","2","3","4","5","6","7","8","9","10");
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return DrinkPromptNames.SUMMARY;
	}
}
