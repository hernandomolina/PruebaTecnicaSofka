package com.pruebatecnicaqa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage {
    public static final Target INVENTORY_CONTAINER = Target.the("contenedor de productos")
            .located(By.id("inventory_container"));
            
    public static final Target PRODUCT_TITLE = Target.the("título del producto")
            .locatedBy("//div[contains(@class, 'inventory_item_name') and text()='{0}']");
    
    public static final Target ADD_TO_CART_BUTTON = Target.the("botón agregar al carrito para {0}")
            .locatedBy("//div[contains(@class, 'inventory_item_name') and text()='{0}']/ancestor::div[@class='inventory_item']//button[contains(@id, 'add-to-cart')]");
    
    public static final Target SHOPPING_CART_BADGE = Target.the("contador del carrito")
            .located(By.cssSelector(".shopping_cart_badge"));
    
    public static final Target SHOPPING_CART_LINK = Target.the("enlace del carrito")
            .located(By.cssSelector(".shopping_cart_link"));
            
    public static final Target CLOSE_POPUP_BUTTON = Target.the("botón cerrar ventana emergente")
            .located(By.id("close_popup_window"));
} 