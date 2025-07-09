# language: en
Feature: Proceso de compra (Checkout) en Sauce Demo

  Como usuario de Sauce Demo
  Quiero poder completar el proceso de compra
  Para finalizar mi pedido exitosamente

  @checkout @formulario_valido
  Scenario: Validar formulario de checkout con datos válidos y avanzar al resumen
    Given que el usuario está en la página de login de Sauce Demo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    And navega al carrito de compras
    And inicia el proceso de checkout
    And ingresa los datos de compra:
      | nombre         | Juan   |
      | apellido      | Pérez  |
      | codigo_postal | 110111 |
    And hace clic en "Continue"
    Then debería ser redirigido a la página de resumen de compra
    And no debería ver mensajes de error 

  @checkout @formulario_incompleto
  Scenario Outline: Validar que no se permite avanzar si el formulario está incompleto
    Given que el usuario está en la página de login de Sauce Demo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    And navega al carrito de compras
    And inicia el proceso de checkout
    And ingresa los datos de compra:
      | nombre         | <nombre>   |
      | apellido      | <apellido>  |
      | codigo_postal | <codigo_postal> |
    And hace clic en "Continue"
    Then debería ver el mensaje de error "<mensaje_error>"

    Examples:
      | nombre | apellido | codigo_postal | mensaje_error                        |
      |        | Pérez    | 110111        | Error: First Name is required        |
      | Juan   |          | 110111        | Error: Last Name is required         |
      | Juan   | Pérez    |               | Error: Postal Code is required       |

  @checkout @resumen
  Scenario: Validar pantalla de resumen y finalizar compra exitosamente
    Given que el usuario está en la página de login de Sauce Demo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    And navega al carrito de compras
    And inicia el proceso de checkout
    And ingresa los datos de compra:
      | nombre         | Juan   |
      | apellido      | Pérez  |
      | codigo_postal | 110111 |
    And hace clic en "Continue"
    Then debería ver el producto "Sauce Labs Backpack" en el resumen
    And debería ver el precio individual y el impuesto aplicado
    And debería ver el total final
    When hace clic en "Finish"
    Then debería ver el mensaje de confirmación "THANK YOU FOR YOUR ORDER"

 