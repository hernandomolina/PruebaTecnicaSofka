# language: en
Feature: Pruebas de Regresión - Flujo Completo en Sauce Demo

  Como usuario de Sauce Demo
  Quiero poder completar todo el flujo de compra sin errores
  Para validar que el sistema funciona correctamente de principio a fin

  @regresion @flujo_completo
  Scenario: Validar el flujo completo desde login hasta confirmación de orden
    Given que el usuario está en la página de login de Sauce Demo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    And navega al carrito de compras
    And inicia el proceso de checkout
    And ingresa los datos de compra:
      | nombre         | Laura   |
      | apellido      | Gómez   |
      | codigo_postal | 123456  |
    And hace clic en "Continue"
    Then debería ver el producto "Sauce Labs Backpack" en el resumen
    And debería ver el precio individual, impuestos y total final
    When hace clic en "Finish"
    Then debería ver el mensaje de confirmación "THANK YOU FOR YOUR ORDER" 