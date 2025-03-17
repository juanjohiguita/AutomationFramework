package core.listeners;

import core.pages.basePage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener, IExecutionListener{

    @Override
    public void onExecutionStart() {
        IExecutionListener.super.onExecutionStart();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String filename = System.getProperty("user.dir") + File.separator
                + "screenshots" + File.separator + result.getMethod().getMethodName();
        File file = ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File(filename+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
