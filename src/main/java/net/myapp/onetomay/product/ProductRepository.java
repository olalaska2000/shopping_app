package net.myapp.onetomay.product;

import net.myapp.onetomay.login.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Product findByName(String name);
}
