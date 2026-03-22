package az.umid.customservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomsRequest {

    @NotBlank(message = "Məhsul adı boş ola bilməz")
    @Size(min = 2, max = 100, message = "Məhsul adı 2-100 simvol arasında olmalıdır")
    private String productName;

    @NotBlank(message = "HS kod boş ola bilməz")
    @Size(min = 6, max = 12, message = "HS kod düzgün deyil")
    private String hsCode;

    @NotNull(message = "Qiymət boş ola bilməz")
    @Positive(message = "Qiymət müsbət olmalıdır")
    private Double price;

    @NotBlank(message = "Valyuta boş ola bilməz")
    private String currency;
}