package models;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Person {

    /**
     * Age of the person
     *
     * @param age New value for this person's age.
     * @return The current value of this person's age.
     */
    private int age = 10;
    /**
     * Name of the person
     *
     * @param name New value for this person's name.
     * @return The current value of this person's name.
     */
    private String name;

}
