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
				"makes you feel bad afterward",
				"interferes with your work",
				"interferes with other social interactions",
				"takes  time away from other activities",
				"people judge you negatively",
				"creates health problems",
				"costs you money",
				"can be hard to stop once you start",
				"is getting kind of old",
				"makes emotional problems worse",
				"causes problems with your family",
				"causes problems with your significant other",
				"makes you make bad decisions",
				"makes you gain weight",
				"interferes with school");

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
