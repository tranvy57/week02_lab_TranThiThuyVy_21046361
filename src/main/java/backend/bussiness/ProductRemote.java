package backend.bussiness;

import backend.dto.ProductDTO;
import backend.dto.ProductRequest;
import backend.entities.Product;
import jakarta.ejb.Local;
import jakarta.ejb.Remote;

import java.util.List;

@Local
public interface ProductRemote {
    void add(ProductRequest product);
    //    void update(Product product);
    void delete(String id);
    ProductDTO getProduct(long id);
    List<ProductDTO> getProducts();
}
