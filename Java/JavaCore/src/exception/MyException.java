package exception;

public class MyException extends Exception{
    private String code;
    public MyException(String message) {
        super(message);
    }
}
