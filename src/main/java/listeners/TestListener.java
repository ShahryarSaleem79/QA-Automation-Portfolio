package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverFactory;

public class TestListener implements ITestListener {

    private static final Logger logger = LoggerUtil.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
        logger.info("===== Test Suite Started: " + context.getName() + " =====");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("===== Test Suite Finished: " + context.getName() + " =====");
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("---- Test Started: " + result.getMethod().getMethodName() + " ----");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("✔ Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("✘ Test Failed: " + result.getMethod().getMethodName());
        saveScreenshot();
        saveTextLog("Test failed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("⚠ Test Skipped: " + result.getMethod().getMethodName());
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        try {
            return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            logger.error("Failed to capture screenshot", e);
            return new byte[0];
        }
    }

    @Attachment(value = "Log", type = "text/plain")
    public String saveTextLog(String message) {
        return message;
    }
}