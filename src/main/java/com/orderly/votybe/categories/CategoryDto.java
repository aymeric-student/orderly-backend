package com.orderly.votybe.categories;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private UUID categoryId;
    private String name;
    private String icon;
    private String menuId;
}
