package com.orderly.votybe.teams;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    public UUID id;

    public String name;

    public String role;

    public String email;

    public String phone;

    @ElementCollection
    @CollectionTable(name = "team_schedule", joinColumns = @JoinColumn(name = "team_id"))
    @Column(name = "day")
    private List<String> schedule;
}
