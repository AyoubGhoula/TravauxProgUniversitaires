package exception;

public class ExisteDejaException extends Exception {
    private static final long serialVersionUID = 1L;

    public ExisteDejaException(String message) {
        super(message);
    }
}