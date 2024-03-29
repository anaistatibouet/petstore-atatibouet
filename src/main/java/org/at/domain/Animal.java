package org.at.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_ANIMAL")
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long Id;
    protected Date birth;
    protected String couleur;

    @ManyToOne
    @JoinColumn(name="PET_ID")
    private Petstore petstore;

//    Constructeur
    public Animal() {
    }

//    Getter Setter

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Petstore getPetstore() {
        return petstore;
    }

    public void setPetstore(Petstore petstore) {
        this.petstore = petstore;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Animal{");
        sb.append("Id=").append(Id);
        sb.append(", birth=").append(birth);
        sb.append(", couleur='").append(couleur).append('\'');
        sb.append(", petstore=").append(petstore);
        sb.append('}');
        return sb.toString();
    }
}
