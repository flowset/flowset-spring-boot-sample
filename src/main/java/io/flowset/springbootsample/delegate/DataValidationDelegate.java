package io.flowset.springbootsample.delegate;

import io.flowset.springbootsample.utils.EmailUtils;
import io.flowset.springbootsample.variable.VariableConstants;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class DataValidationDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws InterruptedException {
        // 15-second delay
        Thread.sleep(10000);

        String email = (String) execution.getVariable(VariableConstants.EMAIL);
        if (!EmailUtils.isValidEmail(email)) {
            throw new RuntimeException("Invalid email address");
        }

        String firstName = (String) execution.getVariable(VariableConstants.FIRST_NAME);
        if (firstName == null || firstName.isEmpty()) {
            throw new RuntimeException("Invalid first name");
        }

        String lastName = (String) execution.getVariable(VariableConstants.LAST_NAME);
        if (lastName == null || lastName.isEmpty()) {
            throw new RuntimeException("Invalid last name");
        }

        String phone = (String) execution.getVariable(VariableConstants.PHONE);
        if (phone == null) {
            throw new RuntimeException("Invalid phone number");
        }

        String address = (String) execution.getVariable(VariableConstants.ADDRESS);
        if (address == null || address.isEmpty()) {
            throw new RuntimeException("Invalid address");
        }
    }
}