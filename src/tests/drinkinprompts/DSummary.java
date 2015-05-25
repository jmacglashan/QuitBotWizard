package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DSummary extends RobotPrompt{

	String importanceString;
	String confidenceString;

	public DSummary(){
		super(DrinkPromptNames.SUMMARY);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		int imp = Integer.parseInt(userAnswerDB.get(DrinkPromptNames.IMPORTANCE).get(0));
		int confidence = Integer.parseInt(userAnswerDB.get(DrinkPromptNames.CONFIDENCE).get(0));

		if(imp == 0){
			this.importanceString = "not important";
		}
		else if(imp < 4){
			this.importanceString = "somewhat important";
		}
		else if(imp < 7){
			this.importanceString = "pretty important";
		}
		else{
			this.importanceString = "quite important";
		}

		if(confidence < 4){
			this.confidenceString = "not that confident";
		}
		else if(confidence < 7){
			this.confidenceString = "moderately confident";
		}
		else{
			this.confidenceString = "quite confident";
		}

	}

	@Override
	public String generatePrompt() {
		return "So you think changing your drinking is " + this.importanceString + " " +
				"and you are " + this.confidenceString + " that you can change your drinking if you chose to do so.\n";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return new LinkedList<>();
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return DrinkPromptNames.LIMITS;
	}
}
