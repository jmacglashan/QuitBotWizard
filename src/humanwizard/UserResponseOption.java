package humanwizard;

import java.util.LinkedList;

public class UserResponseOption {
	public String screenId;
	public String responseKey;
	public String userResponse;
	public boolean isDynamicResponse;

	public UserResponseOption(String screenId, String responseKey, String userResponse, boolean isDynamicResponse){
		this.screenId = screenId;
		this.responseKey = responseKey;
		this.userResponse = userResponse;
		this.isDynamicResponse = isDynamicResponse;
	}

	public UserResponseOption(String screenId, String responseKey, String userResponse){
		this(screenId, responseKey, userResponse, false);
	}
	
	public UserResponseOption(String screenId, String userResponse){
		this(screenId, screenId, userResponse);
	}
	
	
	@Override
	public boolean equals(Object other){
		if(this == other){
			return true;
		}
		
		UserResponseOption o = (UserResponseOption)other;
		return this.screenId.equals(o.screenId) && this.responseKey.equals(o.responseKey) && this.userResponse.equals(o.userResponse);
	}




}
