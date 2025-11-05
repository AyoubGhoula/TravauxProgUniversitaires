package exception;

public class PersonneIntrouvableException extends Exception {
    private static final long serialVersionUID = 1L;

    public PersonneIntrouvableException(String message) {
        super(message);
    }
}