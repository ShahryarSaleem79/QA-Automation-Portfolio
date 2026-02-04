package retry;

import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import utils.LoggerUtil;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 1; // retry once
    private static final Logger logger = LoggerUtil.getLogger(RetryAnalyzer.class);
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
        	logger.warn("Retrying test: " + result.getMethod().getMethodName() + 
                    " | Attempt: " + (retryCount + 1));

            retryCount++;
            return true;
        }
        return false;
    }
}