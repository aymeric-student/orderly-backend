package com.orderly.votybe.menus;

import com.orderly.votybe.categories.CategoryDto;
import lombok.*;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {

    private UUID menuId;

    @NotNull(message = "Restaurant ID cannot be null")
    private UUID restaurantId;

    @NotNull(message = "Categories list cannot be null")
    @NotEmpty(message = "Menu must have at least one category")
    @Size(min = 1, max = 15, message = "Menu must have between 1 and 15 categories")
    @Valid
    private List<CategoryDto> categories;
}
