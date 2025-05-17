package com.orderly.votybe.teams;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class TeamDto {

    private UUID teamId;

    @NotNull(message = "Restaurant ID cannot be null")
    private UUID restaurantId;

    @NotBlank(message = "Team member name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s'-]+$", message = "Name can only contain letters, spaces, hyphens and apostrophes")
    private String name;

    @NotBlank(message = "Role cannot be blank")
    @Size(min = 2, max = 30, message = "Role must be between 2 and 30 characters")
    private String role;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be valid")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    private String email;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^[+]?[0-9\\s.\\-()]{10,20}$", message = "Phone number must be valid (10-20 digits, can include +, spaces, dots, hyphens, parentheses)")
    private String phone;

    @NotNull(message = "Schedule cannot be null")
    @Size(min = 1, max = 7, message = "Schedule must have between 1 and 7 entries")
    private List<@NotBlank(message = "Schedule entry cannot be blank")
    @Pattern(regexp = "^(Lundi|Mardi|Mercredi|Jeudi|Vendredi|Samedi|Dimanche): \\d{2}:\\d{2}-\\d{2}:\\d{2}$",
            message = "Schedule entry must follow format 'Day: HH:MM-HH:MM' (e.g., 'Lundi: 09:00-17:00')")
            String> schedule;
}