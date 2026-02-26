package az.umid.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegistrationRequest(
        @NotBlank(message = "Istifadeci adi bos ola bilmez")
        String username,

        @Email(message = "Duzgun email daxil edin")
        @NotBlank(message = "email bos ola bilmez")
        String email,

        @NotBlank(message = "sifre bos ola bilmez")
        @Size(min = 6, message = "Sifre en azi 6 simvoldan ibaret olmalidir")
        String password,

        @NotBlank(message = "Ad ve soyad bos ola bilmez")
        String fullName,

        @NotBlank(message = "FIN kod bos ola bilmez")
        String pinCode
)
{}
