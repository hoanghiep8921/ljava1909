package exception;

public class NameNotBlankException extends Exception {
    private String code = "01";
    private String message = " Tên không được để trống";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
