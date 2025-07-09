package com.pruebatecnicaqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import static com.pruebatecnicaqa.userinterfaces.CheckoutPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillCheckoutFormTask implements Task {
    private final String nombre;
    private final String apellido;
    private final String codigoPostal;

    public FillCheckoutFormTask(String nombre, String apellido, String codigoPostal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoPostal = codigoPostal;
    }

    public static FillCheckoutFormTask withData(String nombre, String apellido, String codigoPostal) {
        return instrumented(FillCheckoutFormTask.class, nombre, apellido, codigoPostal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(FIRST_NAME_FIELD, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
            Enter.theValue(nombre).into(FIRST_NAME_FIELD),
            Enter.theValue(apellido).into(LAST_NAME_FIELD),
            Enter.theValue(codigoPostal).into(POSTAL_CODE_FIELD)
        );
    }
} 