package com.orderly.votybe.menus;

public class MenuMapper {

    public static Menu toEntity(MenuDto menuDto) {
        return Menu.builder()
                .id(menuDto.getMenuId())
                .build();
    }

    public static MenuDto toDto(Menu menu) {
        return MenuDto.builder()
                .menuId(menu.getId())
                .restaurantId(menu.getRestaurant() != null ? menu.getRestaurant().getId() : null)
                .categories(null)
                .build();
    }
}
