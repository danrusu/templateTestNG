package end2end;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ro.qatools.base.Person;

import static org.assertj.core.api.Assertions.assertThat;


public class End2EndTest {
    private Person person;

    @BeforeClass
    public void beforeClass(){
        person = new Person("John", "Doe", 30, false);
    }

    @Test(
            groups = { "end2end" }
    )
    public void end2endTest(){
        System.out.println("end2end test");
        assertThat(person.getFullName()).isEqualTo("John Doe");
    }
}
