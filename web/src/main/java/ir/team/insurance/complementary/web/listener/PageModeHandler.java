package ir.team.insurance.complementary.web.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PageModeHandler implements PhaseListener {
    @Override
    public void afterPhase(PhaseEvent event) {
//        Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();
//        if (viewMap != null &&
//                !FacesContext.getCurrentInstance().getExceptionHandler().getHandledExceptionQueuedEvents().iterator().hasNext()) {
//            Set<Map.Entry<String, Object>> entries = viewMap.entrySet();
//            for (Map.Entry<String, Object> entry : entries) {
//                if (entry.getValue() instanceof BaseController && entry.getValue() instanceof BaseControllerService) {
//                    BaseController baseController = (BaseController) entry.getValue();
//                    BaseControllerService abstractLoadControllerService = ((BaseControllerService) entry.getValue());
//                    if (abstractLoadControllerService.getEntity() instanceof Transferable) {
//                        JsonObject jsonObject = ((Transferable) abstractLoadControllerService.getEntity()).toJsonObject();
//                        if (abstractLoadControllerService.isDialog()) {
//                            RequestContext.getCurrentInstance().closeDialog(abstractLoadControllerService.getDialogName());
//                            // send close dialog statement
//                        }
//                    }
//                }
//            }

            // close dialog statement
            // send data to parent page
//        }

    }

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("");
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}
