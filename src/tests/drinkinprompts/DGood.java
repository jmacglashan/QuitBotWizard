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
				"helps you have fun",
				"helps relax or destress you",
				"makes it easier to socialize",
				"tastes good",
				"makes you feel part of the group",
				"to celebrate",
				"because everyone else does",
				"makes you feel better",
				"to feel less depressed");

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
