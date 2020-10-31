package infrastruture.exception;

public class IntegrationMessageException {

    private int httpCode;
    private String bodyIntegrationResponse;

    public IntegrationMessageException(int httpCode, String bodyIntegrationResponse) {
        this.httpCode = httpCode;
        this.bodyIntegrationResponse = bodyIntegrationResponse;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getBodyIntegrationResponse() {
        return bodyIntegrationResponse;
    }

    public void setBodyIntegrationResponse(String bodyIntegrationResponse) {
        this.bodyIntegrationResponse = bodyIntegrationResponse;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IntegrationMessageException{");
        sb.append("httpCode=").append(httpCode);
        sb.append(", bodyIntegrationResponse='").append(bodyIntegrationResponse).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
