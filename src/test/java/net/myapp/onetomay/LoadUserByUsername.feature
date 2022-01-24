Feature: Finding user
  By username
  If user with that specific username exist in database


  Scenario:
    Given a user with username "email@.com",name "wiktor",surname "porowski" and password "1234"
    When search for user with "email@.com"
    Then a founded user have username "email@.com",name "wiktor",surname "porowski" and password "1234"

 
