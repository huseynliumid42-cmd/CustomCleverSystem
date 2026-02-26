package az.umid.userservice.service;

import az.umid.userservice.dto.UserRegistrationRequest;
import az.umid.userservice.dto.UserResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserResponse registerUser(UserRegistrationRequest request);

    UserResponse getUserById(Long id);




    List<UserResponse> getAllUsers();

    @Transactional
    UserResponse uptadeUser(Long id, UserRegistrationRequest request);

    @Transactional
    void deleteUser(Long id);

    UserResponse updateUser(Long id, UserRegistrationRequest request);
}
