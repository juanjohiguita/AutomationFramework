package utils.constants;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
    private int count = 0;
    private int retryCount = 1;

    public boolean retry(ITestResult iTestResult) {
        while (count<retryCount) {
            count++;
            return true;
        }
        return false;
    }
}
