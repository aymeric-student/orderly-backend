package com.orderly.votybe.menus;


import com.orderly.votybe.categories.Category;
import com.orderly.votybe.categories.CategoryService;
import com.orderly.votybe.restaurants.Restaurant;
import com.orderly.votybe.restaurants.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private final CategoryService categoryService;

    public MenuDto createMenu(MenuDto menuDto) {
        if (menuDto == null) {
            throw new IllegalArgumentException("MenuDto cannot be null");
        }

        Restaurant restaurant = restaurantRepository.findById(menuDto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Menu menu = MenuMapper.toEntity(menuDto);
        menu.setRestaurant(restaurant);

        List<Category> categories = categoryService.createCategories(menuDto.getCategories(), menu);
        menu.setCategories(categories);

        Menu savedMenu = menuRepository.save(menu);

        MenuDto resultDto = MenuMapper.toDto(savedMenu);
        resultDto.setCategories(categoryService.convertToDtos(savedMenu.getCategories()));

        return resultDto;
    }

    public MenuDto getMenuById(UUID menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + menuId));

        MenuDto menuDto = MenuMapper.toDto(menu);
        menuDto.setCategories(categoryService.convertToDtos(menu.getCategories()));

        return menuDto;
    }

    public List<MenuDto> getAllMenus() {
        return menuRepository.findAll().stream()
                .filter(Objects::nonNull)
                .map(menu -> {
                    MenuDto menuDto = MenuMapper.toDto(menu);
                    menuDto.setCategories(categoryService.convertToDtos(menu.getCategories()));
                    return menuDto;
                })
                .collect(Collectors.toList());
    }
}