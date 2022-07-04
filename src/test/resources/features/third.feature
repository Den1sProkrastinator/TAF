Feature: Параметризированный тест

  Scenario: Простая параметризация
    Given open browser
    * login page is opened
    When user with email "atrostyanko@gmail.com" and psw "Americana#1" logged in
    Then add project button is displayed
    And username is "Ales Trost"
    And projects count is 15

  Scenario Outline: Таблицы
    Given open browser
    * login page is opened
    When user with email "<email>" and psw "<psw>" logged in
    Then username is "<visibleTest>"
    Examples:
      | email                 | psw         | visibleTest |
      | atrostyanko@gmail.com | Americana#1 | Alex Trost  |
      | test@gmail.com        | Americana#1 | 135         |
    
