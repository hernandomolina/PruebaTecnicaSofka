package com.pruebatecnicaqa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
 
public class CheckoutCompletePage {
    public static final Target COMPLETE_HEADER = Target.the("mensaje de confirmación de compra").located(By.cssSelector(".complete-header"));
} 