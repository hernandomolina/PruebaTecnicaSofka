package com.pruebatecnicaqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import static com.pruebatecnicaqa.userinterfaces.CheckoutPage.ERROR_MESSAGE;

public class CheckoutErrorAbsence implements Question<Boolean> {

    public static Question<Boolean> isNotVisible() {
        return new CheckoutErrorAbsence();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return !Visibility.of(ERROR_MESSAGE).answeredBy(actor);
        } catch (Exception e) {
            return true; // Si no hay elemento de error, consideramos que no hay error
        }
    }
} 