package backend.bussiness;


import backend.dto.ProductDTO;
import backend.dto.ProductRequest;
import backend.entities.Product;
import backend.entities.ProductPrice;
import backend.repositories.ProductPriceRepository;
import backend.repositories.ProductRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProductBean implements ProductRemote{
    @Inject
    private ProductRepository productRepository;

    @Inject
    private ProductPriceRepository productPriceRepository;


    @Override
    public void add(ProductRequest product) {
        Product p = new Product();
        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setUnit(product.getUnit());
        p.setManufacturer(product.getManufacturer());
        p.setStatus(product.getStatus());
        System.out.println(product.getStatus());

        productRepository.create(p);

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ProductDTO getProduct(long id) {
        Product product = productRepository.findById(id);
        ProductPrice productPrice = productPriceRepository.findActivePriceOfProduct(id);
        Double price = productPrice.getPrice();
        ProductDTO  productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(price);
        return  productDTO;
    }

    @Override
    public List<ProductDTO> getProducts() {
        List<Product> listProducts = productRepository.findAll();
        List<ProductDTO> listProductDTO = new ArrayList<>();
        for(Product p: listProducts){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(p.getId());
            productDTO.setName(p.getName());
            productDTO.setDescription(p.getDescription());
            productDTO.setPrice(productPriceRepository.findActivePriceOfProduct(p.getId()).getPrice());
            listProductDTO.add(productDTO);
        }
        return listProductDTO;
    }
}
