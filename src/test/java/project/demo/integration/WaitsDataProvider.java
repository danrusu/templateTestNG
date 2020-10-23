package project.demo.integration;

import org.testng.annotations.DataProvider;

public class WaitsDataProvider {

    @DataProvider(
            name = "wait-provider",
            parallel = true
    )
    public Object[][] waitProvider(){
        return new Object[][]{
                { 1 },
                { 2 },
                { 3 },
                { 4 },
                { 5 },

                { 5 },
                { 5 },
                { 5 },
                { 5 },
                { 5 }
        };
    }
}
