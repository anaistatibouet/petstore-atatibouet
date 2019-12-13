package org.at;

import org.at.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;


public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "petstore-jpa" );

        EntityManager em = emf.createEntityManager();

        System.out.println("Start inserting datas");

        System.out.println("First row");
         Address address = new Address( "1", "rue de la Jpa", "44200", "Nantes" );
         Product product = new Product();
         product.setCode("croquettes");
         product.setLabel("Whiskas");
         product.setPrice(30);
         product.setProductType(ProductType.Food);
         Fish fish = new Fish();
         fish.setLivingEnv(LivingEnv.fresh_Water);

         Cat cat = new Cat();
         cat.setBirth( new Date());
         cat.setChipId("e8e8bc08-1dce-11ea-978f-2e728ce88125");
         cat.setCouleur("white");


        Petstore petstore = new Petstore();
         petstore.setAddress( address );
         petstore.setManagerName("Sega");
         petstore.setName("Animaux heureux");

         cat.setPetstore(petstore);
         fish.setPetstore(petstore);

        System.out.println("Second row");
        Address address2 = new Address( "2", "rue de l'injection SQL", "44200", "Nantes" );
        Product product2 = new Product();
        product2.setCode("gamelle");
        product2.setLabel("SuperCat");
        product2.setPrice(30);
        product2.setProductType(ProductType.Accessory);
        Fish fish2 = new Fish();
        fish2.setLivingEnv(LivingEnv.Sea_Water);

        Cat cat2 = new Cat();
        cat2.setBirth( new Date());
        cat2.setChipId("fef8023a-1ttc-11ea-978f-2e728ce88125");
        cat2.setCouleur("black");

        Petstore petstore2 = new Petstore();
        petstore2.setAddress( address );
        petstore2.setManagerName("Monchat");
        petstore2.setName("Super pets");

        cat2.setPetstore(petstore2);
        fish2.setPetstore(petstore2);

        System.out.println("Second row");
        Address address3 = new Address( "2", "rue de l'injection SQL", "44200", "Nantes" );
        Product product3 = new Product();
        product3.setCode("Litière");
        product3.setLabel("SensBon");
        product3.setPrice(30);
        product3.setProductType(ProductType.Cleaning);
        Fish fish3 = new Fish();
        fish3.setLivingEnv(LivingEnv.Sea_Water);

        Cat cat3 = new Cat();
        cat3.setBirth( new Date());
        cat3.setChipId("7d0b023a-1ddc-11ea-978f-2e728ce88125");
        cat3.setCouleur("brown");

        Petstore petstore3 = new Petstore();
        petstore3.setAddress( address );
        petstore3.setManagerName("Joy");
        petstore3.setName("Happy Pets");

        cat3.setPetstore(petstore2);
        fish3.setPetstore(petstore2);


        em.getTransaction().begin();

         em.persist(address);
         em.persist(product);
         em.persist(fish);
         em.persist(cat);

         em.persist(petstore);
         em.persist(address2);
         em.persist(product2);
         em.persist(fish2);
         em.persist(cat2);
         em.persist(petstore2);

        em.persist(address3);
        em.persist(product3);
        em.persist(fish3);
        em.persist(cat3);
        em.persist(petstore3);

         System.out.println("End persist");
         em.getTransaction().commit();
         System.out.println("Send in database");

        Query query = em.createQuery(
                "select a from Animal a where petstore.id= 1L") ;

        // exécution et récupération de la liste résultat
        List<Animal> animals = query.getResultList() ;
        System.out.println(animals);

        emf.close();
    }
}
