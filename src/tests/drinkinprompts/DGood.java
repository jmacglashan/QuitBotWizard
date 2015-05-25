package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DGood extends RobotPrompt{

	public DGood() {
		super(DrinkPromptNames.GOOD);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "Tell me some of the good things about your drinking.  What is it you like about drinking?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		LinkedList<UserResponseOption> options = this.usersResponsesToList(DrinkPromptNames.GOOD, DrinkPromptNames.GOOD,
				"that you like how it makes you feel",
				"that it helps you relax",
				"that it tastes good",
				"that it makes you feel part of a group",
				"that it helps you celebrate",
				"that it helps you socialize",
				"that it helps you feel better if you are down",
				"that it helps you enjoy other activities more",
				"that it helps you have fun");

		options.add(new UserResponseOption(DrinkPromptNames.GOOD, DrinkPromptNames.GOOD, "", true));


		return options;
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return DrinkPromptNames.BAD;
	}

	@Override
	public List<String> getDynamicComments() {
		return this.toLinkedList("What else do you like about drinking?");
	}
}
