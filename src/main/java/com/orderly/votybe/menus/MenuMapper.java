package com.orderly.votybe.menus;

import com.orderly.votybe.categories.Category;
import com.orderly.votybe.restaurants.Restaurant;

import java.util.List;

public class MenuMapper {

    public static Menu toEntity(MenuDto menuDto, Restaurant restaurant, List<Category> categories) {
        return Menu.builder()
                .id(menuDto.getMenuId())
                .restaurant(restaurant)
                .categories(categories)
                .build();
    }

    public static Menu toEntity(MenuDto menuDto) {
        return Menu.builder()
                .id(menuDto.getMenuId())
                .build();
    }
}
