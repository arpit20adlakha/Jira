package exception;

public class SummaryInvalidException extends Exception{
    public SummaryInvalidException() {}

    public SummaryInvalidException(String message){
        super(message);
    }
}
