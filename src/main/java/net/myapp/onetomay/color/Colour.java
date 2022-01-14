package net.myapp.onetomay.color;

import javax.persistence.*;

@Entity
public class Colour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String name;

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

    public Colour(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Colour() {
    }

    @Override
    public String toString() {
        return "Colour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
