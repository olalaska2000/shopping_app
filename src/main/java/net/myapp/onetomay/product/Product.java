package net.myapp.onetomay.product;

import net.myapp.onetomay.category.Category;
import net.myapp.onetomay.color.Colour;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private float price;
    private Integer quantity;
    private String size;
    private String gender;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product(Integer id, String name, float price, Integer quantity, String size, String gender, String photo, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.gender = gender;
        this.photo = photo;
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public Product(Integer id, String name, float price,   String size, String gender, String photo, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;


        this.size = size;
        this.gender = gender;
        this.photo = photo;
        this.category = category;
    }

    public Product(Integer id, String name, float price,  String photo, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;

        this.photo = photo;
        this.category = category;
    }

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "colour_id")
    private Colour colour;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductDetails> details = new ArrayList<>();

    public Product(Integer id, String name, float price, Category category, String photo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.photo=photo;
    }



    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<ProductDetails> getDetails() {
        return details;
    }

    public void setDetails(List<ProductDetails> details) {
        this.details = details;
    }

    public Product() {
    }

    public void setDetail(Integer id, String name, String value){
        this.details.add(new ProductDetails(id, name,value, this));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addDetail(String name, String value){
        this.details.add(new ProductDetails(name, value, this));
    }

}
