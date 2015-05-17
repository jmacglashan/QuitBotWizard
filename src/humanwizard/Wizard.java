package humanwizard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Wizard {

	protected Map<String, RobotPrompt> screenPrompts = new HashMap<String, RobotPrompt>();
	protected String rootPromptScreenId = "root";
	protected Map<String, List<String>> userAnswerDB = new HashMap<>();
	protected RobotPrompt curRobotPrompt = null;
	protected String curScreen = null;
	
	public void addRobotPrompt(RobotPrompt prompt){
		this.screenPrompts.put(prompt.getScreenId(), prompt);
	}
	
	public void setRootPromptScreenId(String screenId){
		this.rootPromptScreenId = screenId;
	}
	
	public RobotPrompt getCurrentRobotPrompt(){
		if(this.curScreen == null){
			this.curRobotPrompt = this.screenPrompts.get(this.rootPromptScreenId);
			this.curRobotPrompt.enterWithAnswers(this.userAnswerDB);
			this.curScreen = this.curRobotPrompt.screenId;
		}
		return curRobotPrompt;
	}
	
	
	public void addAnswer(String key, String value){
		//this.userAnswerDB.put(key, value);
		List<String> answers = this.userAnswerDB.get(key);
		if(answers == null){
			answers = new LinkedList<>();
			this.userAnswerDB.put(key, answers);
		}
		if(!answers.contains(value)){
			answers.add(value);
		}
	}
	
	public void addAnswer(UserResponseOption option){
		List<String> answers = this.userAnswerDB.get(option.responseKey);
		if(answers == null){
			answers = new LinkedList<>();
			this.userAnswerDB.put(option.responseKey, answers);
		}
		if(!answers.contains(option.userResponse)){
			answers.add(option.userResponse);
		}
	}
	
	public void changeScreen(){
		if(this.curScreen == null){
			this.curRobotPrompt = this.screenPrompts.get(this.rootPromptScreenId);
		}
		else{
			String nextScreen = this.curRobotPrompt.nextScreen(this.userAnswerDB);
			if(nextScreen == null){
				this.curRobotPrompt = null;
				return;
			}
			this.curRobotPrompt = this.screenPrompts.get(nextScreen);
		}
		this.curRobotPrompt.enterWithAnswers(this.userAnswerDB);
		this.curScreen = this.curRobotPrompt.screenId;
	}
	
	
}
