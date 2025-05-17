package com.orderly.votybe.teams;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.orderly.votybe.core.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team")
@Getter
@Setter
public class Team extends BaseEntity {

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
