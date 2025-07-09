package com.pruebatecnicaqa.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {
    
    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        
        // Configuraciones para evitar ventanas emergentes y mejorar la estabilidad
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-infobars");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-password-manager-reauthentication");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordManager,AutofillKeyBoardAccessoryView,AutofillTouchToFill");
        options.addArguments("--password-store=basic");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--incognito");
        options.addArguments("--user-data-dir=/tmp/chrome-test-profile");
        
        // Configuraciones específicas para evitar diálogos de seguridad
        options.addArguments("--safebrowsing-disable-download-protection");
        options.addArguments("--safebrowsing-disable-extension-blacklist");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        
        // Desactivar el gestor de contraseñas de Chrome
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        
        WebDriver driver = WebDriverManager.chromedriver().capabilities(options).create();
        driver.manage().window().maximize();
        
        return driver;
    }
} 