package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DImportance extends RobotPrompt{

	public DImportance(){
		super(DrinkPromptNames.IMPORTANCE);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "It seems like I’ve got a pretty good picture of where things are at with your use of alcohol. " +
				"I would now like to check in to understand what, if anything, you’d like to do about making a change in your drinking. " +
				"On a scale of 0 to 10, where 0 is not very important and 10 is very important, " +
				"how important is it to you to make some change in your drinking?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return this.usersResponsesToList(DrinkPromptNames.IMPORTANCE, DrinkPromptNames.IMPORTANCE,
				"0","1","2","3","4","5","6","7","8","9","10");
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		int imp = Integer.parseInt(userAnswerDB.get(DrinkPromptNames.IMPORTANCE).get(0));
		if(imp > 0) {
			return DrinkPromptNames.IMPORTANCEB;
		}
		return DrinkPromptNames.CONFIDENCE;
	}

	@Override
	public List<String> getRequiredAnswers() {
		return this.toLinkedList(DrinkPromptNames.IMPORTANCE);
	}
}
