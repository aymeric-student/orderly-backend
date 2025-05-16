package com.orderly.votybe.settings;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "settings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Settings {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private String id;

    private boolean enableOnlineOrdering;

    private boolean onSite;

    private boolean takeAway;

    public boolean delivery;

    public int minOrderAmount;

    public String openingTime;

    public String closingTime;

    public String orderMode;

    public String prepTime;
}
