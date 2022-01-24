package net.myapp.onetomay;

import net.myapp.onetomay.product.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AddDetailsToProduct {

    @Test
    public void correctParametrs(){
        Product product = new Product();
        product.addDetail("jeans", "34");


        assertEquals("jeans",product.getDetails().get(0).getName());
        assertEquals("34",product.getDetails().get(0).getValue());
    }

    @Test
    public void correctSize(){
        Product product = new Product();

        assertEquals(0,product.getDetails().size());

        product.addDetail("jeans", "34");

        assertEquals(1,product.getDetails().size());
        assertNotEquals(2,product.getDetails().size());
    }
}
