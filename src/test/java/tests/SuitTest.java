package tests;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ReportPortalTestNGListener.class})
public class SuitTest extends BasePage {
    public static final Logger LOGGER = LoggerFactory.getLogger(SuitTest.class);

   //!@testSuit
}