package finaltest02.features.search;

import finaltest02.abilities.Authenticate;
import finaltest02.questions.Verification;
import finaltest02.tasks.LoginTask;
import finaltest02.tasks.VerifyOTP;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import finaltest02.tasks.OpenTheApplication;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class LoginViaOTPStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser)).
                can(Authenticate.LoadTestData(anna.getName()));
    }

    @Test
    public void login_via_otp() {

        givenThat(anna).wasAbleTo(openTheApplication);


        when(anna).attemptsTo(
                LoginTask.withUserName(Authenticate.as(anna).getEmail()).andPassword(Authenticate.as(anna).getPassword()),
                VerifyOTP.withOTP()

        );

        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("BDD In Action"))));

    }
}