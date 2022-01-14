package net.myapp.onetomay.cartItem;

import net.myapp.onetomay.customer.Customer;
import net.myapp.onetomay.login.User;
import net.myapp.onetomay.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    public List<CartItem> findByUser(User user);

    public CartItem findByUserAndProduct(User user, Product product);

    @Query("UPDATE CartItem c SET c.quantity = ?1 WHERE c.product.id = ?2"
    + "AND c.user.id=?3")
    @Modifying
    public void updateQuantity(Integer quantity, Integer productId, Integer userId);
}
