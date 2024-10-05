package backend.api;

import backend.bussiness.ProductRemote;
import backend.entities.Product;
import jakarta.ejb.EJB;
import jakarta.persistence.Entity;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/products")
public class ProductResource {
    @EJB
    private ProductRemote productRemote;

    @GET
    public Response getProducts() {
        return Response.ok(productRemote.getProducts()).build();
    }

    @POST
    public Response addProduct(Product product) {
        productRemote.add(product);
        return Response.ok(product).build();
    }
}
