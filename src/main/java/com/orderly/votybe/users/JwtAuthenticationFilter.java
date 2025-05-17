package com.orderly.votybe.users;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = getTokenFromRequest(request);

        if (StringUtils.hasText(token)) {
            try {
                String username = jwtUtil.getUsernameFromToken(token);

                if (StringUtils.hasText(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
                    // Vérifier que l'utilisateur existe et est actif
                    userRepository.findByUsername(username)
                            .filter(User::isActive)
                            .ifPresent(user -> {
                                if (jwtUtil.validateToken(token, username)) {
                                    // Créer l'authentication sans rôles pour l'instant
                                    Authentication authentication = new UsernamePasswordAuthenticationToken(
                                            username,
                                            null,
                                            Collections.emptyList() // Pas de rôles pour l'instant
                                    );
                                    SecurityContextHolder.getContext().setAuthentication(authentication);
                                }
                            });
                }
            } catch (Exception e) {
                // Log l'erreur si nécessaire, mais ne pas interrompre le filtre
                logger.error("Cannot set user authentication: {}", e);
            }
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}