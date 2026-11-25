package com.example.HospitalManagement.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponseDto {
    private String username;
    private Long userId;
}
