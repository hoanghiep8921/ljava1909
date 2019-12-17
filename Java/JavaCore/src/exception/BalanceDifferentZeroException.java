package exception;

public class BalanceDifferentZeroException extends Exception {
    private String code = "02";
    private String message = "Khởi tạo tài khoản số dư phải bằng 0";

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
