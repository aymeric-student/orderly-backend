package com.orderly.votybe.settings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SettingsDto {
    private UUID settingsId;
    private boolean enableOnlineOrdering;
    private boolean onSite;
    private boolean takeAway;
    private boolean delivery;
    private int minOrderAmount;
    private String openingTime;
    private String closingTime;
    private String orderMode;
    private String prepTime;
    private UUID restaurantId;
}