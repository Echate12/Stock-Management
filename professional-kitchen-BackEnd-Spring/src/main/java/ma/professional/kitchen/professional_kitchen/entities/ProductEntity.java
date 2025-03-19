package ma.professional.kitchen.professional_kitchen.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;
    private String name;
    private String category;
    private int quantity;
    private double prixAchat;
    private double prixVente;
    private boolean available;

    // Constructor without ID (for creating new products)
    public ProductEntity(String label, String name, String category, int quantity, double prixAchat, double prixVente, boolean available) {
        this.label = label;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.available = available;
    }
}
