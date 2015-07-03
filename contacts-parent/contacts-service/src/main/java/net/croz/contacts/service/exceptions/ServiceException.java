package net.croz.contacts.service.exceptions;

@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public enum ErrorType {
		DB_ERROR(20), UNRESOLVED_SERVER_ERROR(100), BUSINESS_ERROR(101);

		private final int id;

		ErrorType(int id) {
			this.id = id;
		}

		public int getValue() {
			return id;
		}
	}

	private ErrorType errorType;

	public ServiceException(ErrorType t, String message) {
		super(message);
		this.errorType = t;
	}

	public ErrorType getErrorType() {
		return errorType;
	}
	
	
}
