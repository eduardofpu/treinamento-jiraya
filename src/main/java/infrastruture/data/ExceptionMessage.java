package infrastruture.data;

import java.io.Serializable;
import java.util.Objects;

public class ExceptionMessage implements Serializable {

    private String title;
    private String code;
    private String message;
    private String details;

    public ExceptionMessage(String title, String code, String message, String details) {
        this.title = title;
        this.code = code;
        this.message = message;
        this.details = details;
    }

    public static ExceptionMessage valueOf(String title, String code, String message, String details) {

        return new ExceptionMessage(title, code, message, details);
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExceptionMessage that = (ExceptionMessage) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(code, that.code) &&
                Objects.equals(message, that.message) &&
                Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, code, message, details);
    }

    @Override
    public String toString() {
        return "ExceptionMessage{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
