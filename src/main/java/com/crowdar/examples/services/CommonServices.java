package com.crowdar.examples.services;

import com.crowdar.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

public class CommonServices {

    /**
     * Realiza un Scroll nativo hasta encontrar el elemento y lo devuelve.
     * Soporta constantes con formato "id:..." y "text:..."
     *
     * @param locatorString La constante del locator (ej: "id:com.paquete:id/boton")
     * @return El WebElement encontrado (para hacerle click o getText)
     */
    public static WebElement scrollTo(String locatorString) {
        AppiumDriver driver = (AppiumDriver) DriverManager.getDriverInstance().getWrappedDriver();
        String uiAutomatorCommand = "";

        // 1. Separamos el prefijo (tipo) del valor
        // Buscamos dónde está los dos puntos ":"
        int separatorIndex = locatorString.indexOf(":");

        // Si no tiene prefijo, asumimos que es texto por defecto (o lanzamos error)
        String type = (separatorIndex != -1) ? locatorString.substring(0, separatorIndex).toLowerCase() : "text";
        String value = (separatorIndex != -1) ? locatorString.substring(separatorIndex + 1) : locatorString;

        // 2. Construimos el comando según el tipo
        switch (type) {
            case "id":
            case "ID":
                uiAutomatorCommand = "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"" + value + "\"))";
                break;

            case "text":
            case "TEXT": // Coincidencia EXACTA
                uiAutomatorCommand = "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + value + "\"))";
                //Ejemplo: CommonServices.scrollTo("text:" + "Texto de Ejemplo");
                //Ejemplo: CommonServices.scrollTo("text:" + nombreVariable);
                break;

            case "description": // Para content-desc
            case "DESCRIPTION":
                uiAutomatorCommand = "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().description(\"" + value + "\"))";
                break;

            default:
                throw new IllegalArgumentException("El método scrollTo solo soporta 'id:', 'text:' o 'description:'. XPath no es soportado por UiScrollable.");
        }

        // 3. Ejecutamos y devolvemos el elemento
        return driver.findElement(MobileBy.AndroidUIAutomator(uiAutomatorCommand));
    }
}