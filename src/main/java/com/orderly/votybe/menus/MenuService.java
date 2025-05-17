package com.orderly.votybe.menus;

import com.orderly.votybe.categories.Category;
import com.orderly.votybe.categories.CategoryService;
import com.orderly.votybe.restaurants.Restaurant;
import com.orderly.votybe.restaurants.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private final CategoryService categoryService;

    public MenuDto createMenu(MenuDto menuDto) {
        Restaurant restaurant = restaurantRepository.findById(menuDto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Menu menu = Menu.builder()
                .restaurant(restaurant)
                .build();

        List<Category> categories = categoryService.createCategories(menuDto.getCategories(), menu);
        menu.setCategories(categories);

        Menu savedMenu = menuRepository.save(menu);

        return MenuDto.builder()
                .menuId(savedMenu.getId())
                .restaurantId(savedMenu.getRestaurant().getId())
                .categories(categoryService.convertToDtos(savedMenu.getCategories()))
                .build();
    }

    public MenuDto getMenuById(UUID menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + menuId));

        return MenuDto.builder()
                .menuId(menu.getId())
                .restaurantId(menu.getRestaurant().getId())
                .categories(categoryService.convertToDtos(menu.getCategories()))
                .build();
    }

    public List<MenuDto> getAllMenus() {
        return menuRepository.findAll().stream()
                .map(menu -> MenuDto.builder()
                        .menuId(menu.getId())
                        .restaurantId(menu.getRestaurant().getId())
                        .categories(categoryService.convertToDtos(menu.getCategories()))
                        .build())
                .collect(Collectors.toList());
    }
}
