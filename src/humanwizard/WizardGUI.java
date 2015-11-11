package humanwizard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import keepon.KeepOnNetworkClient;

public class WizardGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	protected Wizard 					wizard;
	
	
	protected JPanel					userResponseContainer;
	protected JPanel					commonComments;
	protected JPanel 					screenComments;
	protected JButton					nextScreenButton;
	protected JTextArea					robotSpeech;
	
	protected List<UserResponseOption>	selectedOptions = new LinkedList<>();
	protected List<UserResponseOption>	dynamicOptions = new LinkedList<>();
	
	protected KeepOnNetworkClient		keepon = null;

	protected Set<String>				screenQuestionsAsked;
	
	
	public WizardGUI(Wizard wizard){
		this.wizard = wizard;
		this.initializeGUIElements();
	}
	
	public void setKeepon(KeepOnNetworkClient keepon){
		this.keepon = keepon;
	}
	
	
	protected void initializeGUIElements(){
		
		this.setPreferredSize(new Dimension(800, 800));
		
		this.userResponseContainer = new JPanel();
		this.userResponseContainer.setPreferredSize(new Dimension(760, 300));
		this.userResponseContainer.setLayout(new GridLayout(4, 4, 10, 10));
		this.userResponseContainer.setBorder(BorderFactory.createTitledBorder("User Responses"));

		this.screenComments = new JPanel();
		this.screenComments.setPreferredSize(new Dimension(760, 100));
		this.screenComments.setLayout(new GridLayout(2, 4, 10, 10));
		this.screenComments.setBorder(BorderFactory.createTitledBorder("Screen Specific Comments"));


		this.robotSpeech = new JTextArea("Hit the User Finished Responding button to start the session.", 7, 60);
		this.robotSpeech.setEditable(false);
		this.robotSpeech.setLineWrap(true);
		this.robotSpeech.setWrapStyleWord(true);
		this.robotSpeech.setPreferredSize(new Dimension(750, 200));
		this.nextScreenButton = new JButton("User Finished Responding");
		this.nextScreenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				WizardGUI.this.nextScreen();
			}
		});
		this.nextScreenButton.setPreferredSize(new Dimension(200, 40));

		JScrollPane rspeechScroll = new JScrollPane(this.robotSpeech);
		JPanel speechPanel = new JPanel();
		speechPanel.setBorder(BorderFactory.createTitledBorder("Robot Speech"));
		speechPanel.add(rspeechScroll);



		this.commonComments = new JPanel(new GridBagLayout());
		this.commonComments.setPreferredSize(new Dimension(760, 100));
		this.commonComments.setBorder(BorderFactory.createTitledBorder("General Comments"));

		GridBagConstraints cc = new GridBagConstraints();

		cc.gridx = 0;
		cc.gridy = 0;
		this.commonComments.add(this.getCommentButton("Can you repeat that?"),cc);

		cc.gridx = 1;
		this.commonComments.add(this.getCommentButton("I'm not sure what that means."),cc);

		cc.gridx = 2;
		this.commonComments.add(this.getCommentButton("Today we're talking about you"),cc);

		cc.gridx = 3;
		this.commonComments.add(this.getCommentButton("Thank you."),cc);

		cc.gridx = 0;
		cc.gridy = 1;
		cc.weightx=1.;
		cc.gridwidth=2;
		cc.fill=GridBagConstraints.HORIZONTAL;
		JTextField customField = new JTextField();
		this.commonComments.add(customField, cc);

		cc.gridx = 2;
		cc.gridwidth = 1;
		this.commonComments.add(this.getCommentButton(customField), cc);


		this.getContentPane().setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.getContentPane().add(speechPanel, c);

		c.gridy++;
		//c.insets = new Insets(20,0,0,0);
		this.getContentPane().add(this.commonComments, c);

		c.gridy++;
		this.getContentPane().add(this.screenComments, c);

		c.gridy++;
		this.getContentPane().add(this.userResponseContainer, c);

		c.gridy++;
		this.getContentPane().add(this.nextScreenButton, c);

		
	}
	
	
	public void startGUI(){
		this.pack();
		this.setVisible(true);
	}
	
	
	protected JToggleButton createJButtonForUserResponse(final UserResponseOption option){
		
		final JToggleButton button = new JToggleButton(option.userResponse);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(button.isSelected()){
					WizardGUI.this.addUserResponse(option);
				}
				else{
					WizardGUI.this.removeUserResponse(option);
				}
				WizardGUI.this.checkProgression();
				
			}
		});

		if(option.userResponse.length() > 40){
			button.setFont(new Font("Arial", Font.PLAIN, 8));
		}
		else if(option.userResponse.length() > 20){
			button.setFont(new Font("Arial", Font.PLAIN, 10));
		}


		
		return button;
	}

	protected JTextField createJTextFieldForUserResponse(final UserResponseOption option){
		final JTextField field = new JTextField(option.responseKey);
		field.setColumns(10);
		field.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				option.userResponse = field.getText();
				checkProgression();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				option.userResponse = field.getText();
				checkProgression();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				option.userResponse = field.getText();
				checkProgression();
			}
		});

		return field;
	}

	protected JButton getCommentButton(final String speechText){

		final JButton button = new JButton(speechText);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentText = WizardGUI.this.robotSpeech.getText();
				currentText += "\n\n"+speechText;
				WizardGUI.this.robotSpeech.setText(currentText);
				WizardGUI.this.say(speechText);
				WizardGUI.this.screenQuestionsAsked.add(speechText);
				WizardGUI.this.checkProgression();
			}
		});

		return button;
	}

	protected JButton getCommentButton(final JTextField sourceField){
		final JButton button = new JButton("Send custom comment");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentText = WizardGUI.this.robotSpeech.getText();
				String speechText = sourceField.getText();
				currentText += "\n\n"+speechText;
				WizardGUI.this.robotSpeech.setText(currentText);
				WizardGUI.this.say(speechText);
			}
		});

		return button;
	}
	
	
	public void nextScreen(){


		for(UserResponseOption o : this.dynamicOptions){
			if(!o.userResponse.equals("") && !o.userResponse.equals(o.responseKey)) {
				System.out.println("Adding dynamic " + o.responseKey + ": " + o.userResponse);
				this.wizard.addAnswer(o);
			}
		}
		this.dynamicOptions.clear();

		System.out.println("Next Screen");

		for(UserResponseOption o : this.selectedOptions){
			this.wizard.addAnswer(o);
		}
		
		this.wizard.changeScreen();
		this.userResponseContainer.removeAll();
		this.selectedOptions.clear();
		this.screenComments.removeAll();
		
		RobotPrompt rp = this.wizard.getCurrentRobotPrompt();
		if(rp == null){
			this.robotSpeech.setText("### No speech; session is over. Press \"User Finished Responding\" to start with a new client.");
			this.wizard.writeToRecordDir("saved");
			this.nextScreenButton.setEnabled(true);
			this.wizard.resetAnswers();
		}
		else{

			this.screenQuestionsAsked = new HashSet<>();
			this.nextScreenButton.setEnabled(false);



			String speechText = rp.generatePrompt();
			this.robotSpeech.setText(speechText);
			List<UserResponseOption> options = rp.generatePossibleUserResponses();
			for(UserResponseOption o : options){
				if(!o.isDynamicResponse) {
					this.userResponseContainer.add(this.createJButtonForUserResponse(o));
				}
				else{
					this.userResponseContainer.add(this.createJTextFieldForUserResponse(o));
					this.dynamicOptions.add(o);
				}
			}
			List<String> screenComments = rp.getDynamicComments();
			for(String s : screenComments){
				this.screenComments.add(this.getCommentButton(s));
			}
			this.say(speechText);
			this.checkProgression();
			
		}

		this.revalidate();
		this.repaint();

		
	}

	public void say(String speechText){
		if(!speechText.startsWith("###")) {
			System.out.println("Speech event...");
			if(this.keepon != null) {
				this.keepon.say(speechText);
			}
		}
	}
	
	protected void addUserResponse(UserResponseOption option){
		System.out.println("add option " + option.userResponse);
		this.selectedOptions.add(option);
	}
	
	protected void removeUserResponse(UserResponseOption option){
		System.out.println("remove option: " + option.userResponse);
		this.selectedOptions.remove(option);
	}

	protected boolean hasSelectedAnswerFor(String key){
		for(UserResponseOption r : this.selectedOptions){
			if(r.responseKey.equals(key)){
				return true;
			}
		}
		return false;
	}
	
	protected void checkProgression(){

		if(this.wizard.getCurrentRobotPrompt() == null){
			return;
		}

		boolean passedQ = false;
		if(this.screenQuestionsAsked.containsAll(this.wizard.getCurrentRobotPrompt().getRequiredQuestions())){
			passedQ = true;
		}

		boolean passedType = true;
		for(UserResponseOption dro : this.dynamicOptions){
			if(dro.responseKey.startsWith("#")){
				//is it a number?
				if(!dro.userResponse.matches("-?\\d+(\\.\\d+)?")){
					passedType = false;
					break;
				}

			}
		}

		boolean passedA = true;
		for(String reqA : this.wizard.getCurrentRobotPrompt().getRequiredAnswers()){
			if(!this.hasSelectedAnswerFor(reqA)){
				passedA = false;
				break;
			}
		}

		if(passedQ && passedType && passedA){
			this.nextScreenButton.setEnabled(true);
		}
		else{
			this.nextScreenButton.setEnabled(false);
		}
	}
	
	

}
