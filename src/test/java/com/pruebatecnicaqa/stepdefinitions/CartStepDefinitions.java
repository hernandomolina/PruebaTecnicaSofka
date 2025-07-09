package com.pruebatecnicaqa.stepdefinitions;

import com.pruebatecnicaqa.questions.CartBadgeCount;
import com.pruebatecnicaqa.questions.CartProductName;
import com.pruebatecnicaqa.questions.CartProductPrice;
import com.pruebatecnicaqa.questions.CartTotalProducts;
import com.pruebatecnicaqa.tasks.AddToCartTask;
import com.pruebatecnicaqa.utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

public class CartStepDefinitions {
    private Actor actor;

    public CartStepDefinitions() {
        this.actor = TestContext.getInstance().getActor();
    }

    @And("agrega el producto {string} al carrito")
    public void addProductToCart(String productName) {
        actor.attemptsTo(
            AddToCartTask.withName(productName)
        );
    }

    @And("agrega los siguientes productos al carrito:")
    public void addMultipleProductsToCart(List<String> products) {
        for (String product : products) {
            actor.attemptsTo(
                AddToCartTask.withName(product)
            );
        }
    }

    @And("el contador del carrito debería mostrar {string}")
    public void cartCounterShouldShow(String count) {
        actor.attemptsTo(
            Ensure.that(CartBadgeCount.value()).isEqualTo(count)
        );
    }

    @Then("debería ver el producto {string} en el carrito")
    public void shouldSeeProductInCart(String productName) {
        actor.attemptsTo(
            Ensure.that(CartProductName.value()).isEqualTo(productName)
        );
    }

    @And("debería ver el precio correspondiente del producto")
    public void shouldSeeProductPrice() {
        actor.attemptsTo(
            Ensure.that(CartProductPrice.value()).isNotEmpty()
        );
    }

    @And("debería ver el total de productos en el carrito")
    public void shouldSeeTotalProductsInCart() {
        actor.attemptsTo(
            Ensure.that(CartTotalProducts.value()).isNotEmpty()
        );
    }
} 