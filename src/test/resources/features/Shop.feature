@Shop @Regression
Feature: Shop
  @RestarAlCarrito @Consiga1
  Scenario Outline: Agregar más de un producto distinto al carrito desde la búsqueda
    Given el usuario se encuentra en la pantalla de catalogo
    When el usuario selecciona el producto <producto1>
    And el usuario se encuentra en la pantalla del producto <producto1>
    And el usuario selecciona el boton Add to Cart
    And el usuario selecicona el boton Opciones
    And el usuario selecicona el boton Catalogo
    And el usuario selecciona el producto <producto2>
    And el usuario se encuentra en la pantalla del producto <producto2>
    And el usuario selecciona el boton Add to Cart
    And  el usuario selecciona el icono del carrito
    Then el usuario verifica que su producto <producto1> se encuentre en el carrito
    And el usuario verifica que su producto <producto2> se encuentre en el carrito


    Examples:
      | producto1           | producto2                    |
      | Sauce Labs Backpack | Sauce Labs Backpack (orange) |

  @IncrementarProducto @Consigna2
  Scenario Outline: Incrementar la cantidad de ítems de un producto que ya existe en el carrito
    Given el usuario se encuentra en la pantalla de catalogo
    When el usuario selecciona el producto <producto>
    And el usuario se encuentra en la pantalla del producto <producto>
    And el usuario selecciona el boton Add to Cart
    And  el usuario selecciona el icono del carrito
    And el usuario verifica que su producto <producto> se encuentre en el carrito
    And el usuario selecciona el boton +
    Then el usuario verifica que el nuevo total de items sea correcto

    Examples:
      | producto            |  |
      | Sauce Labs Backpack |  |


  @AgregarDirecciónEnvío @Consigna3
  Scenario Outline: Agregar una nueva dirección de envío
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
    Then el usuario verifica que la dirección del envío este completada


    Examples:
      | producto            |
      | Sauce Labs Backpack |

  @AgregarMetodoPago @Consigna4
  Scenario Outline: Agregar un método de pago
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
    Then el usuario verifica que el metodo de pago este completado



    Examples:
      | producto            |
      | Sauce Labs Backpack |

  @ComprarYCalificar @Smoke @Consigna5 @testGabo
  Scenario Outline: Compra Completa y Calificacion
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
    And el usuario selecciona el boton Place Order
    And el usuario verifica el mensaje final de la compra
    And el usuario selecicona el boton Opciones
    And el usuario selecicona el boton Catalogo
    And el usuario selecciona el producto <producto>
    And el usuario califica el producto con 5 estrellas
    Then el usuario verifica el mensaje Thank you for submitting your review! por calificar

    Examples:
      | producto            |
      | Sauce Labs Backpack |