package com.orderly.votybe.confirmation;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.orderly.votybe.core.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "confirmation")
@Getter
@Setter
public class Confirmation extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private boolean qualityStandards;

    private boolean accurateInfo;

    private boolean termsAndConditions;

    private boolean notifications;
}
