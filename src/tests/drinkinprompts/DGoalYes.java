package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DGoalYes extends RobotPrompt {

	public DGoalYes(){
		super(DrinkPromptNames.GOALYES);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "Great.  Let’s start with thinking about daily limits.  These are limits you can set for how much " +
				"you would drink at any one time.  Thinking about the next month, what limit you would set for " +
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
