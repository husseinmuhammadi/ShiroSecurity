package ir.team.insurance.complementary.web.security;

import ir.team.insurance.complementary.api.UserService;
import ir.team.insurance.complementary.model.to.security.Permission;
import ir.team.insurance.complementary.web.util.ResourceBundleUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

public class SecurityPhaseListener implements PhaseListener {

    @Inject
    private UserService userService;

    @Override
    public void afterPhase(PhaseEvent event) {
        Subject currentUser = SecurityUtils.getSubject();
        FacesContext context = event.getFacesContext();
        if (currentUser.isAuthenticated()) {
            String servletPath = context.getExternalContext().getRequestServletPath();

            Permission permission = userService.findUserPermissions(currentUser.getPrincipal().toString());
            if (permission != null) {
                context.getExternalContext().getSessionMap().put("permission", permission);
            } else {
                unAuthorizeAction(context);
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    private void unAuthorizeAction(FacesContext context) {
        context.responseComplete();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ResourceBundleUtil.getMessageBundle().getString("page.access.deny"),
                ResourceBundleUtil.getMessageBundle().getString("page.access.deny")));
        context.getExternalContext().getFlash().setKeepMessages(true);
        context.getApplication().getNavigationHandler().handleNavigation(context, context.getViewRoot().getViewId(), "noValid");
    }
}
