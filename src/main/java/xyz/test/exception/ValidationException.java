package xyz.test.exception;

public class ValidationException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -1479547110482022368L;
    
    public static final String NULL_VALUE = "Null Field";

    public ValidationException() {
	// TODO Auto-generated constructor stub
    }

    public ValidationException(String message) {
	super(message);
	// TODO Auto-generated constructor stub
    }

    public ValidationException(Throwable cause) {
	super(cause);
	// TODO Auto-generated constructor stub
    }

    public ValidationException(String message, Throwable cause) {
	super(message, cause);
	// TODO Auto-generated constructor stub
    }

    public ValidationException(String message, Throwable cause,
	    boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
	// TODO Auto-generated constructor stub
    }

}
