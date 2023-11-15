package tests;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.appium.java_client.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.net.*;
import java.net.http.*;

@Listeners({ReportPortalTestNGListener.class})
public class SuitTest extends BasePage {
    public static final Logger LOGGER = LoggerFactory.getLogger(SuitTest.class);

    @BeforeEach
    public void beforeEach() {
        //!@beforeEach
    }

    //!@testSuit

    @AfterEach
    public void afterEach() {
        //!@afterEach
    }
}
