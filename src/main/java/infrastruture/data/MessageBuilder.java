package infrastruture.data;


import static java.util.stream.Collectors.toList;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import infrastruture.exception.BusinessException;
import infrastruture.exception.BusinessExceptionDetail;

@Component(value = "telecomMessageBuilder")
public class MessageBuilder {

    private static final String MESSAGE_TITLE_SUFFIX = ".title";
    private static final String MESSAGE_BODY_SUFFIX = ".message";

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Environment environment;

    @Autowired
    @Qualifier("defaultLocale")
    private Locale defaultLocale;

    public BusinessMessage buildMessage(BusinessException ex) {

        if (ex.getErrors() == null || CollectionUtils.isEmpty(ex.getErrors())) {
            return null;
        }

        Optional<BusinessMessage> messageOpt = ex.getErrors().stream().map(detail -> extractError(detail)).max(
                (m1, m2) -> {
                    return m1.getErrorCode().getPrecedence() - m2.getErrorCode().getPrecedence();
                });
        if (messageOpt.isPresent()) {
            return messageOpt.get();
        }
        return null;
    }

    private BusinessMessage extractError(BusinessExceptionDetail detail) {

        List<String> translatedParams = detail.getParams() == null ? new LinkedList<>() : detail.getParams().stream().map(
                key -> {
                    return messageSource.getMessage(key, null, key, defaultLocale);
                }).collect(toList());
        String message = null;
        if (StringUtils.isEmpty(detail.getCustomMessage())) {
            message = getMessage(detail.getCode().getCode() + MESSAGE_BODY_SUFFIX, translatedParams);
        } else {
            message = getMessage(detail.getCustomMessage(), translatedParams);
        }
        String title = null;
        if (StringUtils.isEmpty(detail.getCustomTitle())) {
            title = getMessage(detail.getCode().getCode() + MESSAGE_TITLE_SUFFIX, translatedParams);
        } else {
            title = getMessage(detail.getCustomTitle(), translatedParams);
        }
        return new BusinessMessage(detail.getCode(), title, message, detail.getDetail());
    }

    public String getMessage(String key, List<String> params) {
        params = params == null ? new LinkedList<>() : params;

        String message = null;
        try {
            message = messageSource.getMessage(key, params.toArray(), defaultLocale);
        } catch (NoSuchMessageException e) {
            message = environment.getProperty(key);

            if (message != null) {
                message = MessageFormat.format(message, params.toArray());
            }
        }
        return message;
    }

    public String getMessage(String key, String... params) {

        String message = null;
        try {
            message = messageSource.getMessage(key, params, defaultLocale);
        } catch (NoSuchMessageException e) {
            message = environment.getProperty(key);

            if (message != null) {
                message = MessageFormat.format(message, params);
            }
        }
        return message;
    }

    public String getMessageTitle(String key, List<String> params) {
        params = params == null ? new LinkedList<>() : params;
        return messageSource.getMessage(key + MESSAGE_TITLE_SUFFIX, params.toArray(), null, defaultLocale);
    }

    public String getMessageBody(String key, List<String> params) {
        params = params == null ? new LinkedList<>() : params;
        return messageSource.getMessage(key + MESSAGE_BODY_SUFFIX, params.toArray(), null, defaultLocale);
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void setDefaultLocale(Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }
}
