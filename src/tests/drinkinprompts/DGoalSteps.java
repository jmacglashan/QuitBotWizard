package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DGoalSteps extends RobotPrompt {

	public DGoalSteps(){
		super(DrinkPromptNames.GOALSTEPS);
	}


	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "Great.  I appreciate your being willing to set goals that you think can enhance your health.  " +
				"What steps might you take to achieve those goals?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return this.usersResponsesToList(DrinkPromptNames.GOALSTEPS, DrinkPromptNames.GOALSTEPS,
				"no steps", "multiple steps");
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return DrinkPromptNames.INFORMATION;
	}

	@Override
	public List<String> getDynamicComments() {
		return this.toLinkedList("So, you are just starting to think about how you might make some changes.",
				"You already have some ideas on how you might drink less.");
	}
}
