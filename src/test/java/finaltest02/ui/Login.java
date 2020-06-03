package finaltest02.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Login {
    public static Target EMAIL_FIELD = Target.the("email field").locatedBy("//input[@type='email']");
    public static Target PASSWORD_FIELD = Target.the("password field").locatedBy("//input[@type='password']");
    public static Target LOGIN_BTN = Target.the("dang nhap button").locatedBy("//button[contains(text(),'ng nh')]");
    public static Target OTP = Target.the("OTP FIELD").locatedBy("//input[@type='text']");
    public static Target CONFIRM_BTN = Target.the("CONFIRM BUTTON").locatedBy("//button[contains(text(),'Confirm email')]");

}
