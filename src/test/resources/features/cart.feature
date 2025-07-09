# language: en
Feature: Carrito de compras en Sauce Demo

  Como usuario de Sauce Demo
  Quiero poder agregar productos al carrito y validar su contenido
  Para asegurar que el carrito funciona correctamente

  @cart @validar_carrito_completo
  Scenario: Agregar producto y validar carrito
    Given que el usuario está en la página de login de Sauce Demo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    Then el contador del carrito debería mostrar "1"
    When navega al carrito de compras
    Then debería ver el producto "Sauce Labs Backpack" en el carrito
    And debería ver el precio correspondiente del producto
    And debería ver el total de productos en el carrito 