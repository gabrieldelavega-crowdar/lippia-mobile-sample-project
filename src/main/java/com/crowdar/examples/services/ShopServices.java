package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.ShopConstants;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ShopServices {

    private String prevItems = "0";
    private String finalItems = "0";

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

        CommonServices.scrollTo("text:" + producto);
        MobileActionManager.waitVisibility(ShopConstants.TITTLE_PRODUCT_CART, producto);
        String ActualProductTittle = MobileActionManager.getText(ShopConstants.TITTLE_PRODUCT_CART, producto);
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

    public static void selectPlaceOrderButton() {
        MobileActionManager.waitVisibility(ShopConstants.BUTTON_PLACE_ORDER).click();
    }

    public static void verifyCheckoutComplete() {
        MobileActionManager.waitVisibility(ShopConstants.TITTLE_CHECKOUT_COMPLETE);
        String ActualTittle = MobileActionManager.getText(ShopConstants.TITTLE_CHECKOUT_COMPLETE);
        Assert.assertEquals(ActualTittle, "Checkout Complete");
    }

    public static void selectAddProductButton() {
        CommonServices.scrollTo(ShopConstants.BUTTON_ADD_PRODUCT);
        MobileActionManager.click(ShopConstants.BUTTON_ADD_PRODUCT);
    }

    public static void selectCatalogButton() {
        MobileActionManager.click(ShopConstants.BUTTON_CATALOG);

    }

    public static void selectOptionButton() {
        MobileActionManager.waitVisibility(ShopConstants.BUTTON_OPTIONS).click();

    }

    public static void verifyTotalItems() {
        String productQuantity = MobileActionManager.getText(ShopConstants.QUANTITY_BY_PRODUCTS_IN_CART);

        String rawTotalText = MobileActionManager.getText(ShopConstants.QUANTITY_IN_CART);
        String totalProductsQuantity = rawTotalText.replaceAll("\\D+", "");

        Assert.assertEquals(productQuantity, totalProductsQuantity);
    }


    public static void verifyAddressCompleted() {
        SoftAssert softAssert = new SoftAssert();

        String actualName = MobileActionManager.getText(ShopConstants.TEXTBOX_CHECKOUT_NAME);
        softAssert.assertEquals(actualName, "JUAN EJEMPLO", "El campo Nombre no coincide.");

        String actualAddress = MobileActionManager.getText(ShopConstants.TEXTBOX_CHECKOUT_ADDRESS);
        softAssert.assertEquals(actualAddress, "Avenida Siempreviva 742", "El campo Dirección no coincide.");

        String actualCity = MobileActionManager.getText(ShopConstants.TEXTBOX_CHECKOUT_CITY);
        softAssert.assertEquals(actualCity, "MENDOZA", "El campo Ciudad no coincide.");

        String actualZip = MobileActionManager.getText(ShopConstants.TEXTBOX_CHECKOUT_ZIP_CODE);
        softAssert.assertEquals(actualZip, "5500", "El campo Código Postal no coincide.");

        String actualCountry = MobileActionManager.getText(ShopConstants.TEXTBOX_CHECKOUT_COUNTRY);
        softAssert.assertEquals(actualCountry, "ARGENTINA", "El campo País no coincide.");

        softAssert.assertAll();
    }

    public static void verifyPaymentCompleted() {
        SoftAssert softAssert = new SoftAssert();

        String actualName = MobileActionManager.getText(ShopConstants.TEXTBOX_CHECKOUT_PAYMENT_NAME);
        softAssert.assertEquals(actualName, "JUAN EJEMPLO", "El Nombre del titular no coincide.");

        String actualCard = MobileActionManager.getText(ShopConstants.TEXTBOX_CHECKOUT_PAYMENT_CARD_NUMBER);
        softAssert.assertEquals(actualCard, "1234123412341234", "El Número de tarjeta no coincide.");

        String actualExp = MobileActionManager.getText(ShopConstants.TEXTBOX_CHECKOUT_PAYMENT_EXPIRATION_DATE);
        softAssert.assertEquals(actualExp, "05/29", "La Fecha de expiración no coincide.");

        String actualCvv = MobileActionManager.getText(ShopConstants.TEXTBOX_CHECKOUT_PAYMENT_SECURITY_CODE);
        softAssert.assertEquals(actualCvv, "123", "El CVV no coincide.");

        softAssert.assertAll();
    }

    public static void selectStarsButton(String stars) {
        MobileActionManager.waitVisibility(ShopConstants.BUTTON_STAR_CALIFICATION, stars).click();
    }

    public static void verifyMessageReview(String text) {
        MobileActionManager.waitVisibility(ShopConstants.MESSAGE_REVIEW);
        String actualMessage = MobileActionManager.getText(ShopConstants.MESSAGE_REVIEW);
        Assert.assertEquals(text, actualMessage);
    }
}
