package az.umid.aiintegrationservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AIRequestDTO {

    @NotNull(message = "User ID mütləqdir")
    private Long userId;

    @NotBlank(message = "Sual (prompt) boş ola bilməz")
    @Size(max = 1000, message = "Sual 1000 simvoldan çox ola bilməz")
    private String prompt;
}