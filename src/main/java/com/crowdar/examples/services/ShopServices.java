package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.ShopConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ShopServices {
    public static void verifyCatalogPage() {
        MobileActionManager.waitVisibility(ShopConstants.TITTLE_PAGE);
        String ActualTittle = MobileActionManager.getText(ShopConstants.TITTLE_PAGE);
        Assert.assertEquals(ActualTittle, "Products");
    }

    public static void selectProduct(String producto) {
        CommonServices.scrollTo("text:" + producto);
        MobileActionManager.click(ShopConstants.SELECTED_PRODUCT, producto);
    }

    public static void verifyProductPage(String producto) {
        MobileActionManager.waitVisibility(ShopConstants.TITTLE_PAGE);
        String ActualTittle = MobileActionManager.getText(ShopConstants.TITTLE_PAGE);
        Assert.assertEquals(ActualTittle, producto);
    }

    public static void selectAddToCartButton() {
        CommonServices.scrollTo(ShopConstants.BUTTON_ADD_TO_CART);
        MobileActionManager.click(ShopConstants.BUTTON_ADD_TO_CART);
    }

    public static void selectCartButton() {
        MobileActionManager.waitVisibility((ShopConstants.BUTTON_CART)).click();

    }

    public static void verifyProductCart(String producto) {
        MobileActionManager.waitVisibility(ShopConstants.TITTLE_PAGE);
        String ActualTittle = MobileActionManager.getText(ShopConstants.TITTLE_PAGE);
        Assert.assertEquals(ActualTittle, "My Cart");

        MobileActionManager.waitVisibility(ShopConstants.TITTLE_PRODUCT_CART);
        String ActualProductTittle = MobileActionManager.getText(ShopConstants.TITTLE_PRODUCT_CART);
        Assert.assertEquals(ActualProductTittle, producto);
    }

    public static void selectRemoveItemButton() {
        MobileActionManager.waitVisibility((ShopConstants.BUTTON_REMOVE_ITEM)).click();

    }

    public static void verifyNoProductsInCart() {
        MobileActionManager.waitVisibility(ShopConstants.TITTLE_NO_PRODUCT_CART);
        String ActualTittle = MobileActionManager.getText(ShopConstants.TITTLE_NO_PRODUCT_CART);
        Assert.assertEquals(ActualTittle, "No Items");
    }

    public static void selectCheckoutButton() {
        MobileActionManager.waitVisibility((ShopConstants.BUTTON_PROCEED_TO_CHECKOUT)).click();
    }

    public static void selectLoginUser() {
        MobileActionManager.waitVisibility((ShopConstants.BUTTON_SELECT_USER_LOGIN)).click();

    }

    public static void selectLoginButton() {
        MobileActionManager.waitVisibility((ShopConstants.BUTTON_LOGIN)).click();

    }

    public static void fillCheckoutData() {
        MobileActionManager.waitVisibility((ShopConstants.TEXTBOX_CHECKOUT_NAME));
        MobileActionManager.setInput(ShopConstants.TEXTBOX_CHECKOUT_NAME, "JUAN EJEMPLO");

        MobileActionManager.waitVisibility((ShopConstants.TEXTBOX_CHECKOUT_ADDRESS));
        MobileActionManager.setInput(ShopConstants.TEXTBOX_CHECKOUT_ADDRESS, "Avenida Siempreviva 742");

        MobileActionManager.waitVisibility((ShopConstants.TEXTBOX_CHECKOUT_CITY));
        MobileActionManager.setInput(ShopConstants.TEXTBOX_CHECKOUT_CITY, "MENDOZA");

        MobileActionManager.waitVisibility((ShopConstants.TEXTBOX_CHECKOUT_ZIP_CODE));
        MobileActionManager.setInput(ShopConstants.TEXTBOX_CHECKOUT_ZIP_CODE, "5500");

        MobileActionManager.waitVisibility((ShopConstants.TEXTBOX_CHECKOUT_COUNTRY));
        MobileActionManager.setInput(ShopConstants.TEXTBOX_CHECKOUT_COUNTRY, "ARGENTINA");
    }

    public static void selectToPaymentButton() {
        CommonServices.scrollTo(ShopConstants.BUTTON_TO_PAYMENT);
        MobileActionManager.click(ShopConstants.BUTTON_TO_PAYMENT);
    }

    public static void fillCheckoutPayment() {

        MobileActionManager.waitVisibility((ShopConstants.TEXTBOX_CHECKOUT_PAYMENT_NAME));
        MobileActionManager.setInput(ShopConstants.TEXTBOX_CHECKOUT_PAYMENT_NAME, "JUAN EJEMPLO");

        MobileActionManager.waitVisibility((ShopConstants.TEXTBOX_CHECKOUT_PAYMENT_CARD_NUMBER));
        MobileActionManager.setInput(ShopConstants.TEXTBOX_CHECKOUT_PAYMENT_CARD_NUMBER, "1234123412341234");

        MobileActionManager.waitVisibility((ShopConstants.TEXTBOX_CHECKOUT_PAYMENT_EXPIRATION_DATE));
        MobileActionManager.setInput(ShopConstants.TEXTBOX_CHECKOUT_PAYMENT_EXPIRATION_DATE, "0529");

        MobileActionManager.waitVisibility((ShopConstants.TEXTBOX_CHECKOUT_PAYMENT_SECURITY_CODE));
        MobileActionManager.setInput(ShopConstants.TEXTBOX_CHECKOUT_PAYMENT_SECURITY_CODE, "123");
    }

    public static void selectReviewOrderButton() {
        MobileActionManager.waitVisibility(ShopConstants.BUTTON_REVIEW_ORDER).click();
    }

    public static void verifyProductOrder(String producto) {
        MobileActionManager.waitVisibility(ShopConstants.TITTLE_FINAL_PAGE);
        String ActualTittle = MobileActionManager.getText(ShopConstants.TITTLE_FINAL_PAGE);
        Assert.assertEquals(ActualTittle, "Checkout");

        MobileActionManager.waitVisibility(ShopConstants.TITTLE_PRODUCT_CART);
        String ActualProductTittle = MobileActionManager.getText(ShopConstants.TITTLE_PRODUCT_CART);
        Assert.assertEquals(ActualProductTittle, producto);

        CommonServices.scrollTo("text:" + "Estimated to arrive within 3 weeks.");

        String ActualName = MobileActionManager.getText(ShopConstants.FINAL_ORDER_NAME);
        String ActualAddress = MobileActionManager.getText(ShopConstants.FINAL_ORDER_ADDRESS);
        String ActualCardNumber = MobileActionManager.getText(ShopConstants.FINAL_ORDER_CARD_NUMBER);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(ActualName,"JUAN EJEMPLO");
        softAssert.assertEquals(ActualAddress,"Avenida Siempreviva 742");
        softAssert.assertEquals(ActualCardNumber,"1234123412341234");
        softAssert.assertAll();


    }

    public static void selectPlaceOrderButton() {
        MobileActionManager.waitVisibility(ShopConstants.BUTTON_PLACE_ORDER).click();
    }

    public static void verifyCheckoutComplete() {
        MobileActionManager.waitVisibility(ShopConstants.TITTLE_CHECKOUT_COMPLETE);
        String ActualTittle = MobileActionManager.getText(ShopConstants.TITTLE_CHECKOUT_COMPLETE);
        Assert.assertEquals(ActualTittle, "Checkout Complete");
    }
}
