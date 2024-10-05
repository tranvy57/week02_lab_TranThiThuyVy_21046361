package frontend.models;

import backend.dto.ProductDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

import java.util.List;
//class dùng để gửi request lên server để lấy dữ liệu về
public class ProductModel {
    private static final String BASED_URI = "http://localhost:8080/Zy_week02-1.0-SNAPSHOT/api/products";

    public List<ProductDTO> getAllProducts(){
    List<ProductDTO> products = null;
// Tại sao phải tạo client?
// Để tạo ra một client, chúng ta sử dụng ClientBuilder.newClient(). Client là một đối tượng chịu trách nhiệm gửi các yêu cầu HTTP đến một địa chỉ cụ thể.
// Tại sao phải tạo target?
// Để tạo ra một target, chúng ta sử dụng client.target(BASED_URI). Target là một đối tượng chịu trách nhiệm xác định địa chỉ cụ thể mà yêu cầu sẽ được gửi đến.
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(BASED_URI);
            String json= target
                    .request("application/json")
                    .get()
                    .readEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            products = mapper.readValue(json, new TypeReference<List<ProductDTO>>(){});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
