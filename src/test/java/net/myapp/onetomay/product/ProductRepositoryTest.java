package net.myapp.onetomay.product;

import net.myapp.onetomay.category.Category;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repo;

    @Test
    public void testCreateProduct(){
        Product savedProduct = repo.save(new Product(1,"Spodnie", 90, 1,"s", "kobieta","", null));
        assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    @Test
    public void test(){
        Product product = new Product(1,"Spodnie", 90, 1,"s", "kobieta","", null);
        Product product1 = Mockito.spy(product);

        Mockito.doReturn(true).when(product1).isProduct();
        assertEquals(true,product1.isExistInBasket());

    }

}


