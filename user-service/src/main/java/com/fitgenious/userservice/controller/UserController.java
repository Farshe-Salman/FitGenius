package com.fitgenious.userservice.controller;

import com.fitgenious.userservice.dto.UserRequestDTO;
import com.fitgenious.userservice.dto.UserResponseDTO;
import com.fitgenious.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUserProfile(@PathVariable String userId)
    {
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody UserRequestDTO requestDTO)
    {
        return ResponseEntity.ok(userService.addNewUser(requestDTO));
    }


}
