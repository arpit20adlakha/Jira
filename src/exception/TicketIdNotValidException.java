package exception;

public class TicketIdNotValidException extends Exception{
    public TicketIdNotValidException(String message) {
        super(message);
    }

    public TicketIdNotValidException() {

    }
}
