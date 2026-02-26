package az.umid.userservice.service.impl;

import az.umid.userservice.Mapper.UserMapper;
import az.umid.userservice.dto.UserRegistrationRequest;
import az.umid.userservice.dto.UserResponse;
import az.umid.userservice.entity.Role;
import az.umid.userservice.entity.User;
import az.umid.userservice.repository.UserRepository;
import az.umid.userservice.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponse registerUser(UserRegistrationRequest request){
        if (userRepository.existsByUsername(request.username())){
            throw new RuntimeException("Bu istifadeci artiq movcuddur");
        }
        User user = userMapper.toEntity(request);

        user.setRole(Role.ROLE_USER);
        user.setCreatedAt(LocalDateTime.now());

        user.setPassword(request.password());

        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);

    }
    @Override
    public UserResponse getUserById(Long id){
        return userRepository.findById(id)
                .map(userMapper::toResponse)
                .orElseThrow(()->new RuntimeException("Istifadeci tapilmadi! ID" + id));
    }
    @Override
    public List<UserResponse> getAllUsers(){
        return userRepository.findAll().stream()
                .map(userMapper::toResponse)
                .toList();
    }
    @Transactional
    @Override
    public UserResponse uptadeUser(Long id, UserRegistrationRequest request){
        User exisitingUser = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Yenilenecek istifadeci tapilmadi!"));

        userMapper.uptadeUserFromDto(request, exisitingUser);

        if (request.password()!= null && !request.password().isBlank()) {
            exisitingUser.setPassword(request.password());
        }
            User uptadeUser = userRepository.save(exisitingUser);
            return userMapper.toResponse(uptadeUser);
            }

        @Transactional
        @Override
        public void deleteUser(Long id){
            if (!userRepository.existsById(id)){
                throw new RuntimeException("Silinecek istifadeci tapilmadi");
            }
            userRepository.deleteById(id);
        }

    @Override
    public UserResponse updateUser(Long id, UserRegistrationRequest request) {
        return null;
    }


}


