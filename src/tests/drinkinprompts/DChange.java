package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DChange extends RobotPrompt{

	public DChange(){
		super(DrinkPromptNames.CHANGE);
	}


	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "Have you recently thought about changing your drinking?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return this.usersResponsesToList(DrinkPromptNames.CHANGE, DrinkPromptNames.CHANGE,
				"yes",
				"no");
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		String ans = userAnswerDB.get(DrinkPromptNames.CHANGE).get(0);
		if(ans.equals("yes")){
			return DrinkPromptNames.IMPORTANCE;
		}
		return DrinkPromptNames.GOALS;
	}
}
