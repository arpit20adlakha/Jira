package exception;

public class StatusNotFoundException extends Exception{
    public StatusNotFoundException() {

    }

    public StatusNotFoundException(String message) {
        super(message);
    }
}

