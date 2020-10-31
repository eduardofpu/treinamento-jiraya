package infrastruture.exception;

import java.util.LinkedList;
import java.util.List;

import infrastruture.data.BusinessMessage;
import infrastruture.data.ErrorCode;
import infrastruture.data.ErrorCodesMessage;

public class BusinessException extends RuntimeException{

    private transient List<BusinessExceptionDetail> errors;

    public BusinessException(List<BusinessExceptionDetail> errors) {
        super();
        this.errors = errors;
    }

    public BusinessException() {
        super();
    }

    public BusinessException withError(ErrorCode code) {
        addError(code);
        return this;
    }

    public BusinessException withError(ErrorCode code, String detail) {
        addError(code, detail);
        return this;
    }

    public BusinessException withErrorDetails(ErrorCode code, List<String> params) {
        addError(code, params);
        return this;
    }

    public void addError(BusinessExceptionDetail err) {
        if (errors == null) {
            errors = new LinkedList<>();
        }
        errors.add(err);
    }


    public void addError(List<BusinessMessage> messages) {
        if (messages == null || messages.isEmpty()) {
            return;
        }
        if (errors == null) {
            errors = new LinkedList<>();
        }
        messages.forEach(m -> {
            BusinessExceptionDetail det = new BusinessExceptionDetail();
            det.setCode(m.getErrorCode());
            det.setCustomMessage(m.getMessage());
            det.setDetail(m.getDetail());
            det.setCustomTitle(m.getTitle());
            errors.add(det);
        });
    }

    public void addError(ErrorCode code, List<String> params) {
        addError(new BusinessExceptionDetail(code, params));
    }

    public void addError(ErrorCode code) {
        addError(new BusinessExceptionDetail(code));
    }

    public void addError(ErrorCode code, String detail) {
        addError(new BusinessExceptionDetail(code, detail));
    }

    public BusinessException(ErrorCode key, Throwable cause) {
        super(key.getCode(), cause);
        addError(key);
    }

    public BusinessException(ErrorCode key) {
        super(key.getCode());
        addError(key);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public List<BusinessExceptionDetail> getErrors() {
        return errors;
    }

    public void setErrors(List<BusinessExceptionDetail> errors) {
        this.errors = errors;
    }

    public boolean validateLockException() {
        return this.getErrors().stream().anyMatch(businessExceptionDetail -> businessExceptionDetail.getCode()
                .equals(ErrorCodesMessage.LOCKER_ERROR));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((errors == null) ? 0 : errors.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BusinessException other = (BusinessException) obj;
        if (errors == null) {
            if (other.errors != null)
                return false;
        } else if (!errors.equals(other.errors))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BusinessException [errors=" + errors + "]";
    }

}
