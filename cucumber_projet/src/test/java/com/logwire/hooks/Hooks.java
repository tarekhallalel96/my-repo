package com.logwire.hooks;

import com.logwire.tools.WebdriverTool;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void beforEachScenario() {
        WebdriverTool.setupDriver();
    }

    @After
    public void afterEachScenarion() {
        WebdriverTool.tearDown();
    }
}
