package ir.team.insurance.complementary.web.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleUtil {
    private static final String LABEL_BUNDLE = "ir/team/insurance/complementary/web/i18n/label/messages";
    private static final String MESSAGE_BUNDLE = "ir/team/insurance/complementary/web/i18n/message/messages";
    private static final String VALIDATION_BUNDLE = "ir/team/insurance/complementary/web/i18n/validation/messages";

    public static ResourceBundle getResourceBundle(String bundleName) {
        return ResourceBundle.getBundle(bundleName, new Locale("fa", "IR"));
    }

    public static ResourceBundle getMessageBundle() {
        return getResourceBundle(MESSAGE_BUNDLE);
    }

    public static ResourceBundle getLabelBundle() {
        return getResourceBundle(LABEL_BUNDLE);
    }

    public static ResourceBundle getValidationBundle() {
        return getResourceBundle(VALIDATION_BUNDLE);
    }
}
