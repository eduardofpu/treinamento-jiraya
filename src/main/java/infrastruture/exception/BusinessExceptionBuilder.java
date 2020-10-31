package infrastruture.exception;

import java.util.LinkedList;
import java.util.List;

import infrastruture.data.BusinessMessage;
import infrastruture.data.ErrorCode;

public class BusinessExceptionBuilder {

    private BusinessException ex;

    private List<BusinessExceptionDetail> details;

    private Exception cause;

    private BusinessExceptionDetail detail;

    public static BusinessExceptionBuilder newBuilder() {
        return new BusinessExceptionBuilder();
    }

    private BusinessException getException(Exception cause) {
        if (ex == null) {
            ex = new BusinessException(cause);
            ex.setErrors(details);
        }
        return ex;
    }

    private List<BusinessExceptionDetail> getDetails() {
        if (details == null) {
            details = new LinkedList<>();
        }
        return details;
    }

    private BusinessExceptionDetail getExceptionDetail() {
        if (detail == null) {
            detail = new BusinessExceptionDetail();
        }
        return detail;
    }

    public BusinessExceptionBuilder newError(ErrorCode code) {
        if (getExceptionDetail().getCode() == null) {
            getExceptionDetail().setCode(code);
        } else {
            getDetails().add(getExceptionDetail());
            detail = new BusinessExceptionDetail();
            detail.setCode(code);
        }
        return this;
    }

    public BusinessExceptionBuilder withDetailAndParam(String string) {
        return withDetail(string).withParam(string);
    }

    public BusinessExceptionBuilder withDetail(String string) {
        getExceptionDetail().setDetail(string);
        return this;
    }

    public boolean hasErrors() {
        return detail != null;
    }

    public BusinessException build() {
        if (detail.getCode() != null) {
            getDetails().add(detail);
        }
        return getException(cause);
    }

    public BusinessExceptionBuilder withParam(String... param) {
        getExceptionDetail().addParams(param);
        return this;
    }

    public BusinessExceptionBuilder withTitle(String title) {
        getExceptionDetail().setCustomTitle(title);
        return this;
    }

    public BusinessExceptionBuilder withMessage(String message) {
        getExceptionDetail().setCustomMessage(message);
        return this;
    }

    public BusinessExceptionBuilder withException(Exception cause) {
        this.cause = cause;
        return this;
    }

    public BusinessExceptionBuilder withBussinesMessage(BusinessMessage message) {
        getExceptionDetail().setCode(message.getErrorCode());
        getExceptionDetail().setCustomMessage(message.getMessage());
        getExceptionDetail().setCustomTitle(message.getTitle());
        getExceptionDetail().setDetail(message.getDetail());
        return this;
    }

}
