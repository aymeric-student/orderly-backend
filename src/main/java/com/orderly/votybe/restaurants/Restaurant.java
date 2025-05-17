package com.orderly.votybe.restaurants;

import com.orderly.votybe.core.BaseEntity;
import com.orderly.votybe.menus.Menu;
import lombok.*;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "restaurants")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private String name;
    private String address;
    private String openingHours;

    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Menu menu;
}
