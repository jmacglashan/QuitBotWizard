package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DGoals extends RobotPrompt{

	public DGoals(){
		super(DrinkPromptNames.GOALS);
	}


	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "People are more likely to drink in a way that does not cause problems if they set specific limits " +
				"or goals for themselves around how much they drink.  Would you like to set a goal for yourself " +
				"around healthy drinking?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return this.usersResponsesToList(DrinkPromptNames.GOALS, DrinkPromptNames.GOALS,
				"yes",
				"no");
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {

		String yn = userAnswerDB.get(DrinkPromptNames.GOALS).get(0);

		if(yn.equals("yes")){
			return DrinkPromptNames.GOALYES;
		}

		return DrinkPromptNames.INFORMATION;
	}
}
