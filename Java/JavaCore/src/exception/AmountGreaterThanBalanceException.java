package exception;

public class AmountGreaterThanBalanceException extends Exception {
    private String code = "04";
    private String message = "Số tiền thanh toán không hợp lệ";

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
