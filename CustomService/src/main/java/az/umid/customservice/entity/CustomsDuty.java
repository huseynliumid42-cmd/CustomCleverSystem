package az.umid.customservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomsDuty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String hsCode;
    private double price;
    private double tax;

    @Column(columnDefinition = "TEXT")
    private String aiAnalysis;
}