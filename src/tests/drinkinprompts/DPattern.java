package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author James MacGlashan.
 */
public class DPattern extends RobotPrompt{

	int daysPerWeek = 0;
	int drinksPerWeek = 0;

	public DPattern() {
		super(DrinkPromptNames.PATTERN);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		this.daysPerWeek = Integer.parseInt(userAnswerDB.get(DrinkPromptNames.DAYSPERWEEK).get(0));
		this.drinksPerWeek = Integer.parseInt(userAnswerDB.get(DrinkPromptNames.DRINKSPERWEEK).get(0));

	}

	@Override
	public String generatePrompt() {
		return "I first want to learn a bit more about your current patterns of drinking.\n" +
				"From the information you gave us, I understand that you drink about " + this.daysPerWeek + " days per " +
				"week and about " + this.drinksPerWeek + " drinks per week.\n";
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return new LinkedList<>();
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		return DrinkPromptNames.GOOD;
	}

	@Override
	public List<String> getDynamicComments(){
		List<String> comments = new LinkedList<>();
		comments.add("When do you usually drink alcohol?");
		comments.add("Okay");
		comments.add("When do you tend to drink the most?");
		comments.add("I see.");

		return comments;
	}
}
