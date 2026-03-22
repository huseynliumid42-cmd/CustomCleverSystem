package az.umid.customservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
@Data
public class CustomsDuty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private String hsCode;

    private Double price;

    private String currency;

    private Double tax;

    private Double totalPrice;

    private String aiAnalysis;

    private String status;

    private LocalDateTime createdAt;
}