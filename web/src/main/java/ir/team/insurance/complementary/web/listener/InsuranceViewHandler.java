package ir.team.insurance.complementary.web.listener;

import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

public class InsuranceViewHandler extends ViewHandlerWrapper {

    private ViewHandler wrapped;

    public InsuranceViewHandler(ViewHandler wrapped) {
        this.wrapped = wrapped;
    }


    @Override
    public ViewHandler getWrapped() {
        return wrapped;
    }

    @Override
    public UIViewRoot restoreView(FacesContext context, String viewId) {
        UIViewRoot uiViewRoot = wrapped.restoreView(context, viewId);
        if (uiViewRoot == null) {
            return createView(context, viewId);
        }
        return uiViewRoot;
    }




}
