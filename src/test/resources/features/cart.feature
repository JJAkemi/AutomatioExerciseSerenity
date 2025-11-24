@FuncionalidadCarrito
Feature: Carrito de compras

  Como usuario logueado exitosamente en la aplicación
  Quiero validar la interacción y actualización de UI del carrito de compras
  Para asegurarme de que se puede navegar,  actualizar y elminar productos exitosamente

  @ModalConfirmacion
  Scenario: El usuario observa un modal de confirmacion al agregar productos al carrito de compras
    Given que el usuario ha iniciado sesión exitosamente en automationexercise.com
    When hace click en el boton Add to cart de un producto
    Then se muestra el mensaje de confirmación
      | Your product has been added to cart. |

  @DetallseProductoEnCarrito
  Scenario: El usuario agrega productos al carrito de compras y comprueba los datos
    Given que el usuario ha iniciado sesión exitosamente en automationexercise.com
    When hace click en el boton Add to cart de un producto
    And hace click en el botón View Cart en el mensaje de confirmacion
    Then se muestra Nombre del producto, Precio y Cantidad
      | Blue Top | Rs. 500 | 1 |

  @ActualizarCantidad
  Scenario: Actualizar la cantidad de un producto en el carrito de compras
    Given que el usuario ha iniciado sesión exitosamente en automationexercise.com
    And el usuario agrega el producto 'Blue Top' al carrito
    When navega al carrito
    And visualiza los detalles de la compra realizada
    And navega nuevamente a la página de inicio
    And agrega otra vez el producto 'Blue Top' al carrito
    And navega al carrito
    Then debería visualizar que la cantidad aumentó en una unidad

  @EliminarProductoEnCarrito
  Scenario: Producto elminado desaparece del carrito de compras
    Given que el usuario ha iniciado sesión exitosamente en automationexercise.com
    When agrega mas de un producto al carrito
    And elimina uno de los productos del carrito
    Then se elimina la fila seleccionada

  @CarritoVacio
  Scenario: Se visualiza mensaje indicando que el carrito esta vacio despues de eliminar items
    Given que el usuario ha iniciado sesión exitosamente en automationexercise.com
    When hace click en el boton Add to cart de un producto
    And hace click en el botón View Cart en el mensaje de confirmacion
    And hace click en el boton Eliminar productos
    Then el carrito muestra el mensaje que está vacío
      | Cart is empty! |

