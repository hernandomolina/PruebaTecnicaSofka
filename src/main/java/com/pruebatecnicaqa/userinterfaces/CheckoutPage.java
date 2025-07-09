package com.pruebatecnicaqa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

// pagina de checkout donde se ingresan los datos del cliente
public class CheckoutPage {
    
    public static final Target FIRST_NAME_FIELD = Target.the("campo nombre")
            .located(By.id("first-name"));
    
    public static final Target LAST_NAME_FIELD = Target.the("campo apellido")
        .located(By.id("last-name"));
        
    public static final Target POSTAL_CODE_FIELD = Target.the("campo codigo postal").located(By.id("postal-code")); //codigo postal
    
    public static final Target CONTINUE_BUTTON = Target.the("boton continuar").located(By.id("continue")); // btn siguiente
    
    public static final Target ERROR_MESSAGE = Target.the("mensaje de error")
            .located(By.cssSelector(".error-message-container"));
} 