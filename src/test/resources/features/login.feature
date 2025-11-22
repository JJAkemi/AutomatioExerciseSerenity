@FuncionalidadAutenticacion
Feature: Login en AutomationExercise

  Como usuario de la aplicación
  Quiero validar el proceso de login en AutomationExercise
  Para asegurarme de que el sistema autentique correctamente según escenarios de  autenticación positivos y negativos

  @LoginExitoso
  Scenario: El usuario  inicia sesión con credenciales validas
    Given que el usuario abre la página automationexercise.com
    When hace click en la opción Signup Login
    And en el formulario de Inicio de Sesion  introduce las credenciales validas
    Then se muestra un mensaje de saludo: Logged in as

  @CamposVacios
  Scenario: El usuario intenta iniciar sesión sin ingresar credenciales
    Given que el usuario abre la página automationexercise.com
    When hace click en la opción Signup Login
    And en el formulario de Inicio de Sesion hace click en el boton Login sin introducir credenciales
    Then los campos Email y Password deben ser marcados como obligatorios
    And no debe cambiar de URL

  @PasswordIncorrecto
  Scenario: El usuario intenta iniciar sesión introduciendo un password incorrecto
    Given que el usuario abre la página automationexercise.com
    When hace click en la opción Signup Login
    And trata de iniciar sesión ingresando un password incorrecto
    Then se muestra el mensaje de error
      |Your email or password is incorrect!|

  @UsuarioInexistente
  Scenario: El usuario intenta iniciar sesión con un usuario inexistente
    Given que el usuario abre la página automationexercise.com
    When hace click en la opción Signup Login
    And trata de iniciar sesión credenciales de un usuario inexistente
    Then se muestra el mensaje de error
      |Your email or password is incorrect!|



