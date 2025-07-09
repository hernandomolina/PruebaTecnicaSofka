package com.pruebatecnicaqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import static com.pruebatecnicaqa.userinterfaces.CheckoutOverviewPage.SUMMARY_ITEM_PRICE;

public class CheckoutSummaryPrice implements Question<String> {

    public static Question<String> value() {
        return new CheckoutSummaryPrice();
    }

    @Override
    public String answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                WaitUntil.the(SUMMARY_ITEM_PRICE, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
            );
            return Text.of(SUMMARY_ITEM_PRICE).answeredBy(actor);
        } catch (Exception e) {
            return "";
        }
    }
} 