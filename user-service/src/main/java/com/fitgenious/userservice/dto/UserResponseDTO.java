package com.fitgenious.userservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDTO {

    private String id;

    private String email;


    private String firstName;

    private String lastName;


    private LocalDateTime createdAt;

    private LocalDateTime updateAt;
}
