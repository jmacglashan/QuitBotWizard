package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DWelcome extends RobotPrompt{

	public DWelcome() {
		super(DrinkPromptNames.WELCOME);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

	}

	@Override
	public String generatePrompt() {
		return "Hello, my name is Emai. I am a prototype behavioral counseling robot. Today, we will be discussing alcohol " +
				"and where it fits into your life.  \n" +
				"Before we get started, let me explain a little about how we'll be working together. " +
				"My main job is to listen to you, not to tell you what to do.  I will do my best to understand your " +
				"situation, and then help you consider what, if anything, you might want to do differently in the future. " +
				"If you decide you'd like to make some changes, I can help you with that. However, that's certainly up to " +
				"you, not me or anyone else.\n" +
				"Shall we get started?";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		LinkedList<UserResponseOption> answers = new LinkedList<>();
		return answers;
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return DrinkPromptNames.PATTERN;
	}
}
