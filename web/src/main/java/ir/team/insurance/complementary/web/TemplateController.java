package ir.team.insurance.complementary.web;

import ir.team.insurance.complementary.web.user.UserInformation;
import org.apache.shiro.SecurityUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;

@Named
@SessionScoped
public class TemplateController implements Serializable {

    @Inject
    private UserInformation userInformation;

    private String localeValue = "fa_IR";

    private boolean administrator;

    public String getLocaleValue() {
        administrator = SecurityUtils.getSubject().hasRole("administrator");
        return localeValue;
    }

    @PostConstruct
    private void init() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("fa", "IR"));
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public boolean isAdministrator() {
        return administrator;
    }
}
