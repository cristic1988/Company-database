package org.example.app.entity;

import java.util.Map;

public class EmployeesMapper {

    public Employees mapData(Map<String, String> data) {
        Employees employees = new Employees();
        if (data.containsKey("id"))
            employees.setId(Long.parseLong(data.get("id")));
        if (data.containsKey("name"))
            employees.setName(data.get("name"));
        if (data.containsKey("age"))
            employees.setAge(Integer.parseInt(data.get("age")));
        if (data.containsKey("position"))
            employees.setPosition(data.get("position"));
        if (data.containsKey("salary"))
            employees.setSalary((int) Double.parseDouble(data.get("salary")));
        return employees;
    }
}
