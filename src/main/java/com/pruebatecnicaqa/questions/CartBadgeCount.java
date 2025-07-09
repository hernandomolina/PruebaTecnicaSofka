package com.pruebatecnicaqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;

import static com.pruebatecnicaqa.userinterfaces.ProductsPage.SHOPPING_CART_BADGE;

public class CartBadgeCount implements Question<String> {

    public static Question<String> value() {
        return new CartBadgeCount();
    }

    @Override
    public String answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                WaitUntil.the(SHOPPING_CART_BADGE, WebElementStateMatchers.isPresent())
                        .forNoMoreThan(10).seconds()
            );
            return Text.of(SHOPPING_CART_BADGE).answeredBy(actor);
        } catch (Exception e) {
            return "";
        }
    }
} 