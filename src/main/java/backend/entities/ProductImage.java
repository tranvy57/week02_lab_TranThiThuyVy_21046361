package backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_images")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column(name = "alternative", length = 250)
    private String alternative;

    @Column(name = "path", length = 250)
    private String path;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Getters và Setters
}