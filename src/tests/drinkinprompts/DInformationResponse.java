package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DInformationResponse extends RobotPrompt {

	protected String wantsInformation;

	public DInformationResponse(){
		super(DrinkPromptNames.INFORMATIONRESPONSE);
	}


	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		this.wantsInformation = userAnswerDB.get(DrinkPromptNames.INFORMATION).get(0);
	}

	@Override
	public String generatePrompt() {
		if(this.wantsInformation.equals("yes")){
			return "Very good! I’ll make sure the research assistant gives you that sheet before you go.";
		}
		return "Thank you for talking with me today.";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return new LinkedList<>();
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return null;
	}
}
