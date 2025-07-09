package com.pruebatecnicaqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import static com.pruebatecnicaqa.userinterfaces.CheckoutCompletePage.COMPLETE_HEADER;

public class CheckoutConfirmationMessage implements Question<Boolean> {
    public static CheckoutConfirmationMessage isVisible() {
        return new CheckoutConfirmationMessage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return COMPLETE_HEADER.resolveFor(actor).isVisible();
        } catch (Exception e) {
            return false;
        }
    }
} 