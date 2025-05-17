package com.orderly.votybe.items;

public class ItemMapper {
    public static Item toEntity(ItemDto dto) {
        return Item.builder()
                .id(dto.getItemId())
                .name(dto.getName())
                .description(dto.getDescription())
                .ingredients(dto.getIngredients())
                .price(dto.getPrice())
                .bestseller(dto.isBestseller())
                .vegetarian(dto.isVegetarian())
                .vegan(dto.isVegan())
                .glutenFree(dto.isGlutenFree())
                .spicy(dto.isSpicy())
                .isNew(dto.isNew())
                .build();
    }

    public static ItemDto toDto(Item item) {
        return ItemDto.builder()
                .itemId(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .ingredients(item.getIngredients())
                .price(item.getPrice())
                .bestseller(item.isBestseller())
                .vegetarian(item.isVegetarian())
                .vegan(item.isVegan())
                .glutenFree(item.isGlutenFree())
                .spicy(item.isSpicy())
                .isNew(item.isNew())
                .categoryId(item.getCategory().getId())
                .build();
    }
}
