package infrastruture.data;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class ExceptionMessageBuild {

    private static final String MESSAGE_TITLE_SUFFIX = ".title";
    private static final String MESSAGE_BODY_SUFFIX = ".message";

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Locale defaultLocale;

    public ExceptionMessage build(String code, List<String> args, String details) {

        String title;
        String message;

        try {
            title = messageSource.getMessage(code + MESSAGE_TITLE_SUFFIX, null, defaultLocale);
            message = messageSource.getMessage(code + MESSAGE_BODY_SUFFIX,
                    (args != null) ? args.toArray() : null, defaultLocale);
        } catch (Exception exception) {
            title = null;
            message = null;
        }

        return ExceptionMessage.valueOf(title, code, message, details);
    }
}
