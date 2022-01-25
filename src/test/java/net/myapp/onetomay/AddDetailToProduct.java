package net.myapp.onetomay;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.myapp.onetomay.product.ProductDetails;
import net.myapp.onetomay.product.Product;

import static org.junit.jupiter.api.Assertions.*;

public class AddDetailToProduct {
    Product product = new Product();
    ProductDetails detail;

    @Given("detail with data id, {string},name of product {string},price {string}")
    public void detail_with_data_id_name_of_product_price(String id, String name, String price) {
        detail = new ProductDetails(Integer.valueOf(id), name, price);
    }

    @When("detail added to product")
    public void detail_added_to_product() {
        product.addDetail(detail.getName(), detail.getValue());
    }

    @Then("product have {string} detail")
    public void product_have_detail(String amount) {
        assertEquals(Integer.valueOf(amount), product.getDetails().size());
    }

    @Then("product have data name of product {string},price {string}")
    public void product_have_data_name_of_product_price(String name, String price) {
        assertEquals(name, product.getDetails().get(0).getName());
        assertEquals(price, product.getDetails().get(0).getValue());
    }

    @Given("product with one detail already and detail with data id, {string},name of product {string},price {string}")
    public void product_with_one_detail_already_and_detail_with_data_id_name_of_product_price(String id, String name, String price) {
        ProductDetails detailBefore = new ProductDetails();
        product.addDetail(detailBefore.getName(), detailBefore.getValue());

        detail = new ProductDetails(Integer.valueOf(id), name, price);
    }


    @Then("product have also data name of product {string},price {string}")
    public void product_have_also_data_name_of_product_price(String name, String price) {
        assertEquals(name, product.getDetails().get(1).getName());
        assertEquals(price, product.getDetails().get(1).getValue());
    }

    @Then("product have more than {string} detail")
    public void product_have_more_than_detail(String amount) {
        assertTrue(Integer.valueOf(amount) < product.getDetails().size());
    }

    @When("null detail added to product")
    public void null_detail_added_to_product() {
        product.addDetail(detail);
    }
    @Then("product have data no name of product and price")
    public void product_have_data_no_name_of_product_and_price() {
        assertEquals(0, product.getDetails().size());
    }
}
