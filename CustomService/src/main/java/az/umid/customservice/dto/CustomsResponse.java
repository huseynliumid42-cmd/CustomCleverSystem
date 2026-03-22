package az.umid.customservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class CustomsResponse {

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
