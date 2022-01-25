Feature: Adding details to product



  Scenario:
    Given detail with data id, "1",name of product "jacket",price "20"
    When detail added to product
    Then product have data name of product "jacket",price "20"
    And product have "1" detail

  Scenario:
    Given product with one detail already and detail with data id, "1",name of product "jacket",price "20"
    When detail added to product
    Then product have also data name of product "jacket",price "20"
    And product have more than "1" detail

  Scenario:
    When null detail added to product
    Then product have data no name of product and price
    And product have "0" detail
