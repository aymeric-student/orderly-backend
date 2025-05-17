package com.orderly.votybe.settings;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.orderly.votybe.core.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "settings")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Settings extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private boolean enableOnlineOrdering;

    private boolean onSite;

    private boolean takeAway;

    private boolean delivery;

    private int minOrderAmount;

    private String openingTime;

    private String closingTime;

    private String orderMode;

    private String prepTime;
}
