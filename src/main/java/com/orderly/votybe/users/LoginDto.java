package com.orderly.votybe.users;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    @NotBlank(message = "email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;
}
