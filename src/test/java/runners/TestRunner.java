package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/features", glue = {"steps"},

tags = "@tag1"

// "(@tag1 and @tag2) or @tag3",
		
//	plugin = {
			
     //   "pretty",                                   // Format the console output
      //  "html:target/cucumber-reports.html",         // HTML report
       // "json:target/cucumber-reports.json",         // JSON report
        //"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Allure report
              
  //  }
			
		)

public class TestRunner {
    // No additional code is needed here; JUnit will automatically run the tests
	
	
	
}


   


