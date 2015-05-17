package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DImportanceB extends RobotPrompt{

	protected int imp;

	public DImportanceB(){
		super(DrinkPromptNames.IMPORTANCEB);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		this.imp = Integer.parseInt(userAnswerDB.get(DrinkPromptNames.IMPORTANCE).get(0));
	}

	@Override
	public String generatePrompt() {
		return "Why is your importance a " + this.imp + " and not a 0?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return new LinkedList<>();
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return DrinkPromptNames.IMPORTANCEC;
	}
}
