package com.orderly.votybe.teams;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class TeamDto {
    private UUID teamId;
    private String name;
    private String role;
    private String email;
    private String phone;
    private List<String> schedule;
    private UUID restaurantId;
}
