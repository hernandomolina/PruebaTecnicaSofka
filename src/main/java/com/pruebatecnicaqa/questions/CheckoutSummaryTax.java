package com.pruebatecnicaqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import static com.pruebatecnicaqa.userinterfaces.CheckoutOverviewPage.SUMMARY_TAX;

public class CheckoutSummaryTax implements Question<String> {

    public static Question<String> value() {
        return new CheckoutSummaryTax();
    }

    @Override
    public String answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                WaitUntil.the(SUMMARY_TAX, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
            );
            return Text.of(SUMMARY_TAX).answeredBy(actor);
        } catch (Exception e) {
            return "";
        }
    }
} 