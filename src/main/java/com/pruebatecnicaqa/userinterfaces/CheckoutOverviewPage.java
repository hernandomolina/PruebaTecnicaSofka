package com.pruebatecnicaqa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
 
public class CheckoutOverviewPage {
    public static final Target FINISH_BUTTON = Target.the("botón finalizar compra").located(By.id("finish"));
    
    public static final Target SUMMARY_ITEM_NAME = Target.the("nombre del producto en el resumen")
            .located(By.cssSelector(".inventory_item_name"));
    
    public static final Target SUMMARY_ITEM_PRICE = Target.the("precio del producto en el resumen")
            .located(By.cssSelector(".inventory_item_price"));
    
    public static final Target SUMMARY_SUBTOTAL = Target.the("subtotal en el resumen")
            .located(By.cssSelector(".summary_subtotal_label"));
    
    public static final Target SUMMARY_TAX = Target.the("impuesto en el resumen")
            .located(By.cssSelector(".summary_tax_label"));
    
    public static final Target SUMMARY_TOTAL = Target.the("total en el resumen")
            .located(By.cssSelector(".summary_total_label"));
} 