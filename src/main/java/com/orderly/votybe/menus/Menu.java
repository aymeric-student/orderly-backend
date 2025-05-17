package com.orderly.votybe.menus;

import com.orderly.votybe.categories.Category;
import com.orderly.votybe.core.BaseEntity;
import com.orderly.votybe.restaurants.Restaurant;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "menus")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> categories = new ArrayList<>();
}
