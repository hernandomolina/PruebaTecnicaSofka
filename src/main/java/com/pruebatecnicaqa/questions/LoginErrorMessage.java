package com.pruebatecnicaqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static com.pruebatecnicaqa.userinterfaces.LoginPage.ERROR_MESSAGE;

public class LoginErrorMessage implements Question<String> {

    public static Question<String> value() {
        return new LoginErrorMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
            WaitUntil.the(ERROR_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );
        return Text.of(ERROR_MESSAGE).answeredBy(actor);
    }
} 