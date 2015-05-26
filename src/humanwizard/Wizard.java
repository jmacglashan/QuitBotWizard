package humanwizard;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
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
			if(this.curRobotPrompt == null){
				this.curRobotPrompt = this.screenPrompts.get(this.rootPromptScreenId);
			}
			else {

				String nextScreen = this.curRobotPrompt.nextScreen(this.userAnswerDB);
				if(nextScreen == null) {
					this.curRobotPrompt = null;
					return;
				}
				this.curRobotPrompt = this.screenPrompts.get(nextScreen);
			}
		}
		this.curRobotPrompt.enterWithAnswers(this.userAnswerDB);
		this.curScreen = this.curRobotPrompt.screenId;
	}

	public void writeToRecordDir(String pathToDir){
		if(!pathToDir.endsWith("/")){
			pathToDir += "/";
		}

		File dir = new File(pathToDir);
		dir.mkdirs();

		final String ext = ".yaml";

		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if(name.endsWith(ext)){
					return true;
				}
				return false;
			}
		};
		String[] children = dir.list(filter);

		int max = 0;
		for(String r : children){
			String baseName = r.substring(0, r.length()-5);
			int num = Integer.parseInt(baseName);
			max = Math.max(num, max);
		}

		int newId = max+1;

		String nFilePath = pathToDir + newId + ext;

		//put contents into yaml string
		Yaml yaml = new Yaml();
		String output = yaml.dump(this.userAnswerDB);

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(nFilePath));
			out.write(output+"\n");
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}


	}

	public void resetAnswers(){
		this.userAnswerDB.clear();
	}
	
	
}
