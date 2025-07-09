package com.pruebatecnicaqa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
 
public class CartPage {
    public static final Target CHECKOUT_BUTTON = Target.the("botón de checkout")
            .located(By.id("checkout"));
    
    public static final Target CART_ITEM_NAME = Target.the("nombre del producto en el carrito")
            .located(By.cssSelector(".inventory_item_name"));
    
    public static final Target CART_ITEM_PRICE = Target.the("precio del producto en el carrito")
            .located(By.cssSelector(".inventory_item_price"));
    
    public static final Target CART_ITEM_QUANTITY = Target.the("cantidad del producto en el carrito")
            .located(By.cssSelector(".cart_quantity"));
    
    public static final Target CART_TOTAL = Target.the("total del carrito")
            .located(By.cssSelector(".cart_total"));
} 