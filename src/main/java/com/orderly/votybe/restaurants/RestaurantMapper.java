package com.orderly.votybe.restaurants;

public class RestaurantMapper {

    public static Restaurant toEntity(RestaurantDto restaurantDto) {
        return Restaurant.builder()
                .id(restaurantDto.getRestaurantId())
                .name(restaurantDto.getName())
                .address(restaurantDto.getAddress())
                .openingHours(restaurantDto.getOpeningHours())
                .build();
    }

    public static RestaurantDto toDto(Restaurant restaurant) {
        return RestaurantDto.builder()
                .restaurantId(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .openingHours(restaurant.getOpeningHours())
                .build();
    }
}
