package umu.tds.exceptions;

public class MessageException extends RuntimeException {

	public enum MessageErrorType {
		UNIDENTIFIED,
		IDNOTFOUND,
		NAMENOTFOUND,
		MESSAGENOTFOUND
	}
	
	private MessageErrorType type;

	public MessageException() {
		type = MessageErrorType.UNIDENTIFIED;
	}
	
	public MessageException(MessageErrorType type) {
		this.type = type;
	}
	
	public MessageException(String msg) {
		super(msg);
		type = MessageErrorType.UNIDENTIFIED;
	}
	
	public MessageException(String msg, MessageErrorType type) {
		super(msg);
		this.type = type;
	}
	
	public MessageErrorType getType() {
		return type;
	}
	
	
}
