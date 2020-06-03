package finaltest02.tasks;

import finaltest02.questions.Verification;
import finaltest02.ui.Login;
import finaltest02.utils.Utility;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VerifyOTP implements Task {

    @Override
    public <T extends Actor> void performAs(T t) {
        String otp = Verification.OTPFromEmail().answeredBy(t);
        int dem = 0;
        while(otp == "" && dem <=10){
            otp = Verification.OTPFromEmail().answeredBy(t);
            dem ++;
        }
        t.attemptsTo(
                Enter.theValue(otp).into(Login.OTP),
                Click.on(Login.CONFIRM_BTN)

        );
    }

    public static VerifyOTP withOTP() {
        return instrumented(VerifyOTP.class);
    }
}
