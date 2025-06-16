package umu.tds.exceptions;

public class UserException extends RuntimeException {
	
	public enum UserErrorType {
		UNIDENTIFIED,
		LOGINID,
		LOGINPASSWORD,
		SIGNUPALREADYEXISTS,
		USERNOTFOUND,
		PASSWORDNOTMATCH,
		USERCHARACTERS,
		PASSWORDCHARACTERS
	}
	
	private UserErrorType type;

	public UserException() {
		type = UserErrorType.UNIDENTIFIED;
	}
	
	public UserException(UserErrorType type) {
		this.type = type;
	}
	
	public UserException(String msg) {
		super(msg);
		type = UserErrorType.UNIDENTIFIED;
	}
	
	public UserException(String msg, UserErrorType type) {
		super(msg);
		this.type = type;
	}
	
	public UserErrorType getType() {
		return type;
	}
	
}
