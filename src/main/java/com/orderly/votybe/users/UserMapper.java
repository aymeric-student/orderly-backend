package com.orderly.votybe.users;

public class UserMapper {

    public static User toEntity(RegisterDto registerDto, String encodedPassword) {
        return User.builder()
                .username(registerDto.getUsername())
                .email(registerDto.getEmail())
                .password(encodedPassword)
                .active(true)
                .build();
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .active(user.isActive())
                .build();
    }

    public static AuthResponseDto toAuthResponse(User user, String token) {
        return AuthResponseDto.builder()
                .token(token)
                .userId(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
