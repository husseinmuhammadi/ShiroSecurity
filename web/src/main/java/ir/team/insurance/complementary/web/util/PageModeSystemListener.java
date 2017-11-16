package ir.team.insurance.complementary.web.util;

import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

public class PageModeSystemListener implements SystemEventListener {

    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        String mode = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("mode");
        if (event.getSource() instanceof UIInput && mode.equals("view")) {
            UIInput uiInput = (UIInput) event.getSource();
            uiInput.getAttributes().put("disabled", true);
        } else if (event.getSource() instanceof HtmlCommandButton) {
            UICommand uiCommand = (UICommand) event.getSource();
            if (!uiCommand.getId().contains(mode + "Button")) {
                uiCommand.setRendered(false);
            }
        }
    }

    @Override
    public boolean isListenerForSource(Object source) {
        String mode = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("mode");
        return source instanceof UIComponent && (mode != null);
    }
}
