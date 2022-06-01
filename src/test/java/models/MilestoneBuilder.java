package models;

public class MilestoneBuilder {
    private String name;
    private String reference;
    private String description;
    private String startDate;
    private String endDate;

    public static class Builder{
        private MilestoneBuilder newMilestone;

        public Builder() {
            newMilestone = new MilestoneBuilder();
        }


        public Builder withName(String name){
            newMilestone.name = name;
            return this;
        }

        public Builder withReference(String reference){
            newMilestone.reference = reference;
            return this;
        }

        public Builder withDescription(String  description){
            newMilestone. description =  description;
            return this;
        }
        public Builder withStartDate(String startDate){
            newMilestone.startDate = startDate;
            return this;
        }
        public Builder withEndDate(String endDate){
            newMilestone.endDate = endDate;
            return this;
        }

        public MilestoneBuilder build(){
            return  newMilestone;
        }
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
