@Shop @Regression
Feature: Shop

  @BusquedaExitosa
  Scenario Outline: Buscar un producto
    Given el usuario se encuentra en la pantalla de catalogo
    When el usuario selecciona el producto <producto>
    Then el usuario se encuentra en la pantalla del producto <producto>

    Examples:
      | producto            |
      | Sauce Labs Backpack |

  @SumarYRestarAlCarrito
  Scenario Outline: Agregar un producto al carrito y luego eliminarlo
    Given el usuario se encuentra en la pantalla de catalogo
    When el usuario selecciona el producto <producto>
    And el usuario se encuentra en la pantalla del producto <producto>
    And el usuario selecciona el boton Add to Cart
    And  el usuario selecciona el icono del carrito
    And el usuario verifica que su producto <producto> se encuentre en el carrito
    And el usuario selecciona el boton Remove Item
    And el usuario verifica que no hay items en el carrito

    Examples:
      | producto            |
      | Sauce Labs Backpack |

  @CompraCompleta @Smoke @testGabo
  Scenario Outline: Realizar una compra completa
    Given el usuario se encuentra en la pantalla de catalogo
    When el usuario selecciona el producto <producto>
    And el usuario se encuentra en la pantalla del producto <producto>
    And el usuario selecciona el boton Add to Cart
    And  el usuario selecciona el icono del carrito
    And el usuario verifica que su producto <producto> se encuentre en el carrito
    And el usuario selecciona el boton Proceed To Checkout
    And el usuario selecciona el usuario para rellenar Login
    And el usuario selecciona el boton Login
    And el usuario llena el formulario del envio
    And el usuario selecciona el boton To Payment
    And el usuario llena el formulario del pago
    And el usuario selecciona el boton Review Order
    And el usuario verifica que su producto <producto> y los datos de compra sean correctos
    Then el usuario selecciona el boton Place Order
    And el usuario verifica el mensaje final de la compra

    Examples:
      | producto            |
      | Sauce Labs Backpack |

