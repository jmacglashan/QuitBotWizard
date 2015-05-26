package humanwizard;

import java.util.*;

public abstract class RobotPrompt {
	
	protected String screenId;
	
	public RobotPrompt(String screenId){
		this.screenId = screenId;
	}
	
	public String getScreenId(){
		return this.screenId;
	}
	
	public abstract void enterWithAnswers(Map<String, List<String>> userAnswerDB);
	public abstract String generatePrompt();
	public abstract List<UserResponseOption> generatePossibleUserResponses();
	public abstract String nextScreen(Map<String, List<String>> userAnswerDB);

	public Set<String> getRequiredQuestions(){
		return new HashSet<>(0);
	}

	public List<String> getRequiredAnswers(){
		return new LinkedList<>();
	}

	public List<String> getDynamicComments(){
		List<String> comments = new ArrayList<>();
		//comments.add("Some comment");
		return comments;
	}


	protected LinkedList<String> toLinkedList(String...args){
		LinkedList <String> items = new LinkedList<>();
		for(String a : args){
			items.add(a);
		}
		return items;
	}

	protected Set<String> toSet(String...args){
		HashSet<String> set = new HashSet<>(args.length);
		for(String s : args){
			set.add(s);
		}
		return set;
	}

	protected LinkedList<UserResponseOption> usersResponsesToList(String screenId, String responseKey, String...options){
		LinkedList<UserResponseOption> loptions = new LinkedList<>();
		for(String o : options){
			loptions.add(new UserResponseOption(screenId, responseKey, o));
		}
		return loptions;
	}
	
}
