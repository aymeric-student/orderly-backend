package com.orderly.votybe.menus;

import com.orderly.votybe.categories.Category;
import com.orderly.votybe.categories.CategoryDto;
import com.orderly.votybe.categories.CategoryMapper;
import com.orderly.votybe.restaurants.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

public class MenuMapper {

    public static Menu toEntity(MenuDto menuDto, Restaurant restaurant, List<Category> categories) {
        return Menu.builder()
                .id(menuDto.getId())
                .restaurant(restaurant)
                .categories(categories)
                .build();
    }

    public static MenuDto toDto(Menu menu) {
        List<CategoryDto> categoryDtos = menu.getCategories().stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());

        return MenuDto.builder()
                .id(menu.getId())
                .restaurantId(menu.getRestaurant().getId())
                .categories(categoryDtos)
                .build();
    }
}
