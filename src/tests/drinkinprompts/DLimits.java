package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DLimits extends RobotPrompt{

	String sex;

	public DLimits(){
		super(DrinkPromptNames.LIMITS);
	}


	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		this.sex = userAnswerDB.get(DrinkPromptNames.SEX).get(0);
	}

	@Override
	public String generatePrompt() {
		String base = "The federal guidelines drinking that is unlikely to lead to health and social problems in " +
				"healthy adults are that: ";
		if(this.sex.equals("male")){
			base += "Men drink no more than 4 drinks on any day and not more than 14 drinks in any week.";
		}
		else{
			base += "Women drink no more than 3 drinks on any day and not more than 7 drinks in any week.";
		}

		base += "\nA drink is defined as one beer, one shot of 80-proof liquor, or a 5 oz. glass of wine. \n" +
				"Have you heard these guidelines before?";

		return base;
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return this.usersResponsesToList(DrinkPromptNames.LIMITS, DrinkPromptNames.LIMITS, "yes", "no");
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return DrinkPromptNames.GOALS;
	}
}
