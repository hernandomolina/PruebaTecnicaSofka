package com.pruebatecnicaqa.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {

    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();

        // Modo incognito
        options.addArguments("--incognito");

        // Compatibilidad con CI/CD y GitHub Actions
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--remote-allow-origins=*");

        // Headless si se define por env (como en GitHub Actions)
        if ("true".equalsIgnoreCase(System.getenv("CHROME_HEADLESS"))) {
            options.addArguments("--headless=new"); // nuevo modo headless desde Chrome 109+
        }

        // Seguridad y estabilidad extra
        options.addArguments("--disable-features=AutofillKeyBoardAccessoryView,AutofillTouchToFill,PasswordManager");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--password-store=basic");
        options.addArguments("--disable-password-manager-reauthentication");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Desactivar gestor de contraseñas
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // Setup y creación del driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
