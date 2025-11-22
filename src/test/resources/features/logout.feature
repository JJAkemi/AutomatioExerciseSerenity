@FuncionalidadLogout
Feature: Cierre de sesión

  Como usuario logueado exitosamente en la aplicación
  Quiero validar la el cierre de sesión
  Para asegurarme que no se tiene acceso a los recursos de la pagina

  @LogoutRedireccion
  Scenario: Al realizar el cierre de sesión se es redireccionado al la pagina inicial
    Given que el usuario a iniciado sesión exitosamente en automationexercise.com
    When hace click la opción Logout
    Then se es redirigido a la pagina de inicio