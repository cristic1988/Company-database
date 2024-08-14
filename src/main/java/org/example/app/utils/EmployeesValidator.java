package org.example.app.utils;

import java.util.HashMap;
import java.util.Map;

public class EmployeesValidator {

    public Map<String, String> validateEmployeesData(Map<String, String> data) {

        Map<String, String> errors = new HashMap<>();

        if (data.containsKey("id") & AppValidator.isIdValid(data.get("id")))
            errors.put("id", Constants.WRONG_ID_MSG);

        if (data.containsKey("name")) {
            if (data.get("name") != null & data.get("name").isEmpty())
                errors.put("name", Constants.INPUT_REQ_MSG);
        }

        if (data.containsKey("age")) {
            if (data.get("age") != null & data.get("age").isEmpty())
                errors.put("age", Constants.INPUT_REQ_MSG);
        }

        if (data.containsKey("position ")) {
            if (data.get("position ") != null & data.get("position ").isEmpty())
                errors.put("position ", Constants.INPUT_REQ_MSG);
        }

        if (data.containsKey("salary  ")) {
            if (data.get("salary  ") != null & data.get("salary  ").isEmpty())
                errors.put("salary  ", Constants.WRONG_SALARY_MSG);
        }

        return errors;
    }
}
