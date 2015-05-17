package tests.prompts;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

public class LikesRP extends RobotPrompt {

	String activity;
	
	public LikesRP(){
		super(PromptScreenNameConstants.LIKES);
	}
	
	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		this.activity = userAnswerDB.get("activity").get(0);
	}

	@Override
	public String generatePrompt() {
		return "Tell me some of the good things about your " + this.activity +".";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		LinkedList<UserResponseOption> options = new LinkedList<>();
		
		options.add(new UserResponseOption(this.screenId, "helps you have fun"));
		options.add(new UserResponseOption(this.screenId, "helps relax or destress you"));
		options.add(new UserResponseOption(this.screenId, "makes it easier to socialize"));
		options.add(new UserResponseOption(this.screenId, "fills a need you have"));
		options.add(new UserResponseOption(this.screenId, "tastes good"));
		options.add(new UserResponseOption(this.screenId, "gives you something to talk about with people later"));
		options.add(new UserResponseOption(this.screenId, "makes you feel like a part of the group"));
		options.add(new UserResponseOption(this.screenId, "other things"));
		
		return options;
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return PromptScreenNameConstants.DISLIKES;
	}

}
