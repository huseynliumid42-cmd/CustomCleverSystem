package az.umid.userservice.dto;

public record UserResponse(
        Long id,
        String username,
        String email,
        String fullname,
        String pinCode,
        String role
) {
}
