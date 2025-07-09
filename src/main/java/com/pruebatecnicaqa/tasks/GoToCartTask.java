package com.pruebatecnicaqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static com.pruebatecnicaqa.userinterfaces.ProductsPage.SHOPPING_CART_LINK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToCartTask implements Task {
    public static GoToCartTask open() {
        return instrumented(GoToCartTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(SHOPPING_CART_LINK)
        );
    }
} 