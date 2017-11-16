package ir.team.insurance.complementary.web.security;

import ir.team.insurance.complementary.web.util.ResourceBundleUtil;
import org.apache.shiro.SecurityUtils;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@RequestScoped
public class SecurityPermission {
    /*
        @result: If user isn't permitted to do this action, user will see appropriate message and redirect to home page
     */
    public static boolean isPermitted() {
        boolean permitted = SecurityUtils.getSubject().isPermitted("");
        FacesContext context = FacesContext.getCurrentInstance();
        if (!permitted) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, ResourceBundleUtil.getMessageBundle().getString("page.access.deny"),
                    ResourceBundleUtil.getMessageBundle().getString("page.access.deny"));
            context.addMessage(null, facesMessage);
        }
        return permitted;
    }
}
