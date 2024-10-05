package backend.repositories;

import backend.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ProductRepository {

    @PersistenceContext(unitName = "my_pu")
    private EntityManager em;

    public void create(Product product) {
        try {
            em.persist(product);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Product product) {
        try {
            em.merge(product);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Product product) {
        try {
            em.remove(product);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

}
