package com.testinium.gaugeplaywright.support;

import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;

public class PlaywrightScreenshot implements ICustomScreenshotGrabber {

    @Override
    public byte[] takeScreenshot() {
        return PlaywrightRuntime.captureScreenshotBytes();
    }
}
