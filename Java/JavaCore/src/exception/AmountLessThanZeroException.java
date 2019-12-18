package exception;

public class AmountLessThanZeroException extends Exception {
    private String code = "03";
    private String message = " Số tiền nạp vào tài khoản phải lớn hơn 0";

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
