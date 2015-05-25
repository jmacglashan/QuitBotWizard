package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DGoalCNo extends RobotPrompt{

	public DGoalCNo(){
		super(DrinkPromptNames.GOALCNO);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "Sorry about that. Let me try that again.";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return new ArrayList<>();
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		userAnswerDB.remove(DrinkPromptNames.GOALDPDAY);
		userAnswerDB.remove(DrinkPromptNames.GOALDPWEEK);
		userAnswerDB.remove(DrinkPromptNames.GOALCONFIRM);
		return DrinkPromptNames.GOALYESREPEAT;
	}
}
