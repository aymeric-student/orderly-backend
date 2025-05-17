package com.orderly.votybe.confirmation;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ConfirmationDto {
    private UUID confirmationId;
    private boolean qualityStandards;
    private boolean accurateInfo;
    private boolean termsAndConditions;
    private boolean notifications;
}
