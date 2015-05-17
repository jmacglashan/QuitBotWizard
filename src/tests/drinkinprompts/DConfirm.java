package tests.drinkinprompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author James MacGlashan.
 */
public class DConfirm extends RobotPrompt{

	protected List<String> good;
	protected List<String> bad;

	public DConfirm(){
		super(DrinkPromptNames.CONFIRM);
	}

	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {

		Random rand = new Random();

		List<String> goodCopy = new ArrayList<>(userAnswerDB.get(DrinkPromptNames.GOOD));
		List<String> badCopy = new ArrayList<>(userAnswerDB.get(DrinkPromptNames.BAD));

		this.good = new ArrayList<>(goodCopy.size());
		this.bad = new ArrayList<>((badCopy.size()));

		while(this.good.size() < 3 && goodCopy.size() > 0){
			int ind = rand.nextInt(goodCopy.size());
			this.good.add(goodCopy.get(ind));
			goodCopy.remove(ind);
		}

		while(this.bad.size() < 5 && badCopy.size() > 0){
			int ind = rand.nextInt(badCopy.size());
			this.bad.add(badCopy.get(ind));
			badCopy.remove(ind);
		}

	}

	@Override
	public String generatePrompt() {

		String good = this.itemsToString(this.good);
		String bad = this.itemsToString(this.bad);

		String resposne = "I heard you say that you like that it " + good + "; but not that it " + bad +
				". Is that right?\n";

		return resposne;
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		return this.usersResponsesToList(DrinkPromptNames.CONFIRM, DrinkPromptNames.CONFIRM, "yes", "no");
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {

		String answer = userAnswerDB.get(DrinkPromptNames.CONFIRM).get(0);
		if(answer.equals("yes")){
			return DrinkPromptNames.CHANGE;
		}

		//clear old responses
		userAnswerDB.remove(DrinkPromptNames.GOOD);
		userAnswerDB.remove(DrinkPromptNames.BAD);
		userAnswerDB.remove(DrinkPromptNames.CONFIRM);

		return DrinkPromptNames.GOOD;
	}


	protected String itemsToString(List<String> items){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < items.size(); i++){
			if(i == items.size()-1){
				if(i == 1){
					sb.append(" and ");
				}
				else if(i > 0){
					sb.append(", and ");
				}
			}
			else if(i > 0){
				sb.append(", ");
			}
			sb.append(items.get(i));

		}

		return sb.toString();
	}
}
