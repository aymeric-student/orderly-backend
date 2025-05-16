package com.orderly.votybe.confirmation;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "confirmation")
public class Confirmation {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private boolean qualityStandards;

    private boolean accurateInfo;

    private boolean termsAndConditions;

    private boolean notifications;
}
