package com.pruebatecnicaqa.tasks;

import com.pruebatecnicaqa.models.Credentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import static com.pruebatecnicaqa.userinterfaces.LoginPage.*;
import static com.pruebatecnicaqa.userinterfaces.ProductsPage.INVENTORY_CONTAINER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTask implements Task {
    private final Credentials credentials;
    private final boolean expectSuccess;

    public LoginTask(Credentials credentials, boolean expectSuccess) {
        this.credentials = credentials;
        this.expectSuccess = expectSuccess;
    }

    public static LoginTask withCredentials(Credentials credentials) {
        return instrumented(LoginTask.class, credentials, true);
    }

    public static LoginTask withInvalidCredentials(Credentials credentials) {
        return instrumented(LoginTask.class, credentials, false);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Open.url(URL),
            Enter.theValue(credentials.getUsername()).into(USERNAME_FIELD),
            Enter.theValue(credentials.getPassword()).into(PASSWORD_FIELD),
            Click.on(LOGIN_BUTTON)
        );

        // Solo verificar el contenedor de productos si esperamos un login exitoso
        if (expectSuccess) {
            actor.attemptsTo(
                WaitUntil.the(INVENTORY_CONTAINER, WebElementStateMatchers.isPresent())
                        .forNoMoreThan(10).seconds()
            );
        }
    }
} 