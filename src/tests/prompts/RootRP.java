package tests.prompts;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

public class RootRP extends RobotPrompt {

	public RootRP() {
		super(PromptScreenNameConstants.ROOT);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		//nothing special to do
	}

	@Override
	public String generatePrompt() {
		return "Before we get started, let me explain a little about how we'll be working together. " +
				"My main job is to listen to you, not to tell you what to do.  I will do my best to " +
				"understand your situation, and then help you consider what, if anything, you might want " +
				"to do differently in the future. If you decide you'd like to make some changes, I can help " +
				"you with that. However, that's certainly up to you, not me or anyone else." + 
				"\n\nWhat activity, behavior, or habit of yours will we be discussing?";


	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		LinkedList<UserResponseOption> options = new LinkedList<>();
		options.add(new UserResponseOption(this.screenId, "activity", "drinking"));
		options.add(new UserResponseOption(this.screenId, "activity", "reddit use"));
		options.add(new UserResponseOption(this.screenId, "activity", "nail biting"));
		options.add(new UserResponseOption(this.screenId, "activity", "smoking"));
		
		return options;
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return PromptScreenNameConstants.LIKES; //nothing next
	}

}
