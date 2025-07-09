package com.pruebatecnicaqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import static com.pruebatecnicaqa.userinterfaces.CheckoutPage.ERROR_MESSAGE;

public class CheckoutErrorMessage implements Question<String> {

    public static Question<String> value() {
        return new CheckoutErrorMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                WaitUntil.the(ERROR_MESSAGE, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
            );
            return Text.of(ERROR_MESSAGE).answeredBy(actor);
        } catch (Exception e) {
            return "";
        }
    }
} 