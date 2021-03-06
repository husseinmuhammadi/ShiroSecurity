package ir.team.insurance.complementary.model.type;

import ir.team.insurance.complementary.model.exception.TypeNotFoundException;

/**
 * Created by hmohammadi on 11/10/17.
 */
public enum LocaleType {
    FA_IR("fa_IR"),
    EN_US("en_US");

    private String locale;

    LocaleType(String locale) {
        this.locale = locale;
    }



    public static LocaleType getInstance(String locale) {
        if (locale == null) {
            return null;
        }
        for (LocaleType localeType : values()) {
            if (localeType.getValue().equals(locale)) {
                return localeType;
            }
        }
        throw new TypeNotFoundException(LocaleType.class.getName() + " locale :" +
                locale);
    }

    public String getValue() {
        return this.locale;
    }
}
