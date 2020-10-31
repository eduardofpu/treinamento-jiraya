package infrastruture.exception;

import java.util.LinkedList;
import java.util.List;

import infrastruture.data.ErrorCode;

public class BusinessExceptionDetail {

    /**
     * Código de erro padrão
     */
    private ErrorCode code;

    /**
     * Detalhes sobre o erro determinado por [code]. Exemplo: code: FIELD_VALIDATION_REQUIRED / detail: portInMsisDn
     */
    private String detail;

    /**
     * Contém custom Title for the error message.
     */
    private String customTitle;

    /**
     * Contém custom Message for the error message
     */
    private String customMessage;

    private List<String> params;

    public BusinessExceptionDetail() {
    }

    /**
     * @param code   - Código do erro
     * @param params - Lista de parametros (nomes) para serem substituídos na mensagem padrão de erro
     */
    public BusinessExceptionDetail(ErrorCode code, List<String> params) {
        super();
        this.code = code;
        this.params = params;
    }

    /**
     * @param code   - Código do erro
     * @param detail - Detalhes do erro
     */
    public BusinessExceptionDetail(ErrorCode code, String detail) {
        super();
        this.code = code;
        this.detail = detail;
    }

    public BusinessExceptionDetail(ErrorCode code) {
        super();
        this.code = code;
    }


    public List<String> getParams() {
        return params;
    }

    public void addParams(String... param) {
        if (params == null) {
            params = new LinkedList<>();
        }
        for (String str : param) {
            params.add(str);
        }
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCustomTitle() {
        return customTitle;
    }

    public void setCustomTitle(String customTitle) {
        this.customTitle = customTitle;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((customMessage == null) ? 0 : customMessage.hashCode());
        result = prime * result + ((customTitle == null) ? 0 : customTitle.hashCode());
        result = prime * result + ((detail == null) ? 0 : detail.hashCode());
        result = prime * result + ((params == null) ? 0 : params.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) { //NOSONAR
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BusinessExceptionDetail other = (BusinessExceptionDetail) obj;
        if (code != other.code)
            return false;
        if (customMessage == null) {
            if (other.customMessage != null)
                return false;
        } else if (!customMessage.equals(other.customMessage))
            return false;
        if (customTitle == null) {
            if (other.customTitle != null)
                return false;
        } else if (!customTitle.equals(other.customTitle))
            return false;
        if (detail == null) {
            if (other.detail != null)
                return false;
        } else if (!detail.equals(other.detail))
            return false;
        if (params == null) {
            if (other.params != null)
                return false;
        } else if (!params.equals(other.params))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BusinessExceptionDetail [code=" + code + ", detail=" + detail + ", customTitle=" + customTitle
                + ", customMessage=" + customMessage + ", params=" + params + "]";
    }

}
