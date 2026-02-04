package listeners;

import driver.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        //saveScreenshot();
    	attachStepScreenshot();
    }

//    @Attachment(value = "Screenshot on Failure", type = "image/png")
//    public byte[] saveScreenshot() {
//        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
//    }
    @Attachment(value = "Step Screenshot", type = "image/png")
    public byte[] attachStepScreenshot() {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
