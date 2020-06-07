package CucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class) 
@CucumberOptions(
		features = "src\\test\\java\\features\\APITesting.feature",
		glue="StepDefinitions"
		
		) 
public class TestRunner extends AbstractTestNGCucumberTests{}
