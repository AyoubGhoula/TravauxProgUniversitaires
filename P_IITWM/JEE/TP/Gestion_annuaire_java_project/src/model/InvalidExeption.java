package model;

public class InvalidExeption extends Exception {

	private static final long serialVersionUID = 1L;

public InvalidExeption(String msg) {
	super(msg);
}


@Override
public String getMessage() {
	return super.getMessage();
}
}
