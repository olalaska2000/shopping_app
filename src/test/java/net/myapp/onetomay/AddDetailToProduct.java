package net.myapp.onetomay;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.myapp.onetomay.product.ProductDetails;
import net.myapp.onetomay.product.Product;

public class AddDetailToProduct {
    Product product = new Product();
    ProductDetails detail;

    @Given("details with data id, {string},name of product {string},price {string}")
    public void details_with_data_id_name_of_product_price(String id, String name, String price) {
        detail = new ProductDetails(Integer.valueOf(id), name, price);
    }
    @When("detail added to product")
    public void detail_added_to_product() {
        product.addDetail(detail.getName(), detail.getValue());
    }
    @Then("product have {string} new detail")
    public void product_have_new_detail(String string) {

        //throw new io.cucumber.java.PendingException();
    }

    @Then("product have new data name of product {string},price {string}")
    public void product_have_new_data_name_of_product_price(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
}
