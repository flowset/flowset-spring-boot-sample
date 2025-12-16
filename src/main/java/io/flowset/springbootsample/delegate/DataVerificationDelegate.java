package io.flowset.springbootsample.delegate;

import io.flowset.springbootsample.utils.DatafakerUtils;
import io.flowset.springbootsample.variable.VariableConstants;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class DataVerificationDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws InterruptedException {
        // 15-second delay
        Thread.sleep(10000);

        int score = DatafakerUtils.getCreditScore();
        execution.setVariable(VariableConstants.CREDIT_SCORE, score);
    }
}