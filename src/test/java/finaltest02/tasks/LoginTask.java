package finaltest02.tasks;

import finaltest02.ui.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTask implements Task {
    private String username;
    private String password;
    public LoginTask(String username, String password){
        this.username = username;
        this.password = password;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(Login.EMAIL_FIELD),
                Enter.theValue(password).into(Login.PASSWORD_FIELD),
                Click.on(Login.LOGIN_BTN)
        );

    }
    public static LoginBuilder withUserName(String email){
        return new LoginBuilder(email);
    }
    public static class LoginBuilder{
        private String email;
        public LoginBuilder(String email){
            this.email = email;
        }
        public LoginTask andPassword(String passWord){
            return instrumented(LoginTask.class, this.email, passWord);
        }

    }
}
