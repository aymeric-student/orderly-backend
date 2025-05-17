package com.orderly.votybe.confirmation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationDto {
    private UUID confirmationId;
    private boolean qualityStandards;
    private boolean accurateInfo;
    private boolean termsAndConditions;
    private boolean notifications;
}
