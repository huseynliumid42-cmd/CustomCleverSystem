package az.umid.customservice.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ErrorResponse {
    private String message;
    private int status;
}