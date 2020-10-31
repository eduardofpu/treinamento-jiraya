package infrastruture.data;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessMessage {

    @JsonIgnore
    private ErrorCode errorCode;

    private String code;

    private String detail;

    private String title;

    private String message;

    public BusinessMessage(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.code = errorCode.getCode();
    }

    public BusinessMessage(ErrorCode errorCode, String title, String message) {
        this(errorCode);
        this.title = title;
        this.message = message;
    }

    public BusinessMessage(ErrorCode errorCode, String title, String message, String detail) {
        this(errorCode, title, message);
        this.detail = detail;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessMessage that = (BusinessMessage) o;
        return Objects.equals(getErrorCode(), that.getErrorCode()) &&
                Objects.equals(getCode(), that.getCode()) &&
                Objects.equals(getDetail(), that.getDetail()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getErrorCode(), getCode(), getDetail(), getTitle(), getMessage());
    }
}
