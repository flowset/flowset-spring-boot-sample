package io.flowset.springbootsample.delegate;

import io.flowset.springbootsample.utils.DatafakerUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static io.flowset.springbootsample.variable.VariableConstants.*;

@Component
public class FillingDataRandomDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws InterruptedException {
        // 15-second delay
        Thread.sleep(10000);

        Map<String, String> variables = new HashMap<>();
        variables.put(LAST_NAME, DatafakerUtils.getName().lastName());
        variables.put(FIRST_NAME, DatafakerUtils.getName().firstName());
        variables.put(EMAIL, DatafakerUtils.getInternet().emailAddress());
        variables.put(PHONE, DatafakerUtils.getPhone().phoneNumber());
        variables.put(ADDRESS, DatafakerUtils.getAddress().fullAddress());

        execution.setVariables(variables);
    }
}