package com.orderly.votybe.items;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ItemDto {
    private UUID id;
    private String name;
    private String description;
    private List<String> ingredients;
    private double price;
    private boolean bestseller;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean spicy;
    private boolean isNew;
    private UUID categoryId;
}

