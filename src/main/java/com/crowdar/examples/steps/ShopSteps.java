package com.crowdar.examples.steps;

import com.crowdar.examples.services.ShopServices;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopSteps {
    @Given("el usuario se encuentra en la pantalla de catalogo")
    public void elUsuarioSeEncuentraEnLaPantallaDeCatalogo() {
        ShopServices.verifyCatalogPage();
    }

    @When("el usuario selecciona el producto (.*)$")
    public void elUsuarioSeleccionaElProducto(String producto) {
        ShopServices.selectProduct(producto);
    }

    @Then("el usuario se encuentra en la pantalla del producto (.*)$")
    public void elUsuarioSeEncuentraEnLaPantallaDelProducto(String producto) {
        ShopServices.verifyProductPage(producto);
    }

    @And("el usuario selecciona el boton Add to Cart")
    public void elUsuarioSeleccionaElBotonAddToCart() {
        ShopServices.selectAddToCartButton();
    }

    @And("el usuario selecciona el icono del carrito")
    public void elUsuarioSeleccionaElIconoDelCarrito() {
        ShopServices.selectCartButton();
    }

    @And("el usuario verifica que su producto (.*) se encuentre en el carrito$")
    public void elUsuarioVerificaQueSuProductoSeEncuentreSeleccionado(String producto) {
        ShopServices.verifyProductCart(producto);
    }

    @And("el usuario selecciona el boton Remove Item")
    public void elUsuarioSeleccionaElBotonRemoveItem() {
        ShopServices.selectRemoveItemButton();

    }

    @And("el usuario verifica que no hay items en el carrito")
    public void elUsuarioVerificaQueNoHayItemsEnElCarrito() {
        ShopServices.verifyNoProductsInCart();
    }

    @And("el usuario selecciona el boton Proceed To Checkout")
    public void elUsuarioSeleccionaElBotonProceedToCheckout() {
        ShopServices.selectCheckoutButton();

    }

    @And("el usuario selecciona el usuario para rellenar Login")
    public void elUsuarioSeleccionaElUsuarioParaRellenarLogin() {
        ShopServices.selectLoginUser();
    }

    @And("el usuario selecciona el boton Login")
    public void elUsuarioSeleccionaElBotonLogin() {
        ShopServices.selectLoginButton();
    }

    @And("el usuario llena el formulario del envio")
    public void elUsuarioLlenaElFormularioDelEnvio() {
        ShopServices.fillCheckoutData();
    }

    @And("el usuario selecciona el boton To Payment")
    public void elUsuarioSeleccionaElBotonToPayment() {
        ShopServices.selectToPaymentButton();
    }

    @And("el usuario llena el formulario del pago")
    public void elUsuarioLlenaElFormularioDelPago() {
        ShopServices.fillCheckoutPayment();

    }

    @And("el usuario selecciona el boton Review Order")
    public void elUsuarioSeleccionaElBotonReviewOrder() {
        ShopServices.selectReviewOrderButton();
    }

    @And("el usuario verifica que su producto (.*) y los datos de compra sean correctos$")
    public void elUsuarioVerificaQueSuProductoYLosDatosDeCompraSeanCorrectos(String producto) {
        ShopServices.verifyProductOrder(producto);

    }

    @And("el usuario selecciona el boton Place Order")
    public void elUsuarioSeleccionaElBotonPlaceOrder() {
        ShopServices.selectPlaceOrderButton();

    }

    @And("el usuario verifica el mensaje final de la compra")
    public void elUsuarioVerificaElMensajeFinalDeLaCompra() {
        ShopServices.verifyCheckoutComplete();
    }
}
