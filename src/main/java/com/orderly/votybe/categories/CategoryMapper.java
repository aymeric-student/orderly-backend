package com.orderly.votybe.categories;

public class CategoryMapper {
    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .categoryId(category.getId())
                .name(category.getName())
                .icon(category.getIcon())
                .menuId(category.getMenu() != null ? category.getMenu().getId() : null)
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getCategoryId())
                .name(categoryDto.getName())
                .icon(categoryDto.getIcon())
                .build();
    }
}
