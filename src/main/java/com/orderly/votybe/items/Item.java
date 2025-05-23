package com.orderly.votybe.items;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.orderly.votybe.categories.Category;
import com.orderly.votybe.core.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "menu_items")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private String name;
    private String description;

    @ElementCollection
    @CollectionTable(name = "menu_item_ingredients", joinColumns = @JoinColumn(name = "menu_item_id"))
    @Column(name = "ingredient")
    private List<String> ingredients;

    private double price;

    private boolean bestseller;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean spicy;

    @Column(name = "is_new")
    private boolean isNew;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
