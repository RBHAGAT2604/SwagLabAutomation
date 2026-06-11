package test_Runner;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
import listeners.MyListeners;

@Listeners(MyListeners.class)

@CucumberOptions(
		features = "src/test/resources/swagLabFeatueFile",
		glue ={"stepDefinations"},
		dryRun = false,
		plugin = { "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }
		)

public class Test_Runner extends AbstractTestNGCucumberTests{

}
