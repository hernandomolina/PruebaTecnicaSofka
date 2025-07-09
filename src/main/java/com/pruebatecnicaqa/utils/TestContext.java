package com.pruebatecnicaqa.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private static final ThreadLocal<TestContext> testContext = new ThreadLocal<>();
    private Actor actor;
    private WebDriver driver;

    private TestContext() {
        // Constructor privado
    }

    public static TestContext getInstance() {
        if (testContext.get() == null) {
            testContext.set(new TestContext());
        }
        return testContext.get();
    }

    public Actor getActor() {
        if (actor == null) {
            initializeActor();
        }
        return actor;
    }

    private void initializeActor() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("Usuario_" + Thread.currentThread().getId());
        driver = WebDriverFactory.createDriver();
        actor.can(BrowseTheWeb.with(driver));
    }

    public void reset() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                // Ignorar errores al cerrar el driver
            }
        }
        actor = null;
        driver = null;
    }

    public static void tearDown() {
        TestContext context = testContext.get();
        if (context != null) {
            context.reset();
            testContext.remove();
        }
        try {
            OnStage.drawTheCurtain();
        } catch (Exception e) {
            // Ignorar errores al limpiar el escenario
        }
    }
} 