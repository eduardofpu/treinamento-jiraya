package infrastruture.data;

import java.io.Serializable;

public class BadRequestData implements Serializable {
    private String detail;

    public BadRequestData(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
}
