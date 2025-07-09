package com.pruebatecnicaqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import static com.pruebatecnicaqa.userinterfaces.CheckoutOverviewPage.FINISH_BUTTON;

public class CheckoutOverviewPage implements Question<Boolean> {

    public static Question<Boolean> isVisible() {
        return new CheckoutOverviewPage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                WaitUntil.the(FINISH_BUTTON, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
            );
            return TheWebPage.currentUrl().answeredBy(actor).contains("/checkout-step-two.html");
        } catch (Exception e) {
            return false;
        }
    }
} 