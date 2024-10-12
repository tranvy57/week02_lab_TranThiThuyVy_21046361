package backend.entities;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ProductStatusConverter implements AttributeConverter<ProductStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductStatus status) {
        if (status == null) {
            return null;
        }
        return status.getStatus(); // 1, 0, -1
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer integer) {
        if(integer == null){
            return null;
        }

        for(ProductStatus status : ProductStatus.values()){
            if(status.getStatus() == integer){
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + integer);
    }
}
