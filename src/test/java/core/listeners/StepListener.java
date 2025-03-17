package core.listeners;

import core.pages.basePage.BasePage;
import io.qameta.allure.model.StepResult;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

@Slf4j
public class StepListener implements LifecycleListener {

    @Override
    @SneakyThrows
    public void beforeStepStop(final StepResult result) {

    }

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
