package com.orderly.votybe.categories;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private UUID categoryId;

    @NotNull(message = "Menu ID cannot be null")
    private UUID menuId;

    @NotBlank(message = "Category name cannot be blank")
    @Size(min = 2, max = 50, message = "Category name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ0-9\\s&'\\-]+$", message = "Category name can only contain letters, numbers, spaces, &, apostrophes and hyphens")
    private String name;

    @Size(max = 100, message = "Icon path cannot exceed 100 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\-_./]+$", message = "Icon must be a valid path/filename (letters, numbers, hyphens, underscores, dots, slashes)")
    private String icon;
}