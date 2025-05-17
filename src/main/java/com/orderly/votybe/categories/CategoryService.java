package com.orderly.votybe.categories;

import com.orderly.votybe.menus.Menu;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {

    public List<Category> createCategories(List<CategoryDto> categoryDtos, Menu menu) {
        List<Category> categories = categoryDtos.stream()
                .map(CategoryMapper::toEntity)
                .collect(Collectors.toList());

        categories.forEach(category -> category.setMenu(menu));
        return categories;
    }

    public List<CategoryDto> convertToDtos(List<Category> categories) {
        return categories.stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }
}
