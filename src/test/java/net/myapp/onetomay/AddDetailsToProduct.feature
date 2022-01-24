Feature: Adding details to product


  Scenario:
    Given details with data id, "1",name of product "name",price "2"
    When detail added to product
    Then product have "1" new detail


  Scenario:
    Given details with data id, "1",name of product "name",price "2"
    When detail added to product
    Then product have new data name of product "name",price "2"

