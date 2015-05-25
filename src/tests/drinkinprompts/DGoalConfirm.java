package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DGoalConfirm extends RobotPrompt {

	int perDay;
	int perWeek;

	public DGoalConfirm(){
		super(DrinkPromptNames.GOALCONFIRM);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		this.perDay = Integer.parseInt(userAnswerDB.get(DrinkPromptNames.GOALDPDAY).get(0));
		this.perWeek = Integer.parseInt(userAnswerDB.get(DrinkPromptNames.GOALDPWEEK).get(0));
	}

	@Override
	public String generatePrompt() {
		return "So your goal would be to limit yourself to no more than " + this.perDay + " drinks on any day and no " +
				"more than " + this.perWeek + " drinks in any week.  Is that right?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return this.usersResponsesToList(DrinkPromptNames.GOALCONFIRM, DrinkPromptNames.GOALCONFIRM, "yes", "no");
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {

		String confirm = userAnswerDB.get(DrinkPromptNames.GOALCONFIRM).get(0);
		if(confirm.equals("no")){
			return DrinkPromptNames.GOALCNO;
		}

		return DrinkPromptNames.GOALSTEPS;
	}
}
