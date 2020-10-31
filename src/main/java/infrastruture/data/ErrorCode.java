package infrastruture.data;

public class ErrorCode {

    private String code;
    private Integer precedence;

    public ErrorCode(String code) {
        this.code = code;
        this.precedence = 10;
    }

    public ErrorCode(String code, Integer precedence) {
        this.code = code;
        this.precedence = precedence;
    }

    public static ErrorCode of(String code) {
        return new ErrorCode(code);
    }

    public static ErrorCode of(String code, Integer precedence) {
        return new ErrorCode(code, precedence);
    }

    public String getCode() {
        return code;
    }

    public Integer getPrecedence() {
        return precedence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorCode errorCode = (ErrorCode) o;

        return getCode().equals(errorCode.getCode());

    }

    @Override
    public int hashCode() {
        return getCode().hashCode();
    }
}
