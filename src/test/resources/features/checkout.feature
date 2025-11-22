@FuncionalidadCheckout
Feature: Checkout de la compra

  Como usuario logueado exitosamente en la aplicación
  Quiero validar el proceso de checkout
  Para asegurarme que no se puede realizar la compra exitosamente

  @DireccionCompra
  Scenario: Se realiza el proceso de checkout del producto agregado
    Given que el usuario a iniciado sesión exitosamente en automationexercise.com
    When hace click en el boton Add to cart de un producto
    And hace click en el botón View Cart en el mensaje de confirmacion
    And hace click en el botón Prooceed to checkout
    Then debe visualizar que la direccion se encuentre registrada

  @PlaceOrder
  Scenario: Se realiza el proceso de compra exitoso
    Given que el usuario a iniciado sesión exitosamente en automationexercise.com
    When hace click en el boton Add to cart de un producto
    And hace click en el botón View Cart en el mensaje de confirmacion
    And hace click en el botón Prooceed to checkout
    And ingresa un comentario en la orden
    And hace click en el botón Place Order
    And llena el formulario de datos de la tarjeta de credito
    And hace click en el botón Pay and Confirm Order
    Then se muestra el mensaje de compra exitosa
      | Congratulations! Your order has been confirmed! |
