package ir.team.insurance.complementary.web.validation;

import ir.team.insurance.complementary.web.util.ResourceBundleUtil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

@FacesValidator("matchValidation")
public class MatchValidation implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Object mainComponent = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("singUpForm-password");

        if (value == null && mainComponent == null) {
            return;
        }

        if (!value.equals(mainComponent)) {
            ResourceBundle resourceBundle = ResourceBundleUtil.getValidationBundle();
            String message = resourceBundle.getString("javax.faces.validator.UIInput.EQUAL");
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, MessageFormat.format(message, "کلمه عبور", "تکرار کلمه عبور"), ""));
        }
    }
}
