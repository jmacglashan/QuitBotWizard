package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DRootRP extends RobotPrompt{

	public DRootRP() {
		super(DrinkPromptNames.ROOT);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "### Wizard: fill in the below information before beginning the session with the participant. " +
				"When you're ready, press \"User Finished Responding\" at which point the robot will begin speaking.";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		LinkedList <UserResponseOption> answers = new LinkedList<>();
		answers.add(new UserResponseOption(DrinkPromptNames.ROOT, DrinkPromptNames.DAYSPERWEEK, "", true));
		answers.add(new UserResponseOption(DrinkPromptNames.ROOT, DrinkPromptNames.DRINKSPERWEEK, "", true));
		answers.add(new UserResponseOption(DrinkPromptNames.ROOT, DrinkPromptNames.SEX, "male"));
		answers.add(new UserResponseOption(DrinkPromptNames.ROOT, DrinkPromptNames.SEX, "female"));
		return answers;
	}

	@Override
	public List<String> getRequiredAnswers() {
		return this.toLinkedList(DrinkPromptNames.SEX);
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return DrinkPromptNames.WELCOME;
	}
}
