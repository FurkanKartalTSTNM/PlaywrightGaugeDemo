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
