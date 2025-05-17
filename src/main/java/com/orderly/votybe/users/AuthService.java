package com.orderly.votybe.users;

import com.orderly.votybe.core.exceptions.errors.BadRequestException;
import com.orderly.votybe.core.exceptions.errors.NotFoundException;
import com.orderly.votybe.core.exceptions.errors.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponseDto register(RegisterDto registerDto) {
        // Vérifier si l'utilisateur existe déjà
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new BadRequestException("Username already exists!");
        }

        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new BadRequestException("Email already exists!");
        }

        // Créer le nouvel utilisateur
        String encodedPassword = passwordEncoder.encode(registerDto.getPassword());
        User user = UserMapper.toEntity(registerDto, encodedPassword);
        User savedUser = userRepository.save(user);

        // Générer le token JWT
        String token = jwtUtil.generateToken(savedUser.getUsername());

        return UserMapper.toAuthResponse(savedUser, token);
    }

    public AuthResponseDto login(LoginDto loginDto) {
        User user = userRepository.findByEmail(
                loginDto.getEmail()
        ).orElseThrow(() -> new NotFoundException("User not found"));

        // Vérifier le mot de passe
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Invalid credentials");
        }

        // Vérifier si l'utilisateur est actif
        if (!user.isActive()) {
            throw new UnauthorizedException("Account is disabled");
        }

        // Générer le token JWT
        String token = jwtUtil.generateToken(user.getUsername());

        return UserMapper.toAuthResponse(user, token);
    }

    public UserDto getCurrentUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return UserMapper.toDto(user);
    }
}