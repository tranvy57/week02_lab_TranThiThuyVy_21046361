package backend.bussiness;

import backend.dto.ProductDTO;
import backend.entities.Product;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface ProductRemote {
    void add(Product product);
    //    void update(Product product);
    void delete(Product product);
    ProductDTO getProduct(long id);
    List<ProductDTO> getProducts();
}
