@Shop @Regression
Feature: Shop
 # 1. Agregar más de un producto igual al carrito desde la búsqueda
 # 2. Incrementar la cantidad de ítems de un producto que ya existe en el carrito
  #3. Agregar una nueva dirección de envío
 # 4. Agregar un método de pago
 # 5. Una vez realizada la compra calificar los productos comprados



  #BORRAR TODOS LOS EJEMPLOS PEDORROS QUE NO SIRVEN


  @RestarAlCarrito @Consiga1
  Scenario Outline: Agregar más de un producto distinto al carrito desde la búsqueda
    Given el usuario se encuentra en la pantalla de catalogo
    When el usuario selecciona el producto <producto1>
    And el usuario se encuentra en la pantalla del producto <producto1>
    And el usuario selecciona el boton Add to Cart
    #y VOLVER
    And el usuario selecicona el boton Volver al Catalogo
    And el usuario selecciona el producto <producto2>
    And el usuario se encuentra en la pantalla del producto <producto2>
    And el usuario selecciona el boton Add to Cart
    #y NO VOLVER
    And  el usuario selecciona el icono del carrito
    Then el usuario verifica que su producto <producto1> se encuentre en el carrito
    And el usuario verifica que su producto <producto2> se encuentre en el carrito


    Examples:
      | producto1           | producto2                    |
      | Sauce Labs Backpack | Sauce Labs Backpack (orange) |

  @IncrementarProducto @2
  Scenario Outline: Incrementar la cantidad de ítems de un producto que ya existe en el carrito
    Given el usuario se encuentra en la pantalla de catalogo
    When el usuario selecciona el producto <producto>
    And el usuario se encuentra en la pantalla del producto <producto>
    And el usuario selecciona el boton Add to Cart
    And  el usuario selecciona el icono del carrito
    And el usuario verifica que su producto <producto> se encuentre en el carrito
    And el usuario selecciona el boton +
    #El boton tiene que ser variable, para que valga para + y para -
    Then el usuario verifica que el total de items corresponda al incremento

    Examples:
      | producto            |  |
      | Sauce Labs Backpack |  |


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

