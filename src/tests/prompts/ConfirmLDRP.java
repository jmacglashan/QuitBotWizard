package tests.prompts;

import humanwizard.RobotPrompt;
import humanwizard.UserResponseOption;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ConfirmLDRP extends RobotPrompt {

	String activity;
	String likeExample;
	String dislikeExample;
	Random rand = new Random();
	
	public ConfirmLDRP(){
		super(PromptScreenNameConstants.CONFIRMLD);
	}
	
	@Override
	public void enterWithAnswers(Map<String, List<String>> userAnswerDB) {
		this.activity = userAnswerDB.get("activity").get(0);
		List<String> likes = userAnswerDB.get(PromptScreenNameConstants.LIKES);
		List<String> dislikes = userAnswerDB.get(PromptScreenNameConstants.DISLIKES);
		if(likes != null && likes.size() > 0){
			this.likeExample = likes.get(rand.nextInt(likes.size()));
		}
		if(dislikes != null && dislikes.size() > 0){
			this.dislikeExample = dislikes.get(rand.nextInt(dislikes.size()));
		}
		

	}

	@Override
	public String generatePrompt() {
		String initial = "So we've been talking a little about the good things about your " + this.activity + ", as well" +
				" as some of the not-so-good things.\n\n";
		
		String likePart = "";
		String dislikePart = "";
		if(this.likeExample != null){
			likePart = "I heard you say that you like that it " + this.likeExample;
			if(this.dislikeExample != null){
				dislikePart = ", but not that it " + this.dislikeExample + ".";
			}
			else{
				dislikePart = " and that you didn't dislike anything about it.";
			}
		}
		else{
			likePart = "I didn't hear you say that you liked anything about it";
			if(this.dislikeExample != null){
				dislikePart = ", but that you did not like that it " + this.dislikeExample + ".";
			}
			else{
				dislikePart = ", nor did you say you dislike anything about it either.";
			}
		}
		
		return initial + likePart + dislikePart + " Is that right?";
				
	}

	@Override
	public List<UserResponseOption> generatePossibleUserResponses() {
		LinkedList<UserResponseOption> options = new LinkedList<>();
		options.add(new UserResponseOption(this.screenId, "yes"));
		options.add(new UserResponseOption(this.screenId, "no"));
		return options;
	}

	@Override
	public String nextScreen(Map<String, List<String>> userAnswerDB) {
		String confirmation = userAnswerDB.get(this.screenId).get(0);
		if(confirmation.equals("yes")){
			return PromptScreenNameConstants.CHANGE;
		}
		//otherwise clear old responses and redo
		userAnswerDB.remove(PromptScreenNameConstants.LIKES);
		userAnswerDB.remove(PromptScreenNameConstants.DISLIKES);
		userAnswerDB.remove(this.screenId);
		return PromptScreenNameConstants.LIKES;
	}

}
