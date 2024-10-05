package backend.repositories;

import backend.entities.ProductPrice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ProductPriceRepository {
    @PersistenceContext (unitName = "my_pu")
    EntityManager em;

    public void save(ProductPrice productPrice) {
        em.persist(productPrice);
    }

    public ProductPrice findById(Long id) {
        return em.find(ProductPrice.class, id);
    }

    public ProductPrice findActivePriceOfProduct(Long id) {
        return em.createQuery("SELECT p FROM ProductPrice p WHERE p.product.id = :id ", ProductPrice.class)
                .setParameter("id", id)
                .getSingleResult();
    }



}
