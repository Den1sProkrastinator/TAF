package models;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class MilestoneBuilder {
    String name ="denis";
    String reference;
    String description;
    String startDate;
    String endDate;

    String milestoneName;
}
