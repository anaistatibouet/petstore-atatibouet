package org.at.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String label;
    private double price;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @ManyToMany(mappedBy = "products")
    private Set<Petstore> petstores;

    public Product() {
        petstores = new HashSet<>();
    }

//    Getter Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Set<Petstore> getPetstores() {
        return petstores;
    }

    public void setPetstores(Set<Petstore> petstores) {
        this.petstores = petstores;
    }
}
