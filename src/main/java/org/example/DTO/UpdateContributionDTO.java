package org.example.DTO;

import java.math.BigDecimal;

public class UpdateContributionDTO {
    private int contributionId;
    private BigDecimal newPercentage;

    public UpdateContributionDTO(int contributionId, BigDecimal newPercentage){
        this.contributionId = contributionId;
        this.newPercentage = newPercentage;
    }
    public int getContributionId() {
        return contributionId;
    }

    public BigDecimal getNewPercentage() {
        return newPercentage;
    }
}
