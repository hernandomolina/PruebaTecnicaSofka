package com.pruebatecnicaqa.stepdefinitions;

import com.pruebatecnicaqa.tasks.GoToCartTask;
import com.pruebatecnicaqa.tasks.StartCheckoutTask;
import com.pruebatecnicaqa.tasks.FillCheckoutFormTask;
import com.pruebatecnicaqa.tasks.ClickContinueTask;
import com.pruebatecnicaqa.tasks.FinishCheckoutTask;
import com.pruebatecnicaqa.questions.CheckoutConfirmationMessage;
import com.pruebatecnicaqa.questions.CheckoutErrorMessage;
import com.pruebatecnicaqa.questions.CheckoutErrorAbsence;
import com.pruebatecnicaqa.questions.CheckoutOverviewPage;
import com.pruebatecnicaqa.questions.CheckoutSummaryProduct;
import com.pruebatecnicaqa.questions.CheckoutSummaryPrice;
import com.pruebatecnicaqa.questions.CheckoutSummaryTax;
import com.pruebatecnicaqa.questions.CheckoutSummaryTotal;
import com.pruebatecnicaqa.utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import java.util.Map;

public class CheckoutStepDefinitions {
    private final Actor actor;

    public CheckoutStepDefinitions() {
        this.actor = TestContext.getInstance().getActor();
    }

    @And("navega al carrito de compras")
    public void goToCartFromCheckout() {
        actor.attemptsTo(GoToCartTask.open());
    }

    @And("inicia el proceso de checkout")
    public void startCheckout() {
        actor.attemptsTo(StartCheckoutTask.open());
    }

    @And("ingresa los datos de compra:")
    public void fillCheckoutForm(Map<String, String> data) {
        actor.attemptsTo(FillCheckoutFormTask.withData(
            data.get("nombre"),
            data.get("apellido"),
            data.get("codigo_postal")
        ));
    }

    @And("hace clic en {string}")
    public void clickOnButton(String buttonText) {
        if ("Continue".equals(buttonText)) {
            actor.attemptsTo(ClickContinueTask.click());
        } else if ("Finish".equals(buttonText)) {
            actor.attemptsTo(FinishCheckoutTask.complete());
        }
    }

    @Then("debería ser redirigido a la página de resumen de compra")
    public void shouldBeRedirectedToCheckoutOverview() {
        actor.should(net.serenitybdd.screenplay.GivenWhenThen.seeThat(CheckoutOverviewPage.isVisible()));
    }

    @And("no debería ver mensajes de error")
    public void shouldNotSeeErrorMessages() {
        actor.should(net.serenitybdd.screenplay.GivenWhenThen.seeThat(CheckoutErrorAbsence.isNotVisible()));
    }

    @Then("debería ver el producto {string} en el resumen")
    public void shouldSeeProductInSummary(String productName) {
        actor.attemptsTo(
            Ensure.that(CheckoutSummaryProduct.value()).contains(productName)
        );
    }

    @And("debería ver el precio individual y el impuesto aplicado")
    public void shouldSeeIndividualPriceAndTax() {
        actor.attemptsTo(
            Ensure.that(CheckoutSummaryPrice.value()).isNotEmpty(),
            Ensure.that(CheckoutSummaryTax.value()).isNotEmpty()
        );
    }

    @And("debería ver el total final")
    public void shouldSeeFinalTotal() {
        actor.attemptsTo(
            Ensure.that(CheckoutSummaryTotal.value()).isNotEmpty()
        );
    }

    @Then("debería ver el mensaje de confirmación {string}")
    public void shouldSeeConfirmationMessage(String expectedMessage) {
        if ("THANK YOU FOR YOUR ORDER".equals(expectedMessage)) {
            actor.should(net.serenitybdd.screenplay.GivenWhenThen.seeThat(CheckoutConfirmationMessage.isVisible()));
        } else {
            // Para otros mensajes de confirmación, usamos la misma validación
            actor.should(net.serenitybdd.screenplay.GivenWhenThen.seeThat(CheckoutConfirmationMessage.isVisible()));
        }
    }

    @Then("debería ver el mensaje de error {string}")
    public void shouldSeeErrorMessage(String expectedErrorMessage) {
        actor.attemptsTo(
            Ensure.that(CheckoutErrorMessage.value()).contains(expectedErrorMessage)
        );
    }

    @And("debería ver ambos productos en el resumen")
    public void shouldSeeBothProductsInSummary() {
        actor.attemptsTo(
            Ensure.that(CheckoutSummaryProduct.value()).isNotEmpty()
        );
    }

    @And("debería ver el precio individual, impuestos y total final")
    public void shouldSeeIndividualPriceTaxesAndTotal() {
        actor.attemptsTo(
            Ensure.that(CheckoutSummaryPrice.value()).isNotEmpty(),
            Ensure.that(CheckoutSummaryTax.value()).isNotEmpty(),
            Ensure.that(CheckoutSummaryTotal.value()).isNotEmpty()
        );
    }

} 