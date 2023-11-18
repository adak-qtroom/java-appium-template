package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@Listeners(BasePage.TestListener.class)
public class BasePage {
    public static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    public static AppiumDriver driver;

    @BeforeClass
    public void configurationSetup() throws MalformedURLException {
        LOGGER.info("configuring appium server parameters and connecting via driver...");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, "https://ebcom.ir/static/mymci/mymci.apk");
        capabilities.setCapability("appPackage", "ir.mci.ecareapp");
        capabilities.setCapability("appActivity", "ir.mci.ecareapp.ui.activity.LauncherActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RF8W201TDWB");
        capabilities.setCapability("udid", "RF8W201TDWB");
        driver = new AndroidDriver(new URL("http://192.168.2.171:31337/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }

    public static class TestListener implements ITestListener {
        @Override
        public void onTestStart(ITestResult result) {
            LOGGER.info("Test Started: " + result.getName());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            LOGGER.info("Test Passed: " + result.getName());
        }

        @Override
        public void onTestFailure(ITestResult result) {
            LOGGER.info("Test Failed: " + result.getName());
            captureScreenshot(result.getMethod().getMethodName());
        }

       private void captureScreenshot(String methodName1) {
            LoggingUtils.logBase64(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64), methodName1);
        }

        private String getCurrentTimestamp() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            return dateFormat.format(new Date());
        }


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            ((AndroidDriver) driver).closeApp();
            driver.quit();
        }
    }
}
