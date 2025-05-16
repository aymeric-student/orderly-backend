package com.orderly.votybe.menus;

import com.orderly.votybe.categories.CategoryDto;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MenuDto {
    private UUID id;
    private UUID restaurantId;
    private List<CategoryDto> categories;
}
