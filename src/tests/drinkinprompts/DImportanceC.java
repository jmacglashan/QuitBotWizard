package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DImportanceC extends RobotPrompt{

	public DImportanceC(){
		super(DrinkPromptNames.IMPORTANCEC);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "I understand that you have not been thinking about changing your drinking recently.  I would " +
				"like to get a sense of where you are at right now regarding any possible changes.  On a scale of " +
				"0 to 10, where 0 is not very important and 10 is extremely important, how important is it to you to " +
				"cut down on how much you drink?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return this.usersResponsesToList(DrinkPromptNames.IMPORTANCEC, DrinkPromptNames.IMPORTANCEC,
				"0","1","2","3","4","5","6","7","8","9","10");
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return DrinkPromptNames.CONFIDENCE;
	}
}
