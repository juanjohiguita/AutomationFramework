package core.elememts;

import core.pages.basePage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class SuiteListener implements ITestListener, IAnnotationTransformer {

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
