package az.umid.currencyservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRequest {
    @NotBlank(message = "Kod bos ola bilmez")
    @Size(min = 3, max = 3, message = "Kod 3 herfli olmalidir")
    private String code;

    @NotNull(message = "Mezenne yazilmalidir")
    @Positive(message = "Mezenne 0-dan boyuk olmalidir")
    private Double rate;
}
