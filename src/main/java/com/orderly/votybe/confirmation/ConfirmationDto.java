package com.orderly.votybe.confirmation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class ConfirmationDto {
    private UUID confirmationId;
    private boolean qualityStandards;
    private boolean accurateInfo;
    private boolean termsAndConditions;
    private boolean notifications;
}
