package com.pruebatecnicaqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import static com.pruebatecnicaqa.userinterfaces.CheckoutOverviewPage.FINISH_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FinishCheckoutTask implements Task {
    public static FinishCheckoutTask complete() {
        return instrumented(FinishCheckoutTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(FINISH_BUTTON, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds(),
            Click.on(FINISH_BUTTON)
        );
    }
} 