package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DBad extends RobotPrompt{

	public DBad(){
		super(DrinkPromptNames.BAD);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "What are some of the not-so-good things about your drinking?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		LinkedList<UserResponseOption> options = this.usersResponsesToList(DrinkPromptNames.BAD, DrinkPromptNames.BAD,
				"makes you feel bad or hungover afterward",
				"interferes with your work",
				"causes some social problems",
				"takes  time away from other activities",
				"causes people to judge you negatively",
				"can harm your health",
				"costs you so much money",
				"can be hard to stop once you start",
				"does not bring you as much enjoyment as it used to",
				"contributes to weight gain");

		options.add(new UserResponseOption(DrinkPromptNames.BAD, DrinkPromptNames.BAD, "", true));


		return options;
	}

	@Override
	public List<String> getDynamicComments() {
		return this.toLinkedList("What are some other not so good things about drinking?");
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return DrinkPromptNames.CONFIRM;
	}
}
