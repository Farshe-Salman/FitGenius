package com.fitgenious.userservice.service;

import com.fitgenious.userservice.dto.UserRequestDTO;
import com.fitgenious.userservice.dto.UserResponseDTO;
import com.fitgenious.userservice.model.User;
import com.fitgenious.userservice.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repo;


//    public UserResponseDTO getUserProfile(String userId) {
//
//    }

    public UserResponseDTO addNewUser(@Valid UserRequestDTO requestDTO)
    {
        if(repo.existsByEmail(requestDTO.getEmail()))
        {
            throw new RuntimeException("email already exist");
        }
        User user=new User();
        user.setEmail(requestDTO.getEmail());
        user.setPassword(requestDTO.getPassword());
        user.setFirstName(requestDTO.getFirstName());
        user.setLastName(requestDTO.getLastName());

        User saveUser = repo.save(user);

        return new UserResponseDTO(
                saveUser.getId(),
                saveUser.getEmail(),
                saveUser.getFirstName(),
                saveUser.getLastName(),
                saveUser.getCreatedAt(),
                saveUser.getUpdateAt()
        );
    }

    public UserResponseDTO getUserProfile(String userId) {
        User user = repo.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found"));

        return new UserResponseDTO(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getCreatedAt(),
                user.getUpdateAt()
        );
    }
}
