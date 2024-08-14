package org.example.app.service;

import org.example.app.entity.Employees;
import org.example.app.entity.EmployeesMapper;
import org.example.app.exceptions.EmployeesException;
import org.example.app.repository.impl.EmployeesRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.EmployeesValidator;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeesService {

    EmployeesRepository repository = new EmployeesRepository();

    public String create(Map<String, String> data) {
        Map<String, String> errors =
                new EmployeesValidator().validateEmployeesData(data);
        if (!errors.isEmpty()) {
            try {
                throw new EmployeesException("Check inputs", errors);
            } catch (EmployeesException e) {
                return e.getErrors(errors);
            }
        }
        return repository.create(new EmployeesMapper().mapData(data));
    }

    public String read() {
        Optional<List<Employees>> optional = repository.read();
        if (optional.isPresent()) {
            List<Employees> list = optional.get();
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder sb = new StringBuilder();
                list.forEach((contact) ->
                        sb.append(count.incrementAndGet())
                                .append(") ")
                                .append(contact.toString())
                );
                return sb.toString();
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }

    public String update(Map<String, String> data) {
        Map<String, String> errors =
                new EmployeesValidator().validateEmployeesData(data);
        if (!errors.isEmpty()) {
            try {
                throw new EmployeesException("Check inputs", errors);
            } catch (EmployeesException e) {
                return e.getErrors(errors);
            }
        }
        return repository.update(new EmployeesMapper().mapData(data));
    }

    public String delete(Map<String, String> data) {
        Map<String, String> errors =
                new EmployeesValidator().validateEmployeesData(data);
        if (!errors.isEmpty()) {
            try {
                throw new EmployeesException("Check inputs", errors);
            } catch (EmployeesException e) {
                return e.getErrors(errors);
            }
        }
        return repository.delete(new EmployeesMapper().mapData(data).getId());
    }

    public String readById(Map<String, String> data) {
        Map<String, String> errors =
                new EmployeesValidator().validateEmployeesData(data);
        if (!errors.isEmpty()) {
            try {
                throw new EmployeesException("Check inputs", errors);
            } catch (EmployeesException e) {
                return e.getErrors(errors);
            }
        }

        Optional<Employees> optional =
                repository.readById(Long.parseLong(data.get("id")));

        if (optional.isPresent()) {
            Employees employees = optional.get();
            return employees.toString();
        } else return Constants.DATA_ABSENT_MSG;
    }
}
