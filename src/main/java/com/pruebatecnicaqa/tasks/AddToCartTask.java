package com.pruebatecnicaqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.conditions.Check;

import static com.pruebatecnicaqa.userinterfaces.ProductsPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddToCartTask implements Task {
    private final String productName;

    public AddToCartTask(String productName) {
        this.productName = productName;
    }

    public static AddToCartTask withName(String productName) {
        return instrumented(AddToCartTask.class, productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(PRODUCT_TITLE.of(productName), WebElementStateMatchers.isVisible())
                    .forNoMoreThan(10).seconds(),
            Check.whether(CLOSE_POPUP_BUTTON.resolveFor(actor).isPresent())
                .andIfSo(Click.on(CLOSE_POPUP_BUTTON)),
            Click.on(ADD_TO_CART_BUTTON.of(productName))
        );
    }
} 