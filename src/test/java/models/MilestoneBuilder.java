package models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
@Getter
@Builder
@ToString
public class MilestoneBuilder {
    /**
     * Name of the milestone
     *
     * @param name New value for this milestone's name.
     * @return The current value of this milestone's name.
     */
    String name ;

    /**
     * Reference of the milestone
     *
     * References: Introduction
     * TestRail can be integrated with almost any web-based requirement management
     *
     * @param reference New value for this milestone's reference.
     * @return The current value of this milestone's reference.
     */
    String reference;

    /**
     * Description of the milestone
     *
     * Use this description to describe the purpose and goals of this milestone.
     *
     * @param description New value for this milestone's description.
     * @return The current value of this milestone's description.
     */
    String description;

    /**
     * Start Date of the milestone
     *
     * The expected or scheduled start date of this milestone (for upcoming and not yet active milestones).
     *
     * @param name New value for this milestone's start date.
     * @return The current value of this milestone's start date.
     */
    String startDate;

    /**
     * End Date of the milestone
     *
     * The expected due or end date of this milestone.
     *
     * @param name New value for this milestone's end date.
     * @return The current value of this milestone's end date.
     */
    String endDate;

    /**
     * Name of an existing milestone.
     *
     *
     * @param name New value for this milestone's .
     * @return The current value of this milestone's .
     */
    String milestoneName;
}
