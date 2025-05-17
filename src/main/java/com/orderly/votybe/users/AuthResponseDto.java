package com.orderly.votybe.users;

import lombok.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {
    private String token;
    private UUID userId;
    private String username;
    private String email;
}
