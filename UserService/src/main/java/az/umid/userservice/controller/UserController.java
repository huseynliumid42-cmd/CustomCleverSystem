package az.umid.userservice.controller;

import az.umid.userservice.dto.UserRegistrationRequest;
import az.umid.userservice.dto.UserResponse;
import az.umid.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/users") 
@RequiredArgsConstructor 
public class UserController {

    private final UserService userService;

    
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRegistrationRequest request) {
        
        return new ResponseEntity<>(userService.registerUser(request), HttpStatus.CREATED);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        
        return ResponseEntity.ok(userService.getUserById(id));
    }

    
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        
        return ResponseEntity.ok(userService.getAllUsers());
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRegistrationRequest request) {
        
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        
        userService.deleteUser(id);
        
        return ResponseEntity.noContent().build();
    }
}