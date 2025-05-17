package com.orderly.votybe.items;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class ItemDto {

    private UUID itemId;

    @NotNull(message = "Category ID cannot be null")
    private UUID categoryId;

    @NotBlank(message = "Item name cannot be blank")
    @Size(min = 2, max = 100, message = "Item name must be between 2 and 100 characters")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @NotNull(message = "Ingredients list cannot be null")
    @NotEmpty(message = "Item must have at least one ingredient")
    @Size(max = 20, message = "Cannot have more than 20 ingredients")
    private List<@NotBlank(message = "Ingredient name cannot be blank")
    @Size(max = 50, message = "Ingredient name cannot exceed 50 characters")
            String> ingredients;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @DecimalMax(value = "999.99", message = "Price cannot exceed 999.99")
    @Digits(integer = 3, fraction = 2, message = "Price must have at most 3 digits before decimal and 2 after")
    private Double price;

    private boolean bestseller;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean spicy;
    private boolean isNew;
}