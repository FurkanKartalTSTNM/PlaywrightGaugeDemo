package com.testinium.gaugeplaywright.support;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterStep;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.ExecutionContext;
import com.thoughtworks.gauge.Gauge;

import java.io.IOException;
import java.nio.file.Path;

public class PlaywrightHooks {

    @BeforeSuite
    public void beforeSuite() {
        PlaywrightRuntime.launchBrowser();

        // 1. COMMAND_PARAMETER
        String demoParam = System.getProperty("demo");
        // 2. ENVIRONMENT_PARAMETER
        String denemeParam = System.getenv("deneme");

        // 1. COMMAND_PARAMETER
        String demoParam2 = System.getProperty("demo2");
        // 2. ENVIRONMENT_PARAMETER
        String denemeParam2 = System.getenv("deneme2");

        System.out.println(">>> [COMMAND_PARAMETER] demo: " + demoParam);
        System.out.println(">>> [ENVIRONMENT_PARAMETER] deneme: " + denemeParam);

        System.out.println(">>> [COMMAND_PARAMETER] demo2: " + demoParam2);
        System.out.println(">>> [ENVIRONMENT_PARAMETER] deneme2: " + denemeParam2);

        String scenarioIDValue = System.getenv("SCENARIO_ID");
        String executionIDValue = System.getenv("EXECUTION_ID");
        String testResultIDValue = System.getenv("TEST_RESULT_ID");

        System.out.println(">>> [SCENARIO_ID] : " + scenarioIDValue);
        System.out.println(">>> [EXECUTION_ID] : " + executionIDValue);
        System.out.println(">>> [TEST_RESULT_ID] : " + testResultIDValue);
    }

    @AfterSuite
    public void afterSuite() {
        PlaywrightRuntime.shutdownBrowser();
    }

    @BeforeScenario
    public void beforeScenario(ExecutionContext context) throws IOException {
        PlaywrightRuntime.startScenario(context.getCurrentScenario().getName());
    }

    @AfterStep
    public void afterStep() {
        Path screenshotPath = PlaywrightRuntime.captureCurrentStep();
        Gauge.writeMessage("Step screenshot: %s", screenshotPath.toString());
    }

    @AfterScenario
    public void afterScenario() {
        PlaywrightRuntime.finishScenario();
    }
}
