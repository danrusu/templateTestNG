package ro.qatools.base;

import org.testng.annotations.Test;

public class UnitTest {

    @Test(
            groups = { "unit" }
    )
    public void unitTest(){
        System.out.println("unit test");
    }
}
