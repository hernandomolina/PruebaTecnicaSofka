package com.pruebatecnicaqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import static com.pruebatecnicaqa.userinterfaces.CheckoutPage.CONTINUE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickContinueTask implements Task {
    public static ClickContinueTask click() {
        return instrumented(ClickContinueTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(CONTINUE_BUTTON, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds(),
            Click.on(CONTINUE_BUTTON)
        );
    }
} 