Feature: Начальный тест для изучения Cucumber

  Scenario: Простой тест без тела

  Scenario:  Простой тест с Given
    Given open browser


  Scenario: Простой тест с given и when
    Given open browser
    When login page is opened

  Scenario: Простой тест со всеми ключевыми сценариями
    Given open browser
    When login page is opened
    Then username field is displayed

  Scenario: использывание AND в Given
    Given open browser
    And login page is opened

  Scenario: использывание AND в Given
    Given open browser
    * login page is opened
    Then username field is displayed
