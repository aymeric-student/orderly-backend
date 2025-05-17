package com.orderly.votybe.categories;


import com.orderly.votybe.menus.Menu;

public class CategoryMapper {
    public static Category toEntity(CategoryDto categoryDto, Menu menu) {
        return Category.builder()
                .id(categoryDto.getCategoryId())
                .name(categoryDto.getName())
                .icon(categoryDto.getIcon())
                .menu(menu)
                .build();
    }

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .categoryId(category.getId())
                .name(category.getName())
                .icon(category.getIcon())
                .menuId(category.getMenu() != null ? category.getMenu().getId() : null)
                .build();
    }
}
