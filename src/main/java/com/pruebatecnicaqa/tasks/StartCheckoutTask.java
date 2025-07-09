package com.pruebatecnicaqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import static com.pruebatecnicaqa.userinterfaces.CartPage.CHECKOUT_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartCheckoutTask implements Task {
    public static StartCheckoutTask open() {
        return instrumented(StartCheckoutTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(CHECKOUT_BUTTON, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds(),
            Click.on(CHECKOUT_BUTTON)
        );
    }
} 