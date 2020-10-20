package ro.qatools.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final boolean isEmployed;

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
