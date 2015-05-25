package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DGoalYesRepeat extends RobotPrompt{

	public DGoalYesRepeat(){
		super(DrinkPromptNames.GOALYESREPEAT);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "Thinking about the next month, what limit you would set for " +
				"yourself on how many drinks you would have on any one day?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		LinkedList<UserResponseOption> options = new LinkedList<>();
		options.add(new UserResponseOption(DrinkPromptNames.GOALYES, DrinkPromptNames.GOALDPDAY, "", true));
		options.add(new UserResponseOption(DrinkPromptNames.GOALYES, DrinkPromptNames.GOALDPWEEK, "", true));
		return options;
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return DrinkPromptNames.GOALCONFIRM;
	}

	@Override
	public List<String> getDynamicComments() {
		return this.toLinkedList("How many drinks per week would you want to limit yourself to?");
	}

}
