package az.umid.customservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomsResponse {
    private Long id;              
    private String productName;   
    private String hsCode;        
    private double tax;           
    private double totalPrice;    
    private String aiAnalysis;    
    private LocalDateTime createdAt; 
    private String status;
}
